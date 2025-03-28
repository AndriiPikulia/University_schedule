package com.schedule.University_schedule.controllers;

import com.schedule.University_schedule.dtos.AccountDto;
import com.schedule.University_schedule.services.AccountAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("accounts")
@RequiredArgsConstructor()
public class AccountController {
    private final AccountAdminService accountAdminService;

    @GetMapping
    //make void return type
    public ResponseEntity<List<AccountDto>> getAccounts(AccountAdminService accountAdminService) {
        return accountAdminService.findAll();
    }

    @GetMapping("/{id}")
    //make void return type
    public ResponseEntity<AccountDto> getAccount(@PathVariable long id) {
        return accountAdminService.findById(id);
    }
}
