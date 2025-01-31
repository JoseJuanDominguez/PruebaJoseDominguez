package com.PruebaJoseDominguez.repository;

import com.PruebaJoseDominguez.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
