package softuni.heroes.services.services;

import softuni.heroes.services.models.ItemServiceModel;

import java.util.List;

public interface ItemsService {

    List<ItemServiceModel> getItemsForUser(String username);

    void createForUserId(long id, String username);
}
