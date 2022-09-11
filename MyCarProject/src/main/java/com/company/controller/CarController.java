package com.company.controller;

import com.company.model.Car;
import com.company.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"/list","/"})
    public ModelAndView getAllCars() {
        ModelAndView mav = new ModelAndView("list-cars");
        mav.addObject("cars", carService.findAll());
        return mav;
    }

    @GetMapping("/addCarForm")
    public ModelAndView addCarForm() {
        ModelAndView mav = new ModelAndView("add-car-form");
        Car newCar = new Car();
        mav.addObject("car", newCar);
        return mav;
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute Car car) {
        carService.save(car);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@ModelAttribute Car car) {
        ModelAndView mav = new ModelAndView("add-car-form");
        Car car1 = carService.update(car);
        mav.addObject("car", car1);
        return mav;
    }

    @GetMapping("/deleteCar")
    public String deleteEmployee(@RequestParam Integer carId) {
        carService.delete(carId);
        return "redirect:/list";
    }

}



