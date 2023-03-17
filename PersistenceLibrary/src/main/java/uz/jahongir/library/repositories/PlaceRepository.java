package uz.jahongir.library.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Place;


@Repository
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {
    boolean existsByName(String name);
    @Query("select p from Place p where lower(concat(p.id,' ',p.name))  like concat('%', lower(:keyword) ,'%') ")
    Page<Place> findAll(@Param("keyword") String keyword, Pageable pageable);
}
