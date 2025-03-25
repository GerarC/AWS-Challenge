package challenge.pragma.aws.infrastructure.output.jpa.mapper;

import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.domain.util.annotation.Generated;
import challenge.pragma.aws.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Generated
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    List<UserEntity> toEntities(List<User> users);
    User toDomain(UserEntity entity);
}
