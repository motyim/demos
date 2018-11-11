package me.motyim.learn.swaggerserver.response;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResponseEnum {
    SUCCESS(0 ,"Success Response"),
    ERROR(1 ,"ERROR IN PROCESS"),
    TIMEOUT(2 ,"TIMEOUT FROM SERVER"),
    ERRORINSERVER(3 ,"GENERAL ERROR IN SERVER");

    private int code;
    private String message;
    ResponseEnum(int code , String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
