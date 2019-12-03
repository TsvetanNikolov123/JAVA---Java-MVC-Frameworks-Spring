package softuni.heroes.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.heroes.data.models.Hero;

import java.util.Optional;

@Repository
public interface HeroesRepository extends JpaRepository<Hero, Long> {

    Optional<Hero> getByNameIgnoreCase(String name);
}
