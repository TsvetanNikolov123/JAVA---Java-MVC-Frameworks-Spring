package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Car;
import org.softuni.cardealer.domain.models.service.CarServiceModel;
import org.softuni.cardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarServiceTests {

    @Autowired
    private CarRepository carRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void carService_saveCarWithCorrectValues_returnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        CarServiceModel tobeSaved = new CarServiceModel();
        tobeSaved.setModel("Audi");
        tobeSaved.setMake("RS6");
        tobeSaved.setTravelledDistance(2000L);

        CarServiceModel actual = carService.saveCar(tobeSaved);
        CarServiceModel expected = this.modelMapper
                .map(this.carRepository.findAll().get(0), CarServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getMake(), actual.getMake());
        Assert.assertEquals(expected.getTravelledDistance(), actual.getTravelledDistance());
    }

    @Test(expected = Exception.class)
    public void carService_saveSupplierWithNullValues_throwsException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        CarServiceModel tobeSaved = new CarServiceModel();
        tobeSaved.setModel(null);
        tobeSaved.setMake(null);
        tobeSaved.setTravelledDistance(null);

        carService.saveCar(tobeSaved);
    }

    @Test
    public void carService_editCarWithCorrectValues_returnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setModel("Audi");
        car.setMake("RS8");
        car.setTravelledDistance(2000L);

        car = this.carRepository.saveAndFlush(car);

        CarServiceModel toBeEdited = new CarServiceModel();
        toBeEdited.setId(car.getId());
        toBeEdited.setModel("Audi");
        toBeEdited.setMake("RS8");
        toBeEdited.setTravelledDistance(2000L);

        CarServiceModel actual = carService.editCar(toBeEdited);
        CarServiceModel expected =
                this.modelMapper.map(this.carRepository.findAll().get(0), CarServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getMake(), actual.getMake());
        Assert.assertEquals(expected.getTravelledDistance(), actual.getTravelledDistance());
    }

    @Test(expected = Exception.class)
    public void carService_editCarWithNullValues_throwsException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setModel("BMW");
        car.setMake("X5");
        car.setTravelledDistance(5000L);

        car = this.carRepository.saveAndFlush(car);

        CarServiceModel tobeEdited = new CarServiceModel();
        tobeEdited.setId(car.getId());
        tobeEdited.setModel(null);
        tobeEdited.setMake(null);
        tobeEdited.setTravelledDistance(null);

        carService.editCar(tobeEdited);
    }

    @Test
    public void carService_deleteCarWithValidId_returnCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setModel("BMW");
        car.setMake("X3");
        car.setTravelledDistance(10000L);

        car = this.carRepository.saveAndFlush(car);

        carService.deleteCar(car.getId());

        long expectedCount = 0L;
        long actualCount = this.carRepository.count();

        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test(expected = Exception.class)
    public void carService_deleteCarWithInvalidId_throwException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setModel("BMW");
        car.setMake("X3");
        car.setTravelledDistance(10000L);

        car = this.carRepository.saveAndFlush(car);

        carService.deleteCar("InvalidId");
    }

    @Test
    public void carService_findByIdWithValidId_returnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setModel("BMW");
        car.setMake("X3");
        car.setTravelledDistance(10000L);

        car = this.carRepository.saveAndFlush(car);

        CarServiceModel actual = carService.findCarById(car.getId());
        CarServiceModel expected = this.modelMapper.map(car, CarServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getMake(), actual.getMake());
        Assert.assertEquals(expected.getTravelledDistance(), actual.getTravelledDistance());
    }

    @Test(expected = Exception.class)
    public void carService_findCarByIdWithInvalidId_throwsException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setModel("BMW");
        car.setMake("X3");
        car.setTravelledDistance(10000L);

        car = this.carRepository.saveAndFlush(car);

        carService.findCarById("InvalidId");
    }
}
