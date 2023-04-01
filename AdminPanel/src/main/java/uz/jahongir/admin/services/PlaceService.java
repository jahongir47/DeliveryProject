package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.admin.dto.DatatableOutput;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Place;


import java.util.List;
import java.util.Optional;

public interface PlaceService {
    int PAGE_SIZE=10;
    Place save(Place Place);

    List<Place> findAll();

    void deleteById(Long id);

    Optional<Place> findById(Long id);
    DatatableOutput<Place> findAll(Integer start, Integer length);


    Page<Place> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir, String keyword);
}
