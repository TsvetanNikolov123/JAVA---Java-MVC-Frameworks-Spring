package org.softuni.residentevil.service;

import org.modelmapper.ModelMapper;
import org.softuni.residentevil.domain.entities.Virus;
import org.softuni.residentevil.domain.models.service.VirusServiceModel;
import org.softuni.residentevil.repository.VirusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VirusServiceImpl implements VirusService {

    private final VirusRepository virusRepository;
    private final ModelMapper modelMapper;

    public VirusServiceImpl(VirusRepository virusRepository, ModelMapper modelMapper) {
        this.virusRepository = virusRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VirusServiceModel addVirus(VirusServiceModel virusServiceModel) {
        Virus currentVirus = this.modelMapper.map(virusServiceModel, Virus.class);
        try {
            currentVirus = this.virusRepository.saveAndFlush(currentVirus);
            return this.modelMapper.map(currentVirus, VirusServiceModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<VirusServiceModel> findAllViruses() {
        return this.virusRepository.findAll()
                .stream()
                .map(d -> this.modelMapper.map(d, VirusServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public VirusServiceModel findVirusById(String id) {
        Virus document = this.virusRepository.findById(id).orElse(null);
        if (document == null) {
            return null;
        }
        return this.modelMapper.map(document, VirusServiceModel.class);
    }

    @Override
    public VirusServiceModel editVirus(VirusServiceModel virusServiceModel) {
        Virus entity = this.modelMapper.map(virusServiceModel, Virus.class);

        return this.modelMapper.map(this.virusRepository.saveAndFlush(entity), VirusServiceModel.class);
    }

    @Override
    public boolean deleteVirusById(String id) {
        try {
            this.virusRepository.deleteById(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
