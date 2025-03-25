package challenge.pragma.aws.infrastructure.output.jpa.adapter;

import challenge.pragma.aws.domain.model.User;
import challenge.pragma.aws.infrastructure.output.jpa.entity.UserEntity;
import challenge.pragma.aws.infrastructure.output.jpa.mapper.UserEntityMapper;
import challenge.pragma.aws.infrastructure.output.jpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserJpaAdapterTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @InjectMocks
    private UserJpaAdapter userJpaAdapter;

    private User user;
    private UserEntity userEntity;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id("1")
                .identityDocument("1234567890")
                .name("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .build();

        userEntity = UserEntity.builder()
                .id("1")
                .identityDocument("1234567890")
                .name("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .build();
    }

    @Test
    void testSaveUserSuccessfully() {
        when(userEntityMapper.toEntity(any(User.class))).thenReturn(userEntity);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userEntityMapper.toDomain(any(UserEntity.class))).thenReturn(user);

        User savedUser = userJpaAdapter.saveUser(user);

        assertNotNull(savedUser);
        assertEquals(user.getIdentityDocument(), savedUser.getIdentityDocument());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    void testFindByIdentityDocumentSuccessfully() {
        when(userRepository.findByIdentityDocument("1234567890")).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toDomain(userEntity)).thenReturn(user);

        User foundUser = userJpaAdapter.findByIdentityDocument("1234567890");

        assertNotNull(foundUser);
        assertEquals(user.getIdentityDocument(), foundUser.getIdentityDocument());
    }

    @Test
    void testFindByIdentityDocumentNotFound() {
        when(userRepository.findByIdentityDocument("1234567890")).thenReturn(Optional.empty());

        User foundUser = userJpaAdapter.findByIdentityDocument("1234567890");

        assertNull(foundUser);
    }

    @Test
    void testFindByEmailSuccessfully() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toDomain(userEntity)).thenReturn(user);

        User foundUser = userJpaAdapter.findByEmail("john.doe@example.com");

        assertNotNull(foundUser);
        assertEquals(user.getEmail(), foundUser.getEmail());
    }

    @Test
    void testFindByEmailNotFound() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(Optional.empty());

        User foundUser = userJpaAdapter.findByEmail("john.doe@example.com");

        assertNull(foundUser);
    }

    @Test
    void testFindByIdSuccessfully() {
        when(userRepository.findById("1")).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toDomain(userEntity)).thenReturn(user);

        User foundUser = userJpaAdapter.findById("1");

        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        User foundUser = userJpaAdapter.findById("1");

        assertNull(foundUser);
    }
}
