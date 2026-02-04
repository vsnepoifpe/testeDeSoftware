package br.edu.ifpe;


import lombok.Builder;

@Builder
public class Usuario {

    private String nome;
    private String cpf;
    private Integer idade;
}
