package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Region> findAllByPage(int pageNum) {
        Pageable pageable= PageRequest.of(pageNum-1,PAGE_SIZE);
        Page<Region> page = regionRepository.findAll(pageable);
        return page;
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }
}
