package challenge.pragma.aws.application.mapper.request;

import challenge.pragma.aws.application.dto.request.UserRequest;
import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.domain.util.annotation.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toDomain(UserRequest owner);
    List<User> toDomains(List<UserRequest> owners);
}
