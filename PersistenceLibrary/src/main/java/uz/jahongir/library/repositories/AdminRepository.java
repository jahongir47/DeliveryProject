package uz.jahongir.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uz.jahongir.library.entities.Admin;

@Repository
public interface AdminRepository extends PagingAndSortingRepository<Admin, Long> {
    boolean existsByLastName(String lastName);
    boolean existsByFirstName(String firstName);
    boolean existsByUserName(String userName);
}
