package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.PlaceService;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Place;
import uz.jahongir.library.repositories.PermissionRepository;
import uz.jahongir.library.repositories.PlaceRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> findAll() {
        return (List<Place>) placeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }

    @Override
    public Page<Place> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<Place> page = keyword != null ? placeRepository.findAll(keyword, pageable) : placeRepository.findAll(pageable);
        return page;
    }
}
