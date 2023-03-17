package uz.jahongir.library.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import uz.jahongir.library.entities.Request;

public interface RequestRepository extends PagingAndSortingRepository<Request, Long> {
}
