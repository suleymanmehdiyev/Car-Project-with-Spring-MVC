package com.company.service;

import com.company.model.Car;
import com.company.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        Optional<Car> findStudent = carRepository.findById(car.getId());
        Car newStudent = null;
        if(findStudent.isPresent()) {
            newStudent = findStudent.get();

            newStudent.setMark(car.getMark());
            newStudent.setModel(car.getModel());
            newStudent.setColor(car.getColor());

           carRepository.save(newStudent);
        }
        return newStudent;
    }

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
