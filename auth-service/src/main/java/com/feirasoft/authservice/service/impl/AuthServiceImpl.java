package com.feirasoft.authservice.service.impl;


import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.dto.TokenDto;
import com.feirasoft.authservice.dto.AuthDto;
import com.feirasoft.authservice.model.UserProfile;
import com.feirasoft.authservice.model.UserRoles;
import com.feirasoft.authservice.repository.UserRepository;
import com.feirasoft.authservice.security.JwtProvider;
import com.feirasoft.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(AuthDto req) {
        User userByEmail = repository.findUserByEmail(req.getEmail());
        User userByUsername = repository.findUserByUsername(req.getUsername());

        // check for duplicate
        if(userByEmail != null || userByUsername != null) return null;

        User user = new User()
                .setUsername(req.getUsername())
                .setPassword(passwordEncoder.encode(req.getPassword()))
                .setRole(UserRoles.STUDENT);
        // TODO: Send logs to kafka
        return repository.save(user);
    }

    @Override
    public TokenDto generateToken(AuthDto req) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getUsername(),
                            req.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(jwt);
            return tokenDto;

        } catch (BadCredentialsException e) {
            log.error("Bad Credential", e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }


}
