package me.motyim.learn.swaggerserver.exception;

import me.motyim.learn.swaggerserver.enums.ExceptionCode;

/**
 * this is a custome exception <b>kter 5erk</b>
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see 'www.motyim.me'
 * @since 11/12/2018
 */
public class CustomException extends RuntimeException {


    private int code;


    public CustomException() {
    }

    public CustomException(int code) {
        this.code = code;
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public CustomException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CustomException(ExceptionCode exceptionCode){
        this(exceptionCode.getMessage(),exceptionCode.getCode());
    }

    public CustomException(ExceptionCode exceptionCode,Throwable cause){
        this(exceptionCode.getMessage(),cause,exceptionCode.getCode());
    }
}
