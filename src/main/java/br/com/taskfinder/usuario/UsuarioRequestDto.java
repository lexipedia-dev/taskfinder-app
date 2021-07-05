package br.com.taskfinder.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioRequestDto {

    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String usuario;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String senha;

    public UsuarioRequestDto(){

    }

    public UsuarioRequestDto(String nome, String email, String usuario, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toModel(UsuarioRequestDto dto){
        Usuario usuario = new Usuario(dto.getNome(), dto.getUsuario(), dto.getEmail(), dto.getSenha(), Perfil.CONTRATADO);
        return usuario;

    }

}
