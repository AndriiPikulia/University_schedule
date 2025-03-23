package com.schedule.University_schedule.controllers;

import com.schedule.University_schedule.domains.Account;
import com.schedule.University_schedule.dtos.AccountDto;
import com.schedule.University_schedule.mappers.AccountMapper;
import com.schedule.University_schedule.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = accountMapper.toDtos(accounts);
        return ResponseEntity.ok(accountDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.map(value -> ResponseEntity.ok(accountMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
