package challenge.pragma.aws.domain.util;

import challenge.pragma.aws.domain.util.annotation.Generated;

@Generated
public class DomainConstants {

    private DomainConstants() {
        throw new IllegalStateException("Utility Class");
    }

    public static final Long MINIMUM_VALID_YEARS = 18L;

    // Exception messages
    public static final String UNDER_AGED_USER_MESSAGE = "An actual user cannot be under 18 years old";
    public static final String ENTITY_NOT_FOUND_TEMPLATE_MESSAGE = "Entity of type '%s' with id '%s' has not been found";
    public static final String ROLE_NOT_FOUND_TEMPLATE_MESSAGE = "Role named '%s' hasn't been found";
    public static final String ENTITY_ALREADY_EXISTS_TEMPLATE_MESSAGE = "An entity of type '%s' with id '%s' already exists";
    public static final String USER_WITH_EMAIL_ALREADY_EXIST_TEMPLATE_MESSAGE = "An user with '%s' as email already exists";
    public static final String USER_WITH_IDENTITY_DOCUMENT_ALREADY_EXIST_TEMPLATE_MESSAGE = "An user with '%s' as identity document already exists";
    public static final String USER_WITH_EMAIL_NOT_FOUND_MESSAGE = "Password or Email incorrect";
    public static final String ERROR_REGISTERING_EMPLOYEE_MESSAGE = "An error has occurred registering user in restaurant";

    public static final String INVALID_TOKEN_MESSAGE = "Given token is invalid";
    public static final String EXPIRED_TOKEN_MESSAGE = "Given token has expired";
}
