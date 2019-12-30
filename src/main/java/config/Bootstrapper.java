package config;

import cache.CacheResolver;
import cache.ICacheResolver;
import database.IRepository;
import database.impl.MockRepository;
import model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.IUserService;
import service.impl.cached.UserServiceCached;
import service.impl.uncached.UserService;


@Configuration
public class Bootstrapper {

    @Bean
    public IRepository<User> userRepository() {

        return new MockRepository<>() {{
            addObject(new User("eduard", "password1"));
            addObject(new User("ionut", "password2"));
            addObject(new User("sorana", "password3"));
            addObject(new User("sorina", "password4"));
        }};
    }

    @Bean
    public ICacheResolver<IUserService> cacheResolver() {
        return new CacheResolver<>(
                (x, y) -> System.out.println("Cache refreshed"));
    }

    @Bean
    public IUserService userService() {
//        return new UserService(userRepository());

        return new UserServiceCached(userRepository(), cacheResolver());
    }


}
