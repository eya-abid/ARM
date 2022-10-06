package com.directi.training.dip.exercise_refactored;

import java.io.IOException;

public interface Writer
{
    void write(String encodedLine) throws IOException;
}