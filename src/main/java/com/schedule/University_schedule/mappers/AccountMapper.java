package com.schedule.University_schedule.mappers;

import com.schedule.University_schedule.domains.Account;
import com.schedule.University_schedule.dtos.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDto> {

}
