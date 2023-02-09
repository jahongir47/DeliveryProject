package uz.jahongir.admin.services;

import uz.jahongir.library.entities.Place;


import java.util.List;

public interface PlaceService {
    Place save(Place Place);

    List<Place> findAll();
}
