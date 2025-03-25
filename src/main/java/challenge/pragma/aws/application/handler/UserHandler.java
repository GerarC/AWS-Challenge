package challenge.pragma.aws.application.handler;

import challenge.pragma.aws.application.dto.request.UserRequest;
import challenge.pragma.aws.application.dto.response.UserResponse;

public interface UserHandler {
    UserResponse createUser(UserRequest owner);
    UserResponse getById(String id);
}
