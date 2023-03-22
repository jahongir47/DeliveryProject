package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.PermissionService;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.repositories.PermissionRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        return (List<Permission>) permissionRepository.findAll();
    }

    @Override
    public Map<String, Object> findAll(Map<String, Object> params) {

        Integer start = Integer.valueOf((String) params.get("start"));
        Integer length = Integer.valueOf((String) params.get("length"));

        Integer columnIndex = Integer.valueOf((String) params.get("order[0][column]"));
        String filedNameKey = "columns[" + columnIndex + "][name]";
        String fieldName = (String) params.get(filedNameKey);
        String direction = (String) params.get("order[0][dir]");

        String keyword=(String) params.get("search[value]");

        Sort sort = Sort.by(Sort.Direction.valueOf(direction.toUpperCase()), fieldName);
        Pageable pageable = PageRequest.of(start / length, length, sort);
        Page<Permission> page = permissionRepository.findAll(keyword, pageable);
        Map<String, Object> result = new HashMap<>();
        List<Permission> list = page.getContent();
        result.put("recordsTotal", page.getTotalElements());
        result.put("recordsFiltered", page.getTotalElements());
        List<Object[]> objects = new ArrayList<>(list.size());
        list.forEach(permission ->
                objects.add(new Object[]{
                        permission.getId(),
                        permission.getName(),
                        permission.getCreatedAt(),
                }));
        result.put("data", objects);
        return result;
    }

    @Override
    public Page<Permission> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir, String keyword) {

        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<Permission> page = keyword != null ? permissionRepository.findAll(keyword, pageable) : permissionRepository.findAll(pageable);
        return page;
    }

    @Override
    public Permission findById(Long id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        permissionRepository.deleteById(id);
    }
}
