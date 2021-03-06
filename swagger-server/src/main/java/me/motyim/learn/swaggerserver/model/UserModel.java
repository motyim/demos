package me.motyim.learn.swaggerserver.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/7/2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User")
public class UserModel {
    @ApiModelProperty(hidden = true)
    private Long id;
    @NotBlank
    @Size(min = 3 , max = 20)
    private String name;
    @Positive
    @Min(10)
    @Max(100)
    private int age ;
}
