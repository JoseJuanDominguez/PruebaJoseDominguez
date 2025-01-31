package com.PruebaJoseDominguez.Controller;

import com.PruebaJoseDominguez.ServiceImpl.UsuarioServiceImpl;
import com.PruebaJoseDominguez.dto.UsuarioDto;
import com.PruebaJoseDominguez.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    @RequestMapping(value="/allUsuarios", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDto>>findAll(){
        List<Usuario> allUsuarios = usuarioServiceImpl.findAll();
        if(allUsuarios.isEmpty()) {
            return new ResponseEntity<List<UsuarioDto>>(HttpStatus.OK);
        }
        List<UsuarioDto> usuariosDto = UsuarioDto.getInstance(allUsuarios);
        return new ResponseEntity<List<UsuarioDto>>(usuariosDto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value="/nuevoUsuario", method = RequestMethod.POST)
    public ResponseEntity<UsuarioDto>registroUsuario(@RequestBody UsuarioDto miDto){
        Usuario usuario = new Usuario();
        usuario.setNombre(miDto.getNombre());
        usuario.setCorreo(miDto.getCorreo());
        usuario.setEdad(miDto.getEdad());
        Usuario nuevoUsuario = usuarioServiceImpl.registrarUsuario(usuario);

        if(nuevoUsuario == null) {
            return new ResponseEntity<UsuarioDto>(UsuarioDto.getInstance(nuevoUsuario), HttpStatus.NO_CONTENT);
        }
        UsuarioDto nuevoUsuarioDto =UsuarioDto.getInstance(nuevoUsuario);
        return new ResponseEntity<UsuarioDto>(nuevoUsuarioDto, HttpStatus.OK);

    }

}
