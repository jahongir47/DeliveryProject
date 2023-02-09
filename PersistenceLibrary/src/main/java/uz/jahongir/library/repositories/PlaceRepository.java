package uz.jahongir.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Place;


@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {
}
