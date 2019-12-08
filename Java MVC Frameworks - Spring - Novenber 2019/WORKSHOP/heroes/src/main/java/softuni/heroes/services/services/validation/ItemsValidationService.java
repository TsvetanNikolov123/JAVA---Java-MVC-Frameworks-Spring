package softuni.heroes.services.services.validation;

import softuni.heroes.services.models.items.ItemCreateServiceModel;

public interface ItemsValidationService {

    boolean isValid(ItemCreateServiceModel itemCreateServiceModel);
}
