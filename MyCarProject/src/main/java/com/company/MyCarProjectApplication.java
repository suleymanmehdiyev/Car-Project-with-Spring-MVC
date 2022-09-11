package com.company;

import com.company.model.Car;
import com.company.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyCarProjectApplication implements CommandLineRunner {

    private CarService carService;

    @Autowired
    public MyCarProjectApplication(CarService carService) {
        this.carService = carService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyCarProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Car car = new Car(null,"Mercedes","ceska","red");
       List<Car> cars = carService.findAll();
        System.out.println(cars);
    }
}
