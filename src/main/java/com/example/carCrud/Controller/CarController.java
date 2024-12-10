package com.example.carCrud.Controller;

import com.example.carCrud.DTO.CarDto;
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
    public ResponseEntity<?> saveCar(@RequestBody CarDto car){
       try {
           Car savedCar = carService.saveCar(car);
           System.out.printf("Saved");
           return new ResponseEntity<Car>(savedCar, HttpStatus.CREATED);

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

   // getting a car by  its id
//    public ResponseEntity <?>
}
