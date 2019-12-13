package softuni.heroes.web.api.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.heroes.services.models.items.ItemCreateServiceModel;
import softuni.heroes.services.services.ItemsService;
import softuni.heroes.web.api.models.ItemCreateRequestModel;
import softuni.heroes.web.api.models.ItemResponseModel;
import softuni.heroes.web.base.BaseController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ItemsApiController extends BaseController {
    private final ItemsService itemsService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/items")
    public List<ItemResponseModel> getItems(HttpSession session) {
//        Thread.sleep(5000);
        String username = getUsername(session);
        return itemsService.getItemsForUser(username)
                .stream()
                .map(itemServiceModel -> modelMapper.map(itemServiceModel, ItemResponseModel.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/api/items/add-to-user/{id}")
    public void buyItem(@PathVariable long id, HttpSession session, HttpServletResponse response) throws IOException {
        String username = getUsername(session);
        itemsService.addToUserById(id, username);

        response.sendRedirect("/heroes/details/" + getHeroName(session));
    }

    @PostMapping("/api/items")
    public void create(ItemCreateRequestModel requestModel, HttpServletResponse response) throws IOException {
        ItemCreateServiceModel serviceModel = modelMapper.map(requestModel, ItemCreateServiceModel.class);
        itemsService.create(serviceModel);

        response.sendRedirect("/items/merchant");
    }
}
