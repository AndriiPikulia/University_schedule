package com.schedule.University_schedule.mappers;

import com.schedule.University_schedule.domains.UserName;
import com.schedule.University_schedule.dtos.UserNameDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserNameMapper extends BaseMapper<UserName, UserNameDto>{

}
