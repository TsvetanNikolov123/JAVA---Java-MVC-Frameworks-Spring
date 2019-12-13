package softuni.heroes.services.services.implementations;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.Item;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.data.repositories.ItemsRepository;
import softuni.heroes.services.models.items.ItemCreateServiceModel;
import softuni.heroes.services.models.items.ItemServiceModel;
import softuni.heroes.services.services.ItemsService;
import softuni.heroes.services.services.validation.ItemsValidationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemsServiceImpl implements ItemsService {
    private final ItemsRepository itemsRepository;
    private final HeroesRepository heroesRepository;
    private final ItemsValidationService itemsValidationService;
    private final ModelMapper modelMapper;

    @Override
    public List<ItemServiceModel> getItemsForUser(String username) {
        return itemsRepository.findAll()
                .stream()
                .map(item -> {

                    ItemServiceModel serviceModel = modelMapper.map(item, ItemServiceModel.class);

                    if (item.getHeroes() != null) {
                        Hero hero = item.getHeroes()
                                .stream()
                                .filter(h -> h.getUser().getUsername().equals(username))
                                .findAny()
                                .orElse(null);

                        serviceModel.setOwned(hero != null);
                    }

                    return serviceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addToUserById(long id, String username) {
        Optional<Hero> heroResult = heroesRepository.getByUserUsername(username);
        if (heroResult.isEmpty()) {
            throw new NullPointerException("User does not have a hero");
        }

        Optional<Item> itemResult = itemsRepository.findById(id);
        if (itemResult.isEmpty()) {
            throw new NullPointerException("Item does not exists");
        }

        Hero hero = heroResult.get();
        Item item = itemResult.get();

        // todo -> fix if we have already purchased given item and skip it
        boolean hasItem = false;
        for (Item currentItem : hero.getItems()) {
            if (currentItem.getSlot() == item.getSlot()) {
                hasItem = true;
                break;
            }
        }

        if (!hasItem) {
            hero.getItems().add(item);
            hero.setStrength(hero.getStrength() + item.getStrength());
            hero.setStamina(hero.getStamina() + item.getStamina());
            hero.setAttack(hero.getAttack() + item.getAttack());
            hero.setDefence(hero.getDefence() + item.getDefence());
        }

        heroesRepository.saveAndFlush(hero);
    }

    @Override
    public void create(ItemCreateServiceModel serviceModel) {
        if (!this.itemsValidationService.isValid(serviceModel)) {
            throw new RuntimeException("Hero is invalid");
        }

        Item item = modelMapper.map(serviceModel, Item.class);
        itemsRepository.save(item);
    }
}
