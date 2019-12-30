package service.impl.cached;

import cache.ICacheResolver;
import cache.annotations.*;
import cache.proxies.ProxyCacher;
import database.IRepository;
import model.User;
import service.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Cacheable
public class UserServiceCached extends ProxyCacher<IUserService> implements IUserService {

    private final IRepository<User> userRepository;

    public UserServiceCached(final IRepository<User> userRepository,
                             final ICacheResolver<IUserService> cacheResolver) {
        super(cacheResolver);
        this.userRepository = userRepository;
    }

    @Override
    @VolatileCaches(
            @VolatileCache(cacheUpdate = "getAll")
    )
    public void addUser(final String username, final String password) {
        userRepository.addObject(new User(username, password));
    }

    @Override
    public Optional<User> findFirstUserBy(final Predicate<User> filterCondition) {
        return userRepository.findObject(filterCondition);
    }

    @Override
    @Cached(cacheTime = 30000,
            cacheName = "getAll",
            timeUnit = TTL.MILLISECONDS)
    public List<User> getAll() {
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        return userRepository.getAll();
    }

    @Override
    protected IUserService getProxySource() {
        return this;
    }
}
