package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.library.entities.Place;


import java.util.List;
import java.util.Optional;

public interface PlaceService {
    int PAGE_SIZE=10;
    Place save(Place Place);

    List<Place> findAll();

    void deleteById(Long id);

    Optional<Place> findById(Long id);


    Page<Place> findAllByPage(int pageNum);
}
