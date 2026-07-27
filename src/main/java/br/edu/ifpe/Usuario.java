package br.edu.ifpe;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Usuario {

    private String nome;
    private String cpf;
    private String email;
}
