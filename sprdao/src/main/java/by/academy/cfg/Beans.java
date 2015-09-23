package by.academy.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Beans {

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }
}
