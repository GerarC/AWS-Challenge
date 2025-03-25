package challenge.pragma.aws.infrastructure.output.jpa.adapter;

import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.domain.spi.persistence.UserPersistencePort;
import challenge.pragma.aws.infrastructure.output.jpa.entity.UserEntity;
import challenge.pragma.aws.infrastructure.output.jpa.mapper.UserEntityMapper;
import challenge.pragma.aws.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        log.debug("user: {}", entity);
        return userEntityMapper.toDomain(
                userRepository.save(entity)
        );
    }

    @Override
    public User findByIdentityDocument(String identityDocument) {
        return userEntityMapper.toDomain(
                userRepository.findByIdentityDocument(identityDocument).orElse(null)
        );
    }

    @Override
    public User findByEmail(String email) {
        return userEntityMapper.toDomain(
                userRepository.findByEmail(email).orElse(null)
        );
    }

    @Override
    public User findById(String id) {
        return userEntityMapper.toDomain(
                userRepository.findById(id).orElse(null)
        );
    }
}
