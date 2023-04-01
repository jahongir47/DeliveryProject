package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.UserService;
import uz.jahongir.library.entities.Admin;
import uz.jahongir.library.entities.User;
import uz.jahongir.library.repositories.UserRepository;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }
}
