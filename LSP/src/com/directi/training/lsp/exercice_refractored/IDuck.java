package com.directi.training.lsp.exercice_refractored;

public interface IDuck
{
    void quack() throws IDuckException;

    void swim() throws IDuckException;

    class IDuckException extends Exception
    {
        public IDuckException(String message)
        {
            super(message);
        }
    }
}
