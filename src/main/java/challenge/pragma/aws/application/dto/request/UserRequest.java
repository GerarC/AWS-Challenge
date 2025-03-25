package challenge.pragma.aws.application.dto.request;

import challenge.pragma.aws.application.util.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    @NotNull(message = AppConstants.IDENTITY_DOCUMENT_FIELD_NOT_NULL)
    @Pattern(regexp = AppConstants.IDENTITY_DOCUMENT_REGEX, message = AppConstants.WRONG_IDENTITY_DOCUMENT_FORMAT)
    private String identityDocument;

    @NotNull(message = AppConstants.NAME_FIELD_NOT_NULL)
    private String name;

    @NotNull(message = AppConstants.LASTNAME_FIELD_NOT_NULL)
    private String lastname;

    @NotNull(message = AppConstants.EMAIL_FIELD_NOT_NULL)
    @Pattern(regexp = AppConstants.EMAIL_ADDRESS_REGEX, message = AppConstants.WRONG_EMAIL_FORMAT)
    private String email;
}
