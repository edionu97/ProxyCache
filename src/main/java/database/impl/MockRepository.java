package database.impl;

import database.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MockRepository<T> implements IRepository<T> {

    private final List<T> objects = new ArrayList<>();

    @Override
    public void addObject(final T object) {
        objects.add(object);
    }

    @Override
    public Optional<T> findObject(final Predicate<T> condition) {
        return objects
                .stream()
                .filter(condition)
                .findFirst();
    }

    @Override
    public List<T> getAll() {
        return objects;
    }
}
