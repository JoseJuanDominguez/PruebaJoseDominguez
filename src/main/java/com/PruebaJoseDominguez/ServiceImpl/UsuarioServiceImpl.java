package com.PruebaJoseDominguez.ServiceImpl;

import com.PruebaJoseDominguez.Service.UsuarioService;
import com.PruebaJoseDominguez.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import com.PruebaJoseDominguez.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario registrarUsuario(Usuario us) {
        return usuarioRepository.save(us);
    }
}
