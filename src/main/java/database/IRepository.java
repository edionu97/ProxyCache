package database;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface IRepository<T> {

    /**
     * Stores an object
     * @param object: the information that will be stored
     */
    void addObject(final T object);

    /**
     * @param condition: the condition that needs to be satisfied
     * @return an optional to that object
     */
    Optional<T> findObject(final Predicate<T> condition);

    /**
     * @return a list with all instances
     */
    List<T> getAll();
}
