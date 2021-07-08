package br.com.taskfinder.usuario;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;

public class FormAtualizacao {

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String profissao;

    @NotBlank
    private String contato1;

    @NotBlank
    private String contato2;

    @CNPJ
    private String cnpj;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
