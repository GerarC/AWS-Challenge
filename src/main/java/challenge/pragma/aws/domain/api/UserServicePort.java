package challenge.pragma.aws.domain.api;


import challenge.pragma.aws.domain.model.User;

public interface UserServicePort {
    User createUser(User user);
    User findById(String id);
}
