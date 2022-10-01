package com.directi.training.srp.exercise_refractored;

public class CarManager
{
    private final CarDB _carDB;
    private final CarFormatter _carFormatter;
    private final CarRater _carRater;

    public CarManager(CarDB carDB, CarFormatter carFormatter, CarRater carRater)
    {
        _carDB = carDB;
        _carFormatter = carFormatter;
        _carRater = carRater;
    }

    public Car getCarById(final String carId)
    {
        return _carDB.findById(carId);
    }

    public String getCarsNames()
    {
        return _carFormatter.getCarsNames(_carDB.findAll());
    }

    public Car getBestCar()
    {
        return _carRater.getBestCar(_carDB.findAll());
    }
}
