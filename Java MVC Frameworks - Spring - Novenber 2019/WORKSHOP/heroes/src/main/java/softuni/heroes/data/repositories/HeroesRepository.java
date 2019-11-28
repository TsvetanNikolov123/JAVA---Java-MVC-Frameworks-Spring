package softuni.heroes.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.heroes.data.models.Hero;

import java.util.Optional;

public interface HeroesRepository extends JpaRepository<Hero, Long> {

    Optional<Hero> getByNameIgnoreCase(String name);
}
