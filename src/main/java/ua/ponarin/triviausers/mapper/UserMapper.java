package ua.ponarin.triviausers.mapper;

import org.mapstruct.Mapper;
import ua.ponarin.triviausers.dto.User;
import ua.ponarin.triviausers.model.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
}
