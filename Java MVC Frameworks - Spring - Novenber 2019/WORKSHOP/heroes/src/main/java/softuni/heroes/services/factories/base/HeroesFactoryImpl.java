package softuni.heroes.services.factories.base;

import softuni.heroes.config.annotation.Factory;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.enums.Gender;
import softuni.heroes.services.factories.HeroesFactory;

@Factory
public class HeroesFactoryImpl implements HeroesFactory {
    @Override
    public Hero create(String name, Gender gender) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setAttack(1);
        hero.setDefence(1);
        hero.setLevel(1);
        hero.setStamina(1);
        hero.setStrength(1);
        return hero;
    }
}
