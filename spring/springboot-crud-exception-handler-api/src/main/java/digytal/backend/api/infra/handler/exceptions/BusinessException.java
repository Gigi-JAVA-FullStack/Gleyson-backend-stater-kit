package digytal.backend.api.infra.handler.exceptions;

public class BusinessException extends  RuntimeException{
    private String errorCode;
    private int httpStatus;
    public BusinessException(String message, String errorCode,  Object ... params ){
        super(String.format(message, params));
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }

}
