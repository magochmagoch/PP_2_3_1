package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImp implements CarService {
    @Override
    public List<Car> getListOfCarsByCount(List<Car> cars, int count) {
        if (count > cars.size() || count < 0) {
            count = cars.size();
        }
        return cars.subList(0, count);
    }
}
