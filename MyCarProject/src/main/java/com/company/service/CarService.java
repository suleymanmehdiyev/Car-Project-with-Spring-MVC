package com.company.service;

import com.company.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();
    void save(Car car);
    Car update(Car car);
    void delete(Integer id);
}
