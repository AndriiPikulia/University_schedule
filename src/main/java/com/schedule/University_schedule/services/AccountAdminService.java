package com.schedule.University_schedule.services;

import com.schedule.University_schedule.domains.Account;
import com.schedule.University_schedule.domains.Department;
import com.schedule.University_schedule.domains.Specialty;
import com.schedule.University_schedule.dtos.AccountDto;
import com.schedule.University_schedule.exceptions.AccountException;
import com.schedule.University_schedule.mappers.AccountMapper;
import com.schedule.University_schedule.mappers.UserNameMapper;
import com.schedule.University_schedule.repositories.AccountRepository;
import com.schedule.University_schedule.requests.AccountAdminCreationRequest;
import com.schedule.University_schedule.requests.AccountAdminUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Validated
public class AccountAdminService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final DepartmentService departmentService;
    private final SpecialtyService specialtyService;
    private final UserNameMapper userNameMapper;

    public AccountDto create(@Valid AccountAdminCreationRequest accountRequest) {
        List<Department> departments = departmentService.getByIds(accountRequest.departmentIds());
        List<Specialty> specialties = specialtyService.getByIds(accountRequest.specialtyIds());
        Account account = new Account();
        account.setEmail(accountRequest.email());
        account.setPassword(accountRequest.password());
        account.setUserName(userNameMapper.toDomain(accountRequest.userName()));
        account.setAccessLevel(accountRequest.accessLevel());
        account.setSpecialties(specialties);
        account.setDepartments(departments);

        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toDtos(accounts);
    }

    public Account getById(Long id) {
        AccountException exception = new AccountException("Account not found");
        return accountRepository.findById(id).orElseThrow(() -> exception);
    }

    public AccountDto update(@Valid AccountAdminUpdateRequest updateRequest, Long id) {
        Account account = getById(id);

        updateIfNotNull(updateRequest.email(), account::setEmail);
        updateIfNotNull(updateRequest.password(), account::setPassword);
        updateIfNotNull(updateRequest.userName(), userName -> account.setUserName(userNameMapper.toDomain(userName)));
        updateIfNotNull(updateRequest.accessLevel(), account::setAccessLevel);

        if (updateRequest.specialtyIds() != null) {
            List<Specialty> specialties = specialtyService.getByIds(updateRequest.specialtyIds());
            account.setSpecialties(specialties);
        }
        if (updateRequest.departmentIds() != null) {
            List<Department> departments = departmentService.getByIds(updateRequest.departmentIds());
            account.setDepartments(departments);
        }

        accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    private <T> void updateIfNotNull(T newValue, Consumer<T> setter) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    public ResponseEntity<List<AccountDto>> findAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = accountMapper.toDtos(accounts);
        return ResponseEntity.ok(accountDtos);
    }

    public ResponseEntity<AccountDto> findById(@PathVariable Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.map(value -> ResponseEntity.ok(accountMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}