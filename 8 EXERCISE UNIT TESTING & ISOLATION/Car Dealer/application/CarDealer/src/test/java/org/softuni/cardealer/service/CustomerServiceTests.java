package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Customer;
import org.softuni.cardealer.domain.models.service.CustomerServiceModel;
import org.softuni.cardealer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerServiceTests {

    @Autowired
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void customerService_saveCustomerWithCorrectValues_returnsCorrect() {
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        CustomerServiceModel tobeSaved = new CustomerServiceModel();
        tobeSaved.setName("pesho");
        tobeSaved.setBirthDate(LocalDate.now());
        tobeSaved.setYoungDriver(true);

        CustomerServiceModel actual = customerService.saveCustomer(tobeSaved);
        CustomerServiceModel expected = this.modelMapper
                .map(this.customerRepository.findAll().get(0), CustomerServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(expected.isYoungDriver(), actual.isYoungDriver());
    }

    @Test(expected = Exception.class)
    public void customerService_saveCustomerWithWithNullValues_throwException() {
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        CustomerServiceModel tobeSaved = new CustomerServiceModel();
        tobeSaved.setName(null);
        tobeSaved.setName(null);
        tobeSaved.setYoungDriver(false);
        tobeSaved.setBirthDate(null);

        customerService.saveCustomer(tobeSaved);
    }

    @Test
    public void customerService_editCustomerWithCorrectValues_returnsCorrect() {
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        Customer customer = new Customer();
        customer.setName("pesho");
        customer.setBirthDate(LocalDate.now());
        customer.setYoungDriver(true);

        customer = this.customerRepository.saveAndFlush(customer);

        CustomerServiceModel tobeEdited = new CustomerServiceModel();
        tobeEdited.setId(customer.getId());
        tobeEdited.setName("pesho");
        tobeEdited.setBirthDate(LocalDate.now());
        tobeEdited.setYoungDriver(true);

        CustomerServiceModel actual = customerService.editCustomer(tobeEdited);
        CustomerServiceModel expected =
                this.modelMapper.map(this.customerRepository.findAll().get(0), CustomerServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(expected.isYoungDriver(), actual.isYoungDriver());
    }

    @Test(expected = Exception.class)
    public void customerService_editCustomerWithNullValues_throwException() {
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        Customer customer = new Customer();
        customer.setName("pesho");
        customer.setBirthDate(LocalDate.now());
        customer.setYoungDriver(true);

        customer = this.customerRepository.saveAndFlush(customer);

        CustomerServiceModel tobeEdited = new CustomerServiceModel();
        tobeEdited.setId(customer.getId());
        tobeEdited.setName(null);
        tobeEdited.setBirthDate(null);
        tobeEdited.setYoungDriver(true);

        customerService.editCustomer(tobeEdited);
    }

    @Test
    public void customerService_deleteCustomerWithValidId_returnsCorrect() {
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setBirthDate(LocalDate.now());
        customer.setYoungDriver(true);

        customer = this.customerRepository.saveAndFlush(customer);

        customerService.deleteCustomer(customer.getId());

        long expectedCount = 0L;
        long actualCount = this.customerRepository.count();

        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test(expected = Exception.class)
    public void customerService_deleteCustomerWithInvalidId_throwsException(){
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setBirthDate(LocalDate.now());
        customer.setYoungDriver(true);

        customer = this.customerRepository.saveAndFlush(customer);

        customerService.deleteCustomer("InvalidId");
    }

    @Test
    public void customerService_findByIdCustomerWithValidId_returnsCorrect(){
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setBirthDate(LocalDate.now());
        customer.setYoungDriver(true);

        customer = this.customerRepository.saveAndFlush(customer);

        CustomerServiceModel actual = customerService.findCustomerById(customer.getId());
        CustomerServiceModel expected = this.modelMapper.map(customer, CustomerServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(expected.isYoungDriver(), actual.isYoungDriver());
    }

    @Test(expected = Exception.class)
    public void customerService_findCustomerByIdCustomerWithInvalidId_throwsException(){
        CustomerService customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapper);

        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setBirthDate(LocalDate.now());
        customer.setYoungDriver(true);

        customer = this.customerRepository.saveAndFlush(customer);

        customerService.findCustomerById("InvalidId");
    }
}
