package uz.jahongir.library.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Region;

@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    boolean existsByName(String regionName);

    @Query("select r from Region r where lower(concat(r.id,' ',r.name))  like concat('%', lower(:keyword) ,'%') ")
    Page<Region> findAll(@Param("keyword") String keyword, Pageable pageable);
}
