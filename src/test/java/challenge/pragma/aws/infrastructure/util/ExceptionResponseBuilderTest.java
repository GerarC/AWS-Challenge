package challenge.pragma.aws.infrastructure.util;

import challenge.pragma.aws.infrastructure.configuration.advisor.response.ExceptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionResponseBuilderTest {

    @Test
    void testBuildResponse() {
        RuntimeException exception = new RuntimeException("Test Exception");
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ResponseEntity<ExceptionResponse> responseEntity = ExceptionResponseBuilder.buildResponse(exception, status);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Test Exception", Objects.requireNonNull(responseEntity.getBody()).getMessage());
        assertEquals(status, responseEntity.getBody().getStatus());
        assertNotNull(responseEntity.getBody().getTimestamp());
    }
}
