//package uz.jahongir.admin.services.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.catalina.connector.Request;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//import uz.jahongir.admin.services.RequestService;
//import uz.jahongir.library.repositories.RegionRepository;
//import uz.jahongir.library.repositories.RequestRepository;
//
//import java.util.List;
//@Service
//@RequiredArgsConstructor
//public class RequestServiceImpl implements RequestService {
//    private final RequestRepository requestRepository;
//    private final RegionRepository regionRepository;
//
//    @Override
//    public List<Request> save(List<Request> request) {
//        return regionRepository.saveAll(request);
//    }
//
//    @Override
//    public List<Request> findAll() {
//        return null;
//    }
//
//    @Override
//    public Page<Request> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir) {
//        return null;
//    }
//
//    @Override
//    public uz.jahongir.library.entities.Request findById(Long id) {
//        return requestRepository.findById(id).get();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//}
