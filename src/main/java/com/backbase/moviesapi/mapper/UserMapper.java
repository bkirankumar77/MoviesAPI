package com.backbase.moviesapi.mapper;


import com.backbase.moviesapi.entity.UserEntity;
import com.backbase.moviesapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User convertToModel(UserEntity userEntity);

}
