package com.demo.application.registrationsimplewebapp.services;

import org.springframework.stereotype.Service;

import com.demo.application.registrationsimplewebapp.converters.UserDtoToUserConverter;
import com.demo.application.registrationsimplewebapp.converters.UserToUserDtoConverter;
import com.demo.application.registrationsimplewebapp.dto.UserDto;
import com.demo.application.registrationsimplewebapp.exceptions.UserAlreadyExistsException;
import com.demo.application.registrationsimplewebapp.model.User;
import com.demo.application.registrationsimplewebapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserDtoToUserConverter userDtoToUserConverter;

    private final UserToUserDtoConverter userToUserDtoConverter;

    public UserServiceImpl(UserRepository userRepository,
            UserDtoToUserConverter userDtoToUserConverter,
            UserToUserDtoConverter userToUserDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoToUserConverter = userDtoToUserConverter;
        this.userToUserDtoConverter = userToUserDtoConverter;
    }

    @Override
    public UserDto registerNewUser(UserDto user) throws UserAlreadyExistsException {
        if (userWithGivenEmailExists(user.getEmail())) {
            throw new UserAlreadyExistsException("Given email address is already used");
        }

        User newUser = userDtoToUserConverter.convert(user);
        if (newUser != null) {
            User savedUser = userRepository.save(newUser);
            return userToUserDtoConverter.convert(savedUser);
        }

        return user;
    }

    private boolean userWithGivenEmailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
