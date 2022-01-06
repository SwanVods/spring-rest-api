package com.feirasoft.authservice.service.impl;

import com.feirasoft.authservice.dto.ProfileDto;
import com.feirasoft.authservice.dto.UserDto;
import com.feirasoft.authservice.dto.mapper.EntityMapper;
import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.model.UserProfile;
import com.feirasoft.authservice.model.UserRoles;
import com.feirasoft.authservice.repository.UserDetailsRepository;
import com.feirasoft.authservice.repository.UserRepository;
import com.feirasoft.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getDistinctTopByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }

    @Override
    public UserDto getUserDetails(String username) throws UsernameNotFoundException {
        User user = repository.getDistinctTopByUsername(username);
        if(user == null) throw new UsernameNotFoundException("Username not found");
        return EntityMapper.toUserDto(user);
    }

    @Override
    public ProfileDto addUserProfile(ProfileDto profileDto, Long id) {
        User user = repository.findUserById(id);
        if(user == null) return null;

        UserProfile userProfile = new UserProfile()
                .setUser(user)
                .setImage(profileDto.getImage())
                .setLastName(profileDto.getLastName())
                .setFirstName(profileDto.getFirstName())
                .setDob(profileDto.getDob())
                .setBio(profileDto.getBio());
        return EntityMapper.toProfileDto(userDetailsRepository.save(userProfile));
    }

    @Override
    public ProfileDto updateUserProfile(ProfileDto profileDto, Long id) {
        User user = repository.findUserById(id);
        if(user == null) return null;

        UserProfile userProfile = user.getProfile()
                .setUser(user)
                .setImage(profileDto.getImage())
                .setLastName(profileDto.getLastName())
                .setFirstName(profileDto.getFirstName())
                .setDob(profileDto.getDob())
                .setBio(profileDto.getBio());
        return EntityMapper.toProfileDto(userDetailsRepository.save(userProfile));
    }

    @Override
    public Collection<UserDto> retrieveAllUsers(String username) {
        if(getUserDetails(username).getRole() != UserRoles.ADMIN) throw new RuntimeException("Unauthorized");
        return repository.findAll()
                .stream()
                .map(EntityMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
