package me.motyim.learn.swaggerserver.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/11/2018
 */
@Configuration
public class Dozerconfig {

    @Bean
    DozerBeanMapper registerDozerMapper(){
        return new DozerBeanMapper();
    }
}
