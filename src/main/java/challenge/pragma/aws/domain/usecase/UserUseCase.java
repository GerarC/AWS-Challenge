package challenge.pragma.aws.domain.usecase;


import challenge.pragma.aws.domain.api.UserServicePort;
import challenge.pragma.aws.domain.exception.EntityAlreadyExistsException;
import challenge.pragma.aws.domain.exception.EntityNotFoundException;
import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.domain.spi.persistence.UserPersistencePort;
import challenge.pragma.aws.domain.util.DomainConstants;

public class UserUseCase implements UserServicePort {
    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort ) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User createUser(User user) {
        validateUser(user);
        return userPersistencePort.saveUser(user);
    }

    @Override
    public User findById(String id) {
        User user = userPersistencePort.findById(id);
        if (user == null) throw new EntityNotFoundException(User.class.getSimpleName(), id);
        return user;
    }

    private void validateUser(User user) {
        if (userPersistencePort.findByIdentityDocument(user.getIdentityDocument()) != null)
            throw new EntityAlreadyExistsException(String.format(
                    DomainConstants.USER_WITH_IDENTITY_DOCUMENT_ALREADY_EXIST_TEMPLATE_MESSAGE,
                    user.getIdentityDocument()
            ));
        if (userPersistencePort.findByEmail(user.getEmail()) != null)
            throw new EntityAlreadyExistsException(String.format(
                    DomainConstants.USER_WITH_EMAIL_ALREADY_EXIST_TEMPLATE_MESSAGE,
                    user.getEmail()
            ));
    }


}
