package uz.jahongir.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {
}
