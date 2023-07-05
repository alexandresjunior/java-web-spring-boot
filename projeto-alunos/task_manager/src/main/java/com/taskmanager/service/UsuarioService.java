package com.taskmanager.service;

import com.taskmanager.model.Usuario;
import com.taskmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public Usuario salvarUsuario(Usuario usuario){
        UserDetails usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());

        if (Objects.nonNull(usuarioBD)) {
            return null;
        }

        String senha = usuario.getSenha();
        BCryptPasswordEncoder encoder = authenticationService.getPasswordEncoder();
        usuario.setSenha(encoder.encode(senha));
        usuarioRepository.save(usuario);

        return usuario;
    }

    public Page<Usuario> listarUsuario(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Usuario editarUsuario(long id, Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            usuario.setIdUsuario(id);
            String senha = usuario.getSenha();
            BCryptPasswordEncoder encoder = authenticationService.getPasswordEncoder();
            usuario.setSenha(encoder.encode(senha));
            usuarioRepository.save(usuario);
            return usuario;
        }

        return null;
    }

    public Boolean deletarUsuario (long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isEmpty()){
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }

    public Usuario buscarUsuarioId(long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isEmpty()){
            return null;
        }

        return usuarioOptional.get();
    }
}

