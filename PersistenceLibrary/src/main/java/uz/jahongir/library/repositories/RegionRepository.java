package uz.jahongir.library.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Region;

@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    boolean existsByName(String regionName);
}
