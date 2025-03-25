package challenge.pragma.aws.infrastructure.configuration;

import challenge.pragma.aws.domain.api.UserServicePort;
import challenge.pragma.aws.domain.spi.persistence.UserPersistencePort;
import challenge.pragma.aws.domain.usecase.UserUseCase;
import challenge.pragma.aws.domain.util.annotation.Generated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
public class BeanConfiguration {
    // Service Ports
    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort
    ){
        return new UserUseCase(
                userPersistencePort
        );
    }
}
