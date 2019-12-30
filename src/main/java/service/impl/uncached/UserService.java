package service.impl.uncached;

import database.IRepository;
import model.User;
import service.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class UserService implements IUserService {

    private final IRepository<User> userRepository;

    public UserService(final IRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(final String username, final String password) {
        userRepository.addObject(new User(username, password));
    }

    @Override
    public Optional<User> findFirstUserBy(final Predicate<User> filterCondition) {
        return userRepository.findObject(filterCondition);
    }

    @Override
    public List<User> getAll() {
        try{
            Thread.sleep(2000);
        }catch (Exception ignored){
        }
        return userRepository.getAll();
    }
}
