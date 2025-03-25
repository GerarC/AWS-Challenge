package challenge.pragma.aws.application.mapper.response;

import challenge.pragma.aws.application.dto.response.UserResponse;
import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.domain.util.annotation.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    UserResponse toResponse(User user);
    List<UserResponse> toResponse(List<User> users);
}
