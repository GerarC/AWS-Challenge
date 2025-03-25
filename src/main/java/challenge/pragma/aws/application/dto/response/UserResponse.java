package challenge.pragma.aws.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String identityDocument;
    private String name;
    private String lastname;
    private String email;
}
