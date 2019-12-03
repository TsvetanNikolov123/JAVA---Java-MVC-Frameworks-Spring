package softuni.heroes.services.services.implementations;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.repositories.ItemsRepository;
import softuni.heroes.services.models.ItemServiceModel;
import softuni.heroes.services.services.ItemsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemsServiceImpl implements ItemsService {
    private final ItemsRepository itemsRepository;
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
}
