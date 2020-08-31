package com.homework.assignment.persistence;

import java.util.List;
import java.util.Optional;

/**
 * @author Gibran
 * DAO sample code found here:
 * https://www.baeldung.com/java-dao-pattern#:~:text=The%20Data%20Access%20Object%20(DAO,mechanism)%20using%20an%20abstract%20API.
 */
public interface DAO<T> {

    void save(T t);

    Optional<T> get(long id);

    List<T> getAll();

    void update(T t, String[] params);

    void delete(T t);
}
