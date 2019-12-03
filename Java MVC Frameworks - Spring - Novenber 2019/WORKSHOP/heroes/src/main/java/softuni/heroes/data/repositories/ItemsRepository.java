package softuni.heroes.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.heroes.data.models.Item;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {

}
