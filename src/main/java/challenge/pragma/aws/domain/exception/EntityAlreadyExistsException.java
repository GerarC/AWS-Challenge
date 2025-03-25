package challenge.pragma.aws.domain.exception;


import challenge.pragma.aws.domain.util.DomainConstants;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public EntityAlreadyExistsException(String className, String id){
        super(String.format(
                DomainConstants.ENTITY_ALREADY_EXISTS_TEMPLATE_MESSAGE,
                className,
                id
        ));
    }
}
