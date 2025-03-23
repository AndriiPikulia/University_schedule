package com.schedule.University_schedule.repositories;

import com.schedule.University_schedule.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long> {
}
