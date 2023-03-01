package uz.jahongir.library.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Permission;


@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
    boolean existsByName(String name);
}
