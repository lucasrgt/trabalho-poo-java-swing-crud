package model;

import enums.CursosEnum;

import java.io.Serializable;

public class EstudanteModel implements Serializable {
    private int id;
    private String nomeCompleto;
    private String anoMatricula;
    private String email;
    private String endereco;
    private String CEP;
    private int telefone;
    private String usuario;
    private String senha;
    private CursosEnum curso;
    private String observacoes;
    private boolean isAtivo;
}
