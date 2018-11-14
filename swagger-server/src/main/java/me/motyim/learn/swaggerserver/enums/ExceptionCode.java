package me.motyim.learn.swaggerserver.enums;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/14/2018
 */
public enum ExceptionCode {

    USER_NOT_FOUND("User not found" , 404);

    private String message ;
    private int code ;

    ExceptionCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
