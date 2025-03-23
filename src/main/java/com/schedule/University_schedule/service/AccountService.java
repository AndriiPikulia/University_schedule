package com.schedule.University_schedule.service;

import com.schedule.University_schedule.entity.Account;
import com.schedule.University_schedule.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
    }

    public Account updateAccount(Account updatedAccount, Long id) {
        Account existingAccount = getAccountById(id);

        existingAccount.setEmail(updatedAccount.getEmail());
        existingAccount.setPassword(updatedAccount.getPassword());
        existingAccount.setUserName(updatedAccount.getUserName());
        existingAccount.setSpecialties(updatedAccount.getSpecialties());
        existingAccount.setDepartments(updatedAccount.getDepartments());

        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id) {
        if(!accountRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }
}
