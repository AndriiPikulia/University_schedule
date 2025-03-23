package com.schedule.University_schedule.services;

import com.schedule.University_schedule.domains.Account;
import com.schedule.University_schedule.domains.Department;
import com.schedule.University_schedule.domains.Specialty;
import com.schedule.University_schedule.dtos.AccountDto;
import com.schedule.University_schedule.mappers.AccountMapper;
import com.schedule.University_schedule.mappers.UserNameMapper;
import com.schedule.University_schedule.repositories.AccountRepository;
import com.schedule.University_schedule.requests.AccountAdminCreationRequest;
import com.schedule.University_schedule.requests.AccountAdminUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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
        return accountMapper.toDtos(accountRepository.findAll());
    }

    public Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public AccountDto update(@Valid AccountAdminUpdateRequest updateRequest, Long id) {
        List<Department> departments = departmentService.getByIds(updateRequest.departmentIds());
        List<Specialty> specialties = specialtyService.getByIds(updateRequest.specialtyIds());
        Account account;
        account = getById(id);
        account.setEmail(updateRequest.email());
        account.setPassword(updateRequest.password());
        account.setUserName(userNameMapper.toDomain(updateRequest.userName()));
        account.setAccessLevel(updateRequest.accessLevel());
        account.setSpecialties(specialties);
        account.setDepartments(departments);

        accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    public void delete(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }
}
