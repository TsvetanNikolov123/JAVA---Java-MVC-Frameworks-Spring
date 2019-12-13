package softuni.heroes.services.services.implementations;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.Item;
import softuni.heroes.data.models.enums.Slot;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.errors.HeroNotFoundException;
import softuni.heroes.services.factories.HeroesFactory;
import softuni.heroes.services.models.heroes.HeroCreateServiceModel;
import softuni.heroes.services.models.heroes.HeroDetailsServiceModel;
import softuni.heroes.services.models.heroes.HeroItemServiceModel;
import softuni.heroes.services.services.HeroesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HeroesServiceImpl implements HeroesService {

    private final HeroesRepository heroesRepository;
    private final HeroesFactory heroesFactory;
    private final ModelMapper modelMapper;

    @Override
    public HeroDetailsServiceModel getByName(String name) {
        Optional<Hero> heroResult = heroesRepository.getByNameIgnoreCase(name);
        if (heroResult.isEmpty()) {
            throw new HeroNotFoundException("Hero with such name does not exist");
        }

        Hero hero = heroResult.get();

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

    @Override
    public boolean areThereOpponents() {
        return heroesRepository.count() > 1;
    }

    @Override
    public List<HeroDetailsServiceModel> getOpponents(String heroName) {
        return heroesRepository.findAll()
                .stream()
                .filter(hero -> !hero.getName().equals(heroName))
                .map(hero -> modelMapper.map(hero, HeroDetailsServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public String getWinner(HeroDetailsServiceModel player1, HeroDetailsServiceModel player2) {
        int player1Dmg = player1.getAttack() + player1.getStrength() * 4 -
                (player2.getDefence() + player2.getStamina() * 2);

        int player2Dmg = player2.getAttack() + player2.getStrength() * 4 -
                (player1.getDefence() + player2.getStamina() * 2);

        if (player1Dmg > player2Dmg) {
            levelUp(heroesRepository.getByNameIgnoreCase(player1.getName()).orElseThrow(() -> new HeroNotFoundException("No such hero")));
            return player1.getName();
        } else {
            levelUp(heroesRepository.getByNameIgnoreCase(player2.getName()).orElseThrow(() -> new HeroNotFoundException("No such hero")));
            return player2.getName();
        }
    }

    @Override
    public void levelUp(Hero winner) {
        winner.setLevel(winner.getLevel() + 1);
        winner.setStamina(winner.getStamina() + 5);
        winner.setStrength(winner.getStrength() + 5);

        heroesRepository.save(winner);
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
