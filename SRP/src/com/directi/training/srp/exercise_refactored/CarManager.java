package com.directi.training.srp.exercise_refactored;

public class CarManager
{
    private final CarDB _carDB;
    private final CarList _CarList;
    private final TopCar _TopCar;

    public CarManager(CarDB carDB, CarList CarList, TopCar TopCar)
    {
        _carDB = carDB;
        _CarList = CarList;
        _TopCar = TopCar;
    }

    public Car getCarById(final String carId)
    {
        return _carDB.findById(carId);
    }

    public String getCarsNames()
    {
        return _CarList.getCarsNames(_carDB.findAll());
    }

    public Car getBestCar()
    {
        return _TopCar.getBestCar(_carDB.findAll());
    }
}
