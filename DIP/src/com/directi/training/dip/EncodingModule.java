package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.util.Base64;

public class EncodingModule
{
    public void encode(Reader reader, Writer writer) throws IOException
    {
        String aLine = reader.read();
        String encodedLine = Base64.getEncoder().encodeToString(aLine.getBytes());
        writer.write(encodedLine);
    }
}
