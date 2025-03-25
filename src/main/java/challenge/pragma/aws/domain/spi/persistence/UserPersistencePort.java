package challenge.pragma.aws.domain.spi.persistence;


import challenge.pragma.aws.domain.model.User;

public interface UserPersistencePort {
    User saveUser(User user);
    User findByIdentityDocument(String identityDocument);
    User findByEmail(String email);
    User findById(String id);
}
