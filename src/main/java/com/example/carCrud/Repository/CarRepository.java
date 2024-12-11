package com.example.carCrud.Repository;

import com.example.carCrud.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository// every time the repository class is always an interface in order to implement all the classes that the jpa interface has
public interface CarRepository  extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByDescription(String description);
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByPrice(double price);
    List<Car> findByYear(String year);
}
