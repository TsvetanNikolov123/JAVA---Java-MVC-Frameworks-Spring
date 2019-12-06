package softuni.heroes.services.services;

import softuni.heroes.services.models.items.ItemCreateServiceModel;
import softuni.heroes.services.models.items.ItemServiceModel;

import java.util.List;

public interface ItemsService {

    List<ItemServiceModel> getItemsForUser(String username);

    void addToUserById(long id, String username);

    void create(ItemCreateServiceModel serviceModel);
}
