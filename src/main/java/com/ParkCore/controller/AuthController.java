package com.ParkCore.controller;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParkCore.dto.LoginRequestDTO;
import com.ParkCore.dto.RegisterRequestDTO;
import com.ParkCore.dto.ResponseDTO;
import com.ParkCore.enums.UserRole;
import com.ParkCore.exceptions.BadRequestException;
import com.ParkCore.infra.security.TokenService;
import com.ParkCore.model.User;
import com.ParkCore.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final TokenService tokenService;
	
	@PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByName(body.getName()).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        if(passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        	throw new ObjectNotFoundException(user.getId(), User.class.getName());
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.repository.findByName(body.getName());

        if(user.isEmpty()) {
        	User newUser = new User();
            newUser.setName(body.getName());
            newUser.setPassword(passwordEncoder.encode(body.getPassword()));
            //In this phase, it's interesting to use Flyway.
            newUser.setRole(UserRole.USER);
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        throw new BadRequestException("Não foi possivel registrar o usuario!!");
    }
	
}
