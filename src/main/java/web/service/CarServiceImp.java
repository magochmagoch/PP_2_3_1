package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImp implements CarService {
    private List<Car> cars;

    @Override
    public List<Car> getListOfCarsByCount(int count) {
        cars = Arrays.asList(
                new Car("Firm1", "Model1", 111),
                new Car("Firm2", "Model2", 222),
                new Car("Firm3", "Model3", 333),
                new Car("Firm4", "Model4", 444),
                new Car("Firm5", "Model5", 555)
        );
        return cars.stream()
                .limit(Math.min(count, cars.size()))
                .collect(Collectors.toList());
    }
}
