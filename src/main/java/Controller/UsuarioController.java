package Controller;

import Service.UsuarioService;
import ServiceImpl.UsuarioServiceImpl;
import dto.UsuarioDto;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    @RequestMapping(value="/allUsuarios", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDto>>findAll(){
        List<Usuario> allUsuarios = usuarioServiceImpl.findAll();
        if(allUsuarios.isEmpty()) {
            return new ResponseEntity<List<UsuarioDto>>(HttpStatus.NOT_FOUND);
        }
        List<UsuarioDto> usuariosDto = UsuarioDto.getInstance(allUsuarios);
        return new ResponseEntity<List<UsuarioDto>>(usuariosDto, HttpStatus.OK);
    }

    @RequestMapping(value="/nuevoUsuario", method = RequestMethod.POST)
    public ResponseEntity<UsuarioDto>registroUsuario(@RequestBody UsuarioDto miDto){
        Usuario usuario = new Usuario();
        usuario.setNombre(miDto.getNombre());
        usuario.setCorreo(miDto.getCorreo());
        usuario.setEdad(miDto.getEdad());
        usuario.setActivo(false);
        Usuario nuevoUsuario = usuarioServiceImpl.registrarUsuario(usuario);

        if(nuevoUsuario == null) {
            return new ResponseEntity<UsuarioDto>(UsuarioDto.getInstance(nuevoUsuario), HttpStatus.NO_CONTENT);
        }
        UsuarioDto nuevoUsuarioDto =UsuarioDto.getInstance(nuevoUsuario);
        return new ResponseEntity<UsuarioDto>(nuevoUsuarioDto, HttpStatus.OK);

    }

}
