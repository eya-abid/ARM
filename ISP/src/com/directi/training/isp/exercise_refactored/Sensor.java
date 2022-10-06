package com.directi.training.isp.exercise_refactored;

import java.util.Random;

public class Sensor
{
    public void register(SensingObject sensorObj)
    {
        while (true) {
            if (isPersonClose()) {
                sensorObj.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }
}