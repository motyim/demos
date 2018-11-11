package me.motyim.learn.swaggerserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    @JsonProperty("status")
    private ResponseEnum responseEnum ;
    private T Data;
}

