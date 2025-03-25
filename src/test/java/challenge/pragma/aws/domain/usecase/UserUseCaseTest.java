package challenge.pragma.aws.domain.usecase;

import challenge.pragma.aws.domain.exception.EntityAlreadyExistsException;
import challenge.pragma.aws.domain.exception.EntityNotFoundException;
import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.domain.spi.persistence.UserPersistencePort;
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
class UserUseCaseTest {

    @Mock
    private UserPersistencePort userPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id("1")
                .identityDocument("1234567890")
                .name("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .build();
    }

    @Test
    void testCreateUserSuccessfully() {
        when(userPersistencePort.findByIdentityDocument(user.getIdentityDocument())).thenReturn(null);
        when(userPersistencePort.findByEmail(user.getEmail())).thenReturn(null);
        when(userPersistencePort.saveUser(any(User.class))).thenReturn(user);

        User createdUser = userUseCase.createUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getIdentityDocument(), createdUser.getIdentityDocument());
        assertEquals(user.getEmail(), createdUser.getEmail());
    }

    @Test
    void testCreateUserWithExistingIdentityDocument() {
        when(userPersistencePort.findByIdentityDocument(user.getIdentityDocument())).thenReturn(user);

        assertThrows(EntityAlreadyExistsException.class, () -> userUseCase.createUser(user));
    }

    @Test
    void testCreateUserWithExistingEmail() {
        when(userPersistencePort.findByIdentityDocument(user.getIdentityDocument())).thenReturn(null);
        when(userPersistencePort.findByEmail(user.getEmail())).thenReturn(user);

        assertThrows(EntityAlreadyExistsException.class, () -> userUseCase.createUser(user));
    }

    @Test
    void testFindUserByIdSuccessfully() {
        when(userPersistencePort.findById("1")).thenReturn(user);

        User foundUser = userUseCase.findById("1");

        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void testFindUserByIdNotFound() {
        when(userPersistencePort.findById("1")).thenReturn(null);

        assertThrows(EntityNotFoundException.class, () -> userUseCase.findById("1"));
    }
}
