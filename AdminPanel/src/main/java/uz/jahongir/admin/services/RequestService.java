package uz.jahongir.admin.services;

import org.apache.catalina.connector.Request;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RequestService {
    Request save(Request request);

    List<Request> findAll();
    Page<Request> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir);

    uz.jahongir.library.entities.Request findById(Long id);

    void deleteById(Long id);
}
