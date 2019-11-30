package softuni.heroes.services.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.Item;
import softuni.heroes.data.models.enums.Slot;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.errors.HeroNotFoundException;
import softuni.heroes.services.factories.HeroesFactory;
import softuni.heroes.services.models.HeroCreateServiceModel;
import softuni.heroes.services.models.HeroDetailsServiceModel;
import softuni.heroes.services.models.HeroItemServiceModel;
import softuni.heroes.services.services.HeroesService;

import java.util.List;
import java.util.Optional;

@Service
public class HeroesServiceImpl implements HeroesService {

    private final HeroesRepository heroesRepository;
    private final HeroesFactory heroesFactory;
    private final ModelMapper modelMapper;

    public HeroesServiceImpl(HeroesRepository heroesRepository, HeroesFactory heroesFactory, ModelMapper modelMapper) {
        this.heroesRepository = heroesRepository;
        this.heroesFactory = heroesFactory;
        this.modelMapper = modelMapper;
    }

    @Override
    public HeroDetailsServiceModel getByName(String name) {
        Hero hero = heroesRepository.getByNameIgnoreCase(name).orElseThrow(() -> new HeroNotFoundException("There is no such hero !!!"));

        HeroDetailsServiceModel serviceModel = modelMapper.map(hero, HeroDetailsServiceModel.class);

        serviceModel.setWeapon(getItemBySlot(hero.getItems(), Slot.WEAPON));
        serviceModel.setGauntlets(getItemBySlot(hero.getItems(), Slot.GAUNTLETS));
        serviceModel.setHelmet(getItemBySlot(hero.getItems(), Slot.HELMET));
        serviceModel.setPads(getItemBySlot(hero.getItems(), Slot.PADS));
        serviceModel.setPauldrons(getItemBySlot(hero.getItems(), Slot.PAULDRON));

        return serviceModel;
    }

    @Override
    public Hero create(HeroCreateServiceModel serviceModel) {
        Hero hero = heroesFactory.create(serviceModel.getName(), serviceModel.getGender());
        heroesRepository.save(hero);
        return hero;
    }

    private HeroItemServiceModel getItemBySlot(List<Item> items, Slot slot) {
        Optional<Item> item = items
                .stream()
                .filter(x -> x.getSlot() == slot)
                .findFirst();

        return item.isPresent()
                ? modelMapper.map(item, HeroItemServiceModel.class)
                : null;
    }
}
