package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.PlaceService;
import uz.jahongir.library.entities.Place;
import uz.jahongir.library.repositories.PlaceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> findAll() {
        return (List<Place>) placeRepository.findAll();
    }
}
