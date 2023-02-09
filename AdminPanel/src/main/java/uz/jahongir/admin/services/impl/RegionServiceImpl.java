package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jahongir.library.repositories.RegionRepository;
import uz.jahongir.admin.services.RegionService;
import uz.jahongir.library.entities.Region;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> findAll() {
        return (List<Region>) regionRepository.findAll();
    }
}
