package softuni.heroes.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.heroes.data.models.enums.Gender;
import softuni.heroes.services.models.heroes.HeroCreateServiceModel;
import softuni.heroes.web.view.models.HeroCreateModel;

@Configuration
public class ModelMapperConfig {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        initMapper(modelMapper);
    }

    private static void initMapper(ModelMapper mapper) {
        Converter<String, Gender> stringToGenderConverter =
                ctx -> Gender.valueOf(ctx.getSource().toUpperCase());

        mapper.createTypeMap(HeroCreateModel.class, HeroCreateServiceModel.class)
                .addMappings(map -> map
                        .using(stringToGenderConverter)
                        .map(
                                HeroCreateModel::getGender,
                                HeroCreateServiceModel::setGender
                        )
                );
    }

    @Bean
    public ModelMapper modelMapper() {
        return modelMapper;
    }
}
