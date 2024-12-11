package com.example.carCrud.Service;

import com.example.carCrud.DTO.CarDto;
import com.example.carCrud.Entity.Car;
import com.example.carCrud.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    // we are autowiring the repo class to get hold of the meothods
    @Autowired
    private CarRepository myCarRepository;
    // here we are getting all the details
    public List<Car> getAllCars(){
        return myCarRepository.findAll();
    }
    // getting Car by Id
    public Car getCarById(Long id){
        return myCarRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));// here we have to kthow and exception incase the car with the id is not found
    }
    // Saving th car details
    public Car saveCar(CarDto car){
        Car carEntity = new Car();
        carEntity.setBrand(car.getBrand());
        carEntity.setModel(car.getModel());
        carEntity.setYear(car.getYear());
        carEntity.setDescription(car.getDescription());
        carEntity.setPrice(car.getPrice());
        return myCarRepository.save(carEntity);
    }
    // updating the car details
    public Car updateCar( Long id, CarDto carDto){

        Car updatedCar =myCarRepository.findById(id).orElseThrow(()-> new RuntimeException("car to be updated Not found"));


        updatedCar.setDescription(carDto.getDescription()!= null? carDto.getDescription() : updatedCar.getDescription());
        updatedCar.setModel(carDto.getModel()!= null? carDto.getModel() : updatedCar.getModel());
updatedCar.setBrand(carDto.getBrand()!= null? carDto.getBrand() : updatedCar.getBrand());
updatedCar.setYear(carDto.getYear()!= null? carDto.getYear() : updatedCar.getYear());
        updatedCar.setPrice(carDto.getPrice());

        return myCarRepository.save(updatedCar);
    }
    // deleting the car
    public void deleteCar(Long id){
        Car ExistingCar = myCarRepository.findById(id).orElseThrow(()-> new RuntimeException(" car to be deleted Not found"));
        myCarRepository.delete(ExistingCar);
    }
// getting the car by model
    public List<?> getCarByModel(String model) {
        List<Car> cars = myCarRepository.findByModel(model);
        if (cars.isEmpty()) {
            throw new RuntimeException("The model specified is not found");
        }
        return cars;
    }
    // getting the carr by year
    public List<?> getCarByYear(String year) {
        List<Car> cars = myCarRepository.findByYear(year);
        if (cars.isEmpty()) {
            throw new RuntimeException("The year specified is not found");
        }
        return cars;
    }
    // getting by brand and model
    public List<?> getCarByBrandAndModel(String brand, String model) {
        List<Car> cars = myCarRepository.findByBrandAndModel(brand, model);
        if (cars.isEmpty()) {
            throw new RuntimeException("The model specified is not found");
        }
        return cars;
    }
    // getting car by price
    public List<Car> getCarByPrice(Double price) {
        List<Car> cars = myCarRepository.findByPrice(price);
        if (cars.isEmpty()) {
            throw new RuntimeException("The price specified is not found");
        }
        return cars;
    }
// getting the car by description
    public List<Car> getCarByDescription(String description) {
        List<Car> cars = myCarRepository.findByDescription(description);
        if (cars.isEmpty()) {
            throw new RuntimeException("The description specified is not found");
        }
        return cars;
    }
    // getting the car by brand
    public List<Car> getCarByBrand(String brand) {
        List<Car> cars = myCarRepository.findByBrand(brand);
        if (cars.isEmpty()) {
            throw new RuntimeException("The brand specified is not found");
        }
        return cars;
    }
}
