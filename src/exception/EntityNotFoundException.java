package exception;

public class EntityNotFoundException extends DatabaseException {

public EntityNotFoundException(String message){
    super(message);
}

public EntityNotFoundException(String message, Throwable cause){
    super(message, cause);
};
    
}
