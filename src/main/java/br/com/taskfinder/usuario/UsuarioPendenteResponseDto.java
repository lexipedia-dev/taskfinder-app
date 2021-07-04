package br.com.taskfinder.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPendenteResponseDto {

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

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmil() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioPendenteResponseDto(Usuario usuario){
        this.nome = usuario.getNome();
        this.usuario = usuario.getUsuario();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public static List<UsuarioPendenteResponseDto> toDtoList(List<Usuario> usuarios) {
        List<UsuarioPendenteResponseDto> usuariosDto = new ArrayList<>();
        for(Usuario usuario : usuarios){
            usuariosDto.add(new UsuarioPendenteResponseDto(usuario));
        }
        return usuariosDto;
    }

}
