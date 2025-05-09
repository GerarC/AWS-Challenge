package challenge.pragma.aws.application.util;

public class AppConstants {
    private AppConstants() {
        throw new IllegalStateException("Utility Class");
    }

    // Regex
    public static final String EMAIL_ADDRESS_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String IDENTITY_DOCUMENT_REGEX = "^\\d{6,16}";

    // Not null messages
    public static final String IDENTITY_DOCUMENT_FIELD_NOT_NULL = "'identity document' field must not be null";
    public static final String NAME_FIELD_NOT_NULL = "'name' field must not be null";
    public static final String LASTNAME_FIELD_NOT_NULL = "'lastname' field must not be null";
    public static final String EMAIL_FIELD_NOT_NULL = "'email' field must not be null";

    // Wrong pattern messages
    public static final String WRONG_EMAIL_FORMAT = "Given email does not match with expected pattern";
    public static final String WRONG_IDENTITY_DOCUMENT_FORMAT = "A document must be a number and be between 6 and 16";
}
