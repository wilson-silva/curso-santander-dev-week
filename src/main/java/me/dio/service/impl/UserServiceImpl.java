package me.dio.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import me.dio.service.exception.BusinessException;
import me.dio.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public User create(User user) {
        ofNullable(user).orElseThrow(() -> new BusinessException("User to create must not be null."));
        ofNullable(user.getAccount()).orElseThrow(() -> new BusinessException("User account must not be null."));
        ofNullable(user.getCard()).orElseThrow(() -> new BusinessException("User card must not be null."));

        this.validateChangeableId(user.getId(), "create");
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new BusinessException("This account number already exists.");
        }
        if(userRepository.existsByCardNumber(user.getCard().getNumber())){
            throw new BusinessException("This card number already exists.");
        }
        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, User user) {
        this.validateChangeableId(id, "updated");
        this.findById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }

    private void validateChangeableId(Long id, String operation) {
        if(UNCHANGEABLE_USER_ID.equals(id)){
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
}
