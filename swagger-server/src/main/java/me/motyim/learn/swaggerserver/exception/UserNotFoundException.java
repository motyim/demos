package me.motyim.learn.swaggerserver.exception;

import me.motyim.learn.swaggerserver.enums.ExceptionCode;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/12/2018
 */
public class UserNotFoundException extends CustomException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(int code) {
        super(code);
    }

    public UserNotFoundException(String message, int code) {
        super(message, code);
    }

    public UserNotFoundException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }

    public UserNotFoundException(Throwable cause, int code) {
        super(cause, code);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserNotFoundException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public UserNotFoundException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode, cause);
    }
}
