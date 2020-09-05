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
public interface Mutator<T> {

    public void addRow(T rowObject) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

    public void getRow();

    public void updateRow();

    public void deleteRow();
}
