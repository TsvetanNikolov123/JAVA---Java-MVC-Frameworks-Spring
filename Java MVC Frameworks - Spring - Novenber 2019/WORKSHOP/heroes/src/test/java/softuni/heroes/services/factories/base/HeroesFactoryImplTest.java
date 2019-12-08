package softuni.heroes.services.factories.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.enums.Gender;
import softuni.heroes.services.factories.base.HeroesFactoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softuni.heroes.services.factories.HeroesConstants.*;

class HeroesFactoryImplTest {

    private HeroesFactoryImpl factory;

    @BeforeEach
    void setupTest() {
        factory = new HeroesFactoryImpl();
    }

    @Test
    void create_withNameAndGender_shouldReturnHeroWithDefaultProps() {
        String name = "Hero";
        Gender gender = Gender.FEMALE;

        Hero hero = factory.create(name, gender);

        assertEquals(name, hero.getName());
        assertEquals(gender, hero.getGender());
        assertEquals(INITIAL_ATTACK, hero.getAttack());
        assertEquals(INITIAL_DEFENCE, hero.getDefence());
        assertEquals(INITIAL_STAMINA, hero.getStamina());
        assertEquals(INITIAL_STRENGTH, hero.getStrength());
    }
}
