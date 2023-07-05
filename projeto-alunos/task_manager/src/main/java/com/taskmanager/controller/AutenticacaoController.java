package com.taskmanager.controller;

import com.taskmanager.dto.AutenticacaoDTO;
import com.taskmanager.dto.UsuarioDTO;
import com.taskmanager.model.Usuario;
import com.taskmanager.repository.UsuarioRepository;
import com.taskmanager.service.AuthenticationService;
import com.taskmanager.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Authentication authentication;
    public Authentication getAuth(){
        return  authentication;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO autenticacaoDTO){
        try{
            authentication  = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      autenticacaoDTO.getEmail(),
                      autenticacaoDTO.getSenha()));

            Usuario usuarioLogado = (Usuario) authentication.getPrincipal();

            String token = tokenService.generateToken(usuarioLogado);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new UsuarioDTO(usuarioLogado.getNome(),
                            usuarioLogado.getSobrenome(),
                            usuarioLogado.getEmail(),
                            token));
        }catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid Usuario usuario){
        try{
            if(usuarioRepository.existsByEmail(usuario.getEmail())){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            String senha = usuario.getSenha();

            BCryptPasswordEncoder encoder = authenticationService.getPasswordEncoder();

            usuario.setSenha(encoder.encode(senha));

            usuario = usuarioRepository.save(usuario);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new UsuarioDTO(usuario.getNome(),
                            usuario.getSobrenome(),
                            usuario.getEmail(),
                            null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
