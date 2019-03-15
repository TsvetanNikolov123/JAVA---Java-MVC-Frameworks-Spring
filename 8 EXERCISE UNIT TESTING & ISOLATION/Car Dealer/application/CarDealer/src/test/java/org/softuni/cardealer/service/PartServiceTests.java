package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Part;
import org.softuni.cardealer.domain.models.service.PartServiceModel;
import org.softuni.cardealer.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PartServiceTests {

    @Autowired
    private PartRepository partRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void partService_savePartWithCorrectValues_returnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        PartServiceModel toBeSaved = new PartServiceModel();
        toBeSaved.setName("engine");
        toBeSaved.setPrice(BigDecimal.valueOf(2300.00d));

        PartServiceModel actual = partService.savePart(toBeSaved);
        PartServiceModel expected = this.modelMapper
                .map(this.partRepository.findAll().get(0), PartServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
        Assert.assertEquals(expected.getSupplier(), actual.getSupplier());
    }

    @Test(expected = Exception.class)
    public void partService_savePartWithNullValues_throwException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        PartServiceModel tobeSaved = new PartServiceModel();
        tobeSaved.setName(null);
        tobeSaved.setPrice(null);
        tobeSaved.setSupplier(null);

        partService.savePart(tobeSaved);
    }

    @Test
    public void partService_editPartWithCorrectData_returnCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(BigDecimal.valueOf(2300.00d));

        part = this.partRepository.saveAndFlush(part);

        PartServiceModel toBeEdited = new PartServiceModel();
        toBeEdited.setId(part.getId());
        toBeEdited.setName("engine");
        toBeEdited.setPrice(BigDecimal.valueOf(2300.00d));

        PartServiceModel actual = partService.editPart(toBeEdited);
        PartServiceModel expected =
                this.modelMapper.map(this.partRepository.findAll().get(0), PartServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expected = Exception.class)
    public void partService_editPartEditNullValues_throwException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName(null);
        part.setPrice(null);

        part = this.partRepository.saveAndFlush(part);

        PartServiceModel toBeEdited = new PartServiceModel();
        toBeEdited.setId(part.getId());
        toBeEdited.setName(null);
        toBeEdited.setPrice(null);
        toBeEdited.setSupplier(null);

        partService.editPart(toBeEdited);
    }

    @Test
    public void partService_deletePartWithValidId_returnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(new BigDecimal(2000.00d));

        part = this.partRepository.saveAndFlush(part);

        partService.deletePart(part.getId());

        long expectedCount = 0L;
        long actualCount = this.partRepository.count();

        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test(expected = Exception.class)
    public void partService_deletePartWithInvalidId_throwException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(new BigDecimal(2000.00d));

        part = this.partRepository.saveAndFlush(part);

        partService.deletePart("invalidId");
    }

    @Test
    public void partService_findByIdPartWithValidId_returnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(new BigDecimal(2000.00d));

        part = this.partRepository.saveAndFlush(part);

        PartServiceModel actual = partService.findPartById(part.getId());
        PartServiceModel expected = this.modelMapper.map(part, PartServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expected = Exception.class)
    public void partService_findPartByIdPartWithInvalidId_throwsException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(new BigDecimal(2000.00d));

        part = this.partRepository.saveAndFlush(part);

        partService.findPartById("invalidId");
    }
}
