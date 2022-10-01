package com.directi.training.dip.exercise_refractored;

import java.io.IOException;

public interface IWriter
{
    void write(String encodedLine) throws IOException;
}