package me.motyim.learn.spring.websocket.message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 26-Feb-18
 */
public class LoginResponse {

    private String record;

    public LoginResponse(String name) {
        this.record = String.format("Employe %S Login @ %s", name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    public String getRecord() {
        return record;
    }

}
