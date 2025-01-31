package Service;

import model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario registrarUsuario(Usuario us);

}
