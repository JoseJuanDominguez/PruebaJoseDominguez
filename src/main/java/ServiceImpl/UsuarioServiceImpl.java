package ServiceImpl;

import Service.UsuarioService;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UsuarioRepository;

import java.util.List;

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
