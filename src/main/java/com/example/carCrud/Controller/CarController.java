package com.example.carCrud.Controller;

import com.example.carCrud.Entity.Car;
import com.example.carCrud.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")// here we are specifying where the api will start
public class CarController {
    @Autowired
    private CarService carService;// we have to get the methods in order to map them

   @PostMapping("/car")
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
       Car savedCar = carService.saveCar(car);
       return new ResponseEntity<>(car, HttpStatus.CREATED);
   }
}
