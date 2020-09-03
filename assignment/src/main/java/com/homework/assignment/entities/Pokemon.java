package com.homework.assignment.entities;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gibran
 */
@Getter
@Setter
public class Pokemon {

    public Pokemon() {
    }

    @CsvBindByPosition(position = 0)
    int id;
    @CsvBindByPosition(position = 1)
    String name;
    @CsvBindByPosition(position = 2)
    String type_1;
    @CsvBindByPosition(position = 3)
    String type_2;
    @CsvBindByPosition(position = 4)
    int total;
    @CsvBindByPosition(position = 5)
    int hp;
    @CsvBindByPosition(position = 6)
    int attack;
    @CsvBindByPosition(position = 7)
    int defense;
    @CsvBindByPosition(position = 8)
    int sp_atk;
    @CsvBindByPosition(position = 9)
    int sp_def;
    @CsvBindByPosition(position = 10)
    int speed;
    @CsvBindByPosition(position = 11)
    int generation;
    @CsvBindByPosition(position = 12)
    String legendary; // String is used to preserve case in original file
}
