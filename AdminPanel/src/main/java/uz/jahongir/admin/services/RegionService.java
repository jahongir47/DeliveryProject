package uz.jahongir.admin.services;

import uz.jahongir.library.entities.Region;

import java.util.List;

public interface RegionService {
    Region save(Region region);

    List<Region> findAll();
}
