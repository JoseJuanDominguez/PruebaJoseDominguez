package com.PruebaJoseDominguez.Service;

import com.PruebaJoseDominguez.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario registrarUsuario(Usuario us);

}
