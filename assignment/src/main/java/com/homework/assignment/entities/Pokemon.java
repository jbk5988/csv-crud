package com.homework.assignment.entities;

import com.homework.assignment.enums.Type;
import com.opencsv.bean.CsvBindByName;

/**
 * @author Gibran
 */
public class Pokemon {

    public Pokemon() {
    }

    @CsvBindByName(column = "name")
    int id;
    @CsvBindByName
    String name;
    @CsvBindByName
    Type type_1;
    @CsvBindByName
    Type type_2;
    @CsvBindByName
    int total_HP;
    @CsvBindByName
    int attack;
    @CsvBindByName
    int defense;
    @CsvBindByName
    int sp_atk;
    @CsvBindByName
    int sp_def;
    @CsvBindByName
    int speed;
    @CsvBindByName
    int generation;
    @CsvBindByName
    boolean legendary;
}
