package softuni.heroes.services.services.validation.base;

import org.springframework.stereotype.Service;
import softuni.heroes.services.models.items.ItemCreateServiceModel;
import softuni.heroes.services.services.validation.ItemsValidationService;

@Service
public class ItemsValidationServiceImpl implements ItemsValidationService {
    public boolean isValid(ItemCreateServiceModel serviceModel) {
        return serviceModel != null &&
                serviceModel.getName() != null &&
                serviceModel.getSlot() != null &&
                serviceModel.getAttack() > 0;
    }
}
