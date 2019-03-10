package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Supplier;
import org.softuni.cardealer.domain.models.service.SupplierServiceModel;
import org.softuni.cardealer.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SupplierServiceTests {

    @Autowired
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void supplierService_saveSupplierWithCorrectValues_returnsCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        SupplierServiceModel tobeSaved = new SupplierServiceModel();
        tobeSaved.setName("pesho");
        tobeSaved.setImporter(true);

        SupplierServiceModel actual = supplierService.saveSupplier(tobeSaved);
        SupplierServiceModel expected = this.modelMapper
                .map(this.supplierRepository.findAll().get(0), SupplierServiceModel.class);


        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isImporter(), actual.isImporter());
    }

    @Test(expected = Exception.class)
    public void supplierService_saveSupplierWithNullValues_throwException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        SupplierServiceModel tobeSaved = new SupplierServiceModel();
        tobeSaved.setName(null);
        tobeSaved.setImporter(true);

        supplierService.saveSupplier(tobeSaved);
    }

    @Test
    public void supplierService_editSupplierWithCorrectValues_returnsCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Pesho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        SupplierServiceModel toBeEdited = new SupplierServiceModel();
        toBeEdited.setId(supplier.getId());
        toBeEdited.setName("gosho");
        toBeEdited.setImporter(false);

        SupplierServiceModel actual = supplierService.editSupplier(toBeEdited);
        SupplierServiceModel expected =
                this.modelMapper.map(this.supplierRepository.findAll().get(0), SupplierServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isImporter(), actual.isImporter());
    }

    @Test(expected = Exception.class)
    public void supplierService_editSupplierWithNullValues_throwsException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Pesho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        SupplierServiceModel tobeEdited = new SupplierServiceModel();
        tobeEdited.setId(supplier.getId());
        tobeEdited.setName(null);
        tobeEdited.setImporter(false);

        supplierService.editSupplier(tobeEdited);
    }

    @Test
    public void supplierService_deleteSupplierWithValidId_returnsCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Pesho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        supplierService.deleteSupplier(supplier.getId());

        long expectedCount = 0L;
        long actualCount = this.supplierRepository.count();

        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test(expected = Exception.class)
    public void supplierService_deleteSupplierWithInvalidId_throwException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Pesho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        supplierService.deleteSupplier("InvalidId");
    }

    @Test
    public void supplierService_findByIdSupplierWithValidId_returnCorrect() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Pesho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        SupplierServiceModel actual = supplierService.findSupplierById(supplier.getId());
        SupplierServiceModel expected = this.modelMapper.map(supplier, SupplierServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isImporter(), actual.isImporter());
    }

    @Test(expected = Exception.class)
    public void supplierService_findSupplierByIdSupplierWithInvalidId_throwException() {
        SupplierService supplierService = new SupplierServiceImpl(this.supplierRepository, this.modelMapper);

        Supplier supplier = new Supplier();
        supplier.setName("Pesho");
        supplier.setImporter(true);

        supplier = this.supplierRepository.saveAndFlush(supplier);

        supplierService.findSupplierById("InvalidId");
    }
}
