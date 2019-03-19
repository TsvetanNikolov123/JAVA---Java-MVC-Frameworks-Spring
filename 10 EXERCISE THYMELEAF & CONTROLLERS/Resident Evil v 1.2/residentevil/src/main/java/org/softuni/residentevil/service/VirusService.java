package org.softuni.residentevil.service;

import org.softuni.residentevil.domain.models.service.VirusServiceModel;

import java.util.List;

public interface VirusService {

    VirusServiceModel addVirus(VirusServiceModel virusServiceModel);

    List<VirusServiceModel> findAllViruses();

    VirusServiceModel findVirusById(String id);

    VirusServiceModel editVirus(VirusServiceModel virusServiceModel);

    boolean deleteVirusById(String id);
}
