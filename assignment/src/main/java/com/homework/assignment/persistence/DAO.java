package com.homework.assignment.persistence;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Gibran
 * DAO sample code found here:
 * https://www.baeldung.com/java-dao-pattern#:~:text=The%20Data%20Access%20Object%20(DAO,mechanism)%20using%20an%20abstract%20API.
 */
public interface DAO<T> {

    void save(T t) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException;

    Optional<T> get(long id) throws IOException;

    List<T> getAll();

    void update(T t, String[] params) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException;

    void delete(long id) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException;
}
