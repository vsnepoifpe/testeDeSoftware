package br.edu.ifpe;

import java.util.Optional;

public interface UsuarioReporitorio {


    void inserir(Usuario usuario);

    void deletar(Integer id);

    Optional<Usuario> findByEmail();
}
