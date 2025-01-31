package com.PruebaJoseDominguez.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import com.PruebaJoseDominguez.model.Usuario;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UsuarioDto {
    @JsonProperty("idUsuario")
    private int id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("edad")
    private int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static UsuarioDto getInstance(Usuario usr) {
        UsuarioDto usrDto = new UsuarioDto();
        if(usr!=null) {
            usrDto.setId(usr.getId());
            usrDto.setCorreo(usr.getCorreo());
            usrDto.setNombre(usr.getNombre());
            usrDto.setEdad(usr.getEdad());
        }
        return usrDto;

    }

    public static List<UsuarioDto> getInstance(List<Usuario> usuarios) {
        List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>();
        for( Usuario usr: usuarios) {
            usuariosDto.add(UsuarioDto.getInstance(usr));
        }
        return usuariosDto;
    }
}
