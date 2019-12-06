package softuni.heroes.services.factories.base;

import softuni.heroes.config.annotation.Factory;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.enums.Gender;
import softuni.heroes.services.factories.HeroesFactory;

import static softuni.heroes.services.factories.HeroesConstants.*;

@Factory
public class HeroesFactoryImpl implements HeroesFactory {
    @Override
    public Hero create(String name, Gender gender) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setAttack(INITIAL_ATTACK);
        hero.setDefence(INITIAL_DEFENCE);
        hero.setLevel(INITIAL_LEVEL);
        hero.setStamina(INITIAL_STAMINA);
        hero.setStrength(INITIAL_STRENGTH);

        return hero;
    }
}
