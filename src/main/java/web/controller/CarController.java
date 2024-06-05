package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCarList(ModelMap model,
                               @RequestParam(required = false, defaultValue = "5") int count) {
        CarService carService = new CarServiceImp();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Firm1", "Model1", 111));
        cars.add(new Car("Firm2", "Model2", 222));
        cars.add(new Car("Firm3", "Model3", 333));
        cars.add(new Car("Firm4", "Model4", 444));
        cars.add(new Car("Firm5", "Model5", 555));
        if (count > 5) {
            count = 5;
        }
        model.addAttribute("cars", carService.getListOfCarsByCount(cars, count));
        return "cars";
    }

}
