package com.proyecto.react.Controllers;

import com.proyecto.react.Models.Rol;
import com.proyecto.react.Models.Usuario;
import com.proyecto.react.Security.Dtos.JwtDto;
import com.proyecto.react.Security.Dtos.LoginUser;
import com.proyecto.react.Security.Dtos.NewUser;
import com.proyecto.react.Security.JWT.JwtProvider;
import com.proyecto.react.Security.Models.Message;
import com.proyecto.react.Services.RolService;
import com.proyecto.react.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService userService;
    private final RolService roleService;
    private final JwtProvider jwtProvider;


    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder,
                          UsuarioService userService, RolService roleService, JwtProvider jwtProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult) {
        if (bidBindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        }
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Usuario usuario = userService.findByUsername(userDetails.getUsername());
            JwtDto jwtDto = new JwtDto(jwt, usuario);
            return ResponseEntity.ok(jwtDto);
        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Revise sus credenciales" + e), HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/register")
//    public ResponseEntity<Object> resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
//        Usuario user = new Usuario(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()) , newUser.getFotoUsuario(), newUser.getEstadoUsuario(), newUser.getPersona());
//        List<Rol> roles = new ArrayList<>();
//        for (Rol rol : newUser.getRoles()) {
//            roles.add(roleService.findByNombreRol(rol.getNombreRol()));
//        }
//        user.setRoles(roles);
//        userService.save(user);
//        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
//    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        try {
            c.setEstadoUsuario(true);
            c.setPassword(passwordEncoder.encode(c.getPassword()));
            return new ResponseEntity<>(userService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
