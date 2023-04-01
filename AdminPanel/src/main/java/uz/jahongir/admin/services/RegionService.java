package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.admin.dto.DatatableOutput;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Region;

import java.util.List;

public interface RegionService {
    int PAGE_SIZE=5;
    Region save(Region region);

    List<Region> findAll();
    DatatableOutput<Region> findAll(Integer start, Integer length);
    Page<Region> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir,String keyword);

    Region findById(Long id);

    void deleteById(Long id);
}
