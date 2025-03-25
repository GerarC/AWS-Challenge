package challenge.pragma.aws.infrastructure.util.constant;


import challenge.pragma.aws.domain.util.annotation.Generated;

@Generated
public class RestConstants {

    public static final String SWAGGER_SUMMARY_FIND_A_USER = "Find a user and retrieves just necessary information";
    public static final String SWAGGER_DESCRIPTION_USER_WAS_FOUND = "User was found";

    private RestConstants() {
        throw new IllegalStateException("Utility Class");
    }
    // API CODES
    public static final String SWAGGER_CODE_CREATED = "201";
    public static final String SWAGGER_CODE_BAD_REQUEST = "400";
    public static final String SWAGGER_CODE_NOT_FOUND = "404";
    public static final String SWAGGER_CODE_CONFLICT = "409";

    // Validations
    public static final String SWAGGER_ERROR_VALIDATIONS_DO_NOT_PASS = "Validations don't pass";

    // HOME
    public static final String SWAGGER_SUMMARY_GET_HOME = "And endpoint to test if app is running";

    // USERS
    public static final String SWAGGER_SUMMARY_CREATE_OWNER = "Create an owner using the given valid info";
    public static final String SWAGGER_DESCRIPTION_CREATED_OWNER = "Owner has been created successfully";
    public static final String SWAGGER_ERROR_USER_WITH_EMAIL_ALREADY_EXISTS = "An user with that email already exists";
    public static final String SWAGGER_ERROR_USER_WITH_ID_ALREADY_EXISTS = "An user with that identity document already exists";
    public static final String SWAGGER_ERROR_USER_UNDER_AGED = "Given user is under aged";
    public static final String SWAGGER_ERROR_USER_DOES_NOT_EXIST = "Requested user doesn't exist";

}
