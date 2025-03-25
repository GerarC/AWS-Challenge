package challenge.pragma.aws.infrastructure.input.rest.v1;

import challenge.pragma.aws.application.dto.request.UserRequest;
import challenge.pragma.aws.application.dto.response.UserResponse;
import challenge.pragma.aws.application.handler.UserHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserHandler userHandler;

    @Autowired
    private ObjectMapper objectMapper;

    private UserRequest userRequest;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        userRequest = UserRequest.builder()
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
    void testCreateUser() throws Exception {
        when(userHandler.createUser(any(UserRequest.class))).thenReturn(userResponse);

        mockMvc.perform(post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.identityDocument").value(userResponse.getIdentityDocument()))
                .andExpect(jsonPath("$.name").value(userResponse.getName()))
                .andExpect(jsonPath("$.lastname").value(userResponse.getLastname()))
                .andExpect(jsonPath("$.email").value(userResponse.getEmail()));
    }

    @Test
    void testGetUserById() throws Exception {
        when(userHandler.getById("1234567890")).thenReturn(userResponse);

        mockMvc.perform(get("/v1/users/{id}", "1234567890")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identityDocument").value(userResponse.getIdentityDocument()))
                .andExpect(jsonPath("$.name").value(userResponse.getName()))
                .andExpect(jsonPath("$.lastname").value(userResponse.getLastname()))
                .andExpect(jsonPath("$.email").value(userResponse.getEmail()));
    }
}
