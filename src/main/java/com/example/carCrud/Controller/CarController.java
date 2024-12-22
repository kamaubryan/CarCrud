package com.example.carCrud.Controller;

import com.example.carCrud.DTO.CarDto;
import com.example.carCrud.Entity.Car;
import com.example.carCrud.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")// here we are specifying where the api will start
public class CarController {
    @Autowired
    private CarService carService;// we have to get the methods in order to map them

    @PostMapping("car")
    public ResponseEntity<?> saveCar(@RequestBody CarDto car) {
        try {
            Car savedCar = carService.saveCar(car);
            System.out.printf("Saved");
            return new ResponseEntity<Car>(savedCar, HttpStatus.CREATED);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // getting all the items
    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllProducts() {
    try {
        List<Car>  Cars = carService.getAllCars();
        return new ResponseEntity<>(Cars, HttpStatus.FOUND);
    } catch (RuntimeException e) {
        throw new RuntimeException( "your cars are not available", e);
    }

    }

    @PutMapping("update")
    public ResponseEntity<?> updateCar(@RequestParam Long id, @RequestBody CarDto car) {

        return new ResponseEntity<>(carService.updateCar(id, car), HttpStatus.OK);

    }
    // getting by brand
    @GetMapping("brand")
    public ResponseEntity<List<Car>> getCarByBrand(@RequestParam String brand,     @RequestParam(required = false) Long id ) {
        try {
            List<Car> cars = carService.getCarByBrand(brand);
            return new ResponseEntity<>(cars , HttpStatus.OK);
        }
        catch (RuntimeException e) {
            throw new RuntimeException( "your car are not available", e);
        }
    }
//     getting by model
    @GetMapping("/model")
    public ResponseEntity<List<Car>> getByModel(@RequestParam String model,  Long id ) {
        try {
            List<Car> ModelCar = carService.getCarByModel(model);
            return new ResponseEntity<>(ModelCar, HttpStatus.FOUND);
        }
        catch (RuntimeException e) {
            throw new RuntimeException( "your car model are not available", e);
        }
    }
    // getting the car by year
    public ResponseEntity<List<Car>> getByYear(@RequestParam String year,  Long id ) {
        try {
            List<Car> CarYear = carService.getCarByYear(year);
            return new ResponseEntity<>(CarYear, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            throw new RuntimeException( "your car year is not available", e);
        }
    }

}
