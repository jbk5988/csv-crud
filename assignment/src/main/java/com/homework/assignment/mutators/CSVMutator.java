package com.homework.assignment.mutators;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.core.GenericTypeResolver;

/**
 * @author Gibran
 */
public interface CSVMutator<T> {

    public void addRow(T rowObject) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

    public T getRow(long id) throws IOException;

    public void updateRow(T rowObject) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

    public void deleteRow(long id) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
}
