package service;

import model.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface IUserService {

    /**
     * Adds a new user into database
     * @param username: the user's username
     * @param password: the user's password
     */
    void addUser(final String username, final String password);

    /**
     *
     * @param filterCondition: the condition that needs to be met in order to select an user
     * @return Optional.empty() if such an element does not exist ot Optional.Of(element) if the element exist
     */
    Optional<User> findFirstUserBy(final Predicate<User> filterCondition);

    /**
     * @return a list with all users
     */
    List<User> getAll();
}
