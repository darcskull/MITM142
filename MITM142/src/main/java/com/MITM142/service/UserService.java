package com.MITM142.service;
import com.MITM142.data.User;
import com.MITM142.exception.BadRequestException;
import com.MITM142.exception.ConflictException;
import com.MITM142.exception.GeneralException;
import com.MITM142.exception.NotFoundException;
import com.MITM142.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userDataRepository;

    public User verifyLogin(String email, String password) {
        User loggedUser = userDataRepository.findUserByEmailAndPassword(email, password);
        if (loggedUser == null) {
            throw new NotFoundException("User was not found");
        }

        return loggedUser;

    }

    public void registerUser(User user) {
        if (Objects.equals(user.getPhoneNumber(), "") || Objects.equals(user.getEmail(), "") ||
                Objects.equals(user.getPassword(), "") || Objects.equals(user.getLastName(), "") ||
                Objects.equals(user.getFirstName(), "")) {
            throw new BadRequestException("Empty values are not allowed");
        }

        if (userDataRepository.doesUserExistByEmail(user.getEmail())) {
            throw new ConflictException("The email is already registered");
        }

        if (!isValidPhoneNumber(user.getPhoneNumber())) {
            throw new GeneralException("The provided phone number is invalid");
        }
        try {
            userDataRepository.createUser(user);
        } catch (Exception exception) {
            throw new GeneralException("An error has occurred, the provided data was not registered");
        }

    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "08\\d{8}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
