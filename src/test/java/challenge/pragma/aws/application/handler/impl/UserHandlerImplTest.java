package challenge.pragma.aws.application.handler.impl;

import challenge.pragma.aws.application.dto.request.UserRequest;
import challenge.pragma.aws.application.dto.response.UserResponse;
import challenge.pragma.aws.application.mapper.request.UserRequestMapper;
import challenge.pragma.aws.application.mapper.response.UserResponseMapper;
import challenge.pragma.aws.domain.api.UserServicePort;
import challenge.pragma.aws.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserHandlerTest {

    @Mock
    private UserServicePort userServicePort;

    @Mock
    private UserRequestMapper userRequestMapper;

    @Mock
    private UserResponseMapper userResponseMapper;

    @InjectMocks
    private UserHandlerImpl userHandler;

    private UserRequest userRequest;
    private UserResponse userResponse;
    private User user;

    @BeforeEach
    void setUp() {
        userRequest = UserRequest.builder()
                .identityDocument("1234567890")
                .name("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .build();

        user = User.builder()
                .identityDocument("1234567890")
                .name("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .build();

        userResponse = UserResponse.builder()
                .identityDocument("1234567890")
                .name("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .build();
    }

    @Test
    void testCreateUser() {
        when(userRequestMapper.toDomain(any(UserRequest.class))).thenReturn(user);
        when(userServicePort.createUser(any(User.class))).thenReturn(user);
        when(userResponseMapper.toResponse(any(User.class))).thenReturn(userResponse);

        UserResponse response = userHandler.createUser(userRequest);

        assertNotNull(response);
        assertEquals(userResponse.getIdentityDocument(), response.getIdentityDocument());
        assertEquals(userResponse.getName(), response.getName());
        assertEquals(userResponse.getLastname(), response.getLastname());
        assertEquals(userResponse.getEmail(), response.getEmail());
    }

    @Test
    void testGetById() {
        when(userServicePort.findById("1234567890")).thenReturn(user);
        when(userResponseMapper.toResponse(any(User.class))).thenReturn(userResponse);

        UserResponse response = userHandler.getById("1234567890");

        assertNotNull(response);
        assertEquals(userResponse.getIdentityDocument(), response.getIdentityDocument());
        assertEquals(userResponse.getName(), response.getName());
        assertEquals(userResponse.getLastname(), response.getLastname());
        assertEquals(userResponse.getEmail(), response.getEmail());
    }
}