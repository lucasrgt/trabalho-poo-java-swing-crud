package model;

import java.io.Serializable;
import java.util.Objects;

public class EstudanteModel implements Serializable {
    private int id;
    private String nomeCompleto;
    private int anoMatricula;
    private String email;
    private String endereco;
    private String CEP;
    private String telefone;
    private String usuario;
    private String senha;
    private String curso;
    private String observacoes;
    private boolean isAtivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(int anoMatricula) {
        this.anoMatricula = anoMatricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }

    // Equals and Hashcode gerado automaticamente com o IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudanteModel that = (EstudanteModel) o;
        return id == that.id && telefone == that.telefone && isAtivo == that.isAtivo && Objects.equals(nomeCompleto, that.nomeCompleto) && Objects.equals(anoMatricula, that.anoMatricula) && Objects.equals(email, that.email) && Objects.equals(endereco, that.endereco) && Objects.equals(CEP, that.CEP) && Objects.equals(usuario, that.usuario) && Objects.equals(senha, that.senha) && curso == that.curso && Objects.equals(observacoes, that.observacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCompleto, anoMatricula, email, endereco, CEP, telefone, usuario, senha, curso, observacoes, isAtivo);
    }
}
