package com.example.carCrud.Service;

import com.example.carCrud.DTO.CarDto;
import com.example.carCrud.Entity.Car;
import com.example.carCrud.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    // we are autowiring the repo class to get hold of the meothods
    @Autowired
    private CarRepository myCarRepository;
    // here we are getting all the details
    public List<Car> findAll(){
        return myCarRepository.findAll();
    }
    // getting Car by Id
    public Car getCarById(Long Id){
        return myCarRepository.findById(Id).orElseThrow(()-> new RuntimeException("Not found"));// here we have to kthow and exception incase the car with the id is not found
    }
    // Saving th car details
    public Car saveCar(Car car){
        return myCarRepository.save(car);
    }
    // updating the car details
    public Car updateCar(CarDto Cardto, Long Id, String description, String model, Double price, int year){
        Car updatedCar =myCarRepository.findById(Id).orElseThrow(()-> new RuntimeException("car to be updated Not found"));
        updatedCar.setDescription(Cardto.getDescription());
        updatedCar.setModel(Cardto.getModel());
        updatedCar.setPrice(Cardto.getPrice());
        updatedCar.setYear(Cardto.getYear());
        return updatedCar;
    }
    // deleting the car
    public void deleteCar(Long Id){
        Car ExistingCar = myCarRepository.findById(Id).orElseThrow(()-> new RuntimeException(" car to be deleted Not found"));
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
    public List<?> getCarByYear(int year) {
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
