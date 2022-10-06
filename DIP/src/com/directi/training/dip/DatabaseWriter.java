package com.directi.training.dip.exercise_refactored;

public class DatabaseWriter implements Writer
{
    @Override
    public void write(String input)
    {
        Database database = new Database();
        database.write(input);
    }
}