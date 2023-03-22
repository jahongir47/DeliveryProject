//package uz.jahongir.admin.services.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import uz.jahongir.admin.services.UserService;
//import uz.jahongir.library.entities.User;
//import uz.jahongir.library.repositories.UserRepository;
//
//import java.util.List;
//@Service
////@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
////    private final PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User save(User user1) {
//        return userRepository.save(user1);
//    }
//
////    @Override
////    public List<User> findAll() {
////        return userRepository.findAll();
////    }
//
//    @Override
//    public User findById(Integer id) {
//        return userRepository.findById(id).get();
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//userRepository.deleteById(id);
//    }
//}
