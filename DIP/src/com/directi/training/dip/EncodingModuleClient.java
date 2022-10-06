package com.directi.training.dip.exercise_refactored;

import java.io.IOException;

public class EncodingModuleClient
{
    public static void main(String[] args) throws IOException
    {
        EncodingModule encodingModule = new EncodingModule();

        Reader reader = new MyFileReader("DIP/src/com/directi/training/dip/exercise_refactored/beforeEncryption.txt");
        Writer writer = new MyFileWriter("DIP/src/com/directi/training/dip/exercise_refactored/afterEncryption.txt");
        
        encodingModule.encode(reader, writer);

        reader = new NetworkReader("http", "myfirstappwith.appspot.com", "/index.html");
        writer = new DatabaseWriter();
        encodingModule.encode(reader, writer);
    }
}