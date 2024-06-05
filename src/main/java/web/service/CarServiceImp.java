package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImp implements CarService {
    @Override
    public List<Car> getListOfCarsByCount(List<Car> cars, int count) {
        return cars.subList(0, count);
    }
}
