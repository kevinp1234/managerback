package com.football.managerback.manager.user;

import com.football.managerback.domain.user.*;
import com.football.managerback.infrastructure.validation.ValidationService;
import com.football.managerback.manager.Status;
import com.football.managerback.manager.user.dto.UserFullInfo;
import com.football.managerback.manager.user.dto.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    public List<UserInfo> getUsers() {
        List<User> users = userRepository.findUsersBy(Status.ACTIVE);
        return userMapper.toUserInfos(users);
    }

    public void addUser(UserFullInfo userFullInfo) {
        validateUsernameAvailability(userFullInfo);
        validateEmailAvailability(userFullInfo);
        createAndSaveUser(userFullInfo);
    }

    private void validateEmailAvailability(UserFullInfo userFullInfo) {
        boolean emailExists = userRepository.emailExists(userFullInfo.getEmail());
        ValidationService.validateEmailAvailable(emailExists);
    }

    private void validateUsernameAvailability(UserFullInfo userFullInfo) {
        boolean usernameExists = userRepository.usernameExists(userFullInfo.getUsername());
        ValidationService.validateUsernameAvailable(usernameExists);
    }

    private void createAndSaveUser(UserFullInfo userFullInfo) {
        User user = createUser(userFullInfo);
        userRepository.save(user);
    }

    private User createUser(UserFullInfo userFullInfo) {
        Role role = roleRepository.findRoleBy(userFullInfo.getRoleName());
        User user = userMapper.toUser(userFullInfo);
        user.setRole(role);
        return user;
    }
}