package br.com.taskfinder.usuario;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @NotNull
    @NotEmpty
    private Long id;

    @Column(name = "NOME")
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "USUARIO")
    @NotNull
    @NotEmpty
    private String usuario;

    @Column(name = "EMAIL")
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @Column(name = "SENHA")
    @NotNull
    @NotEmpty
    private String senha;

    @Column(name = "CIDADE")
    @NotNull
    @NotEmpty
    private String cidade;

    @Column(name = "ESTADO")
    @NotNull
    @NotEmpty
    private String estado;

    @Column(name = "PROFISSAO")
    @NotNull
    @NotEmpty
    private String profissao;

    @Column(name = "CONTATO_1")
    @NotNull
    @NotEmpty
    private String contato1;

    @Column(name = "CONTATO_2")
    @NotNull
    @NotEmpty
    private String contato2;

    @Column(name = "PERFIL")
    @NotNull
    @NotEmpty
    private Perfil perfil;

    public Usuario() {

    }

    public Usuario(String nome, String usuario, String email, String senha, Perfil perfil){
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
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

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getContato1() {
        return contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
