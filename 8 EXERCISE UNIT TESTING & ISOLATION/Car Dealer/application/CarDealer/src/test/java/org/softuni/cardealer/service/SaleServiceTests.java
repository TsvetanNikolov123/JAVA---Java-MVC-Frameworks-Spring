package org.softuni.cardealer.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.models.service.CarServiceModel;
import org.softuni.cardealer.domain.models.service.SaleServiceModel;
import org.softuni.cardealer.repository.CarSaleRepository;
import org.softuni.cardealer.repository.PartSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SaleServiceTests {

    @Autowired
    private CarSaleRepository carSaleRepository;
    @Autowired
    private PartSaleRepository partSaleRepository;
    private ModelMapper modelMapper;

    @Before
    private void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void saleService_saleCarWithCorrectValues_returnsCorrect() {
        SaleService saleService =
                new SaleServiceImpl(this.carSaleRepository, this.partSaleRepository, this.modelMapper);

        // todo all test for Sale Service
    }
}
