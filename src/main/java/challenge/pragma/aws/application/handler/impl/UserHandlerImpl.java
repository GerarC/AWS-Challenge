package challenge.pragma.aws.application.handler.impl;

import challenge.pragma.aws.application.dto.request.UserRequest;
import challenge.pragma.aws.application.dto.response.UserResponse;
import challenge.pragma.aws.application.handler.UserHandler;
import challenge.pragma.aws.application.mapper.request.UserRequestMapper;
import challenge.pragma.aws.application.mapper.response.UserResponseMapper;
import challenge.pragma.aws.domain.api.UserServicePort;
import challenge.pragma.aws.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler {
    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userRequestMapper.toDomain(request);
        return userResponseMapper.toResponse(
                userServicePort.createUser(user)
        );
    }

    @Override
    public UserResponse getById(String id) {
        return userResponseMapper.toResponse(
                userServicePort.findById(id)
        );
    }
}
