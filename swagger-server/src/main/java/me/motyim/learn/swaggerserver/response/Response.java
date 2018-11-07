package me.motyim.learn.swaggerserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int code ;
    private String message;
    private Object Data;
}

