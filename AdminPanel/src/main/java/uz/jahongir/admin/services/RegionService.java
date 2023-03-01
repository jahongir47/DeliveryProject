package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Region;

import java.util.List;

public interface RegionService {
    int PAGE_SIZE=5;
    Region save(Region region);

    List<Region> findAll();
    Page<Region> findAllByPage(int pageNum);

    Region findById(Long id);

    void deleteById(Long id);
}
