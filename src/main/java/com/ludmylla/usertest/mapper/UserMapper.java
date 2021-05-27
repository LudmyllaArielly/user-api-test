package com.ludmylla.usertest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ludmylla.usertest.model.entities.User;
import com.ludmylla.usertest.model.entities.dto.UserCreateDTO;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE =Mappers.getMapper(UserMapper.class);
	
	User toUser (UserCreateDTO source);

}
