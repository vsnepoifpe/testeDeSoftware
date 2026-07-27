package br.edu.ifpe;

public class UsuarioService {

    private UsuarioReporitorio usuarioReporitorio;

    public UsuarioService( UsuarioReporitorio repo) {
        this.usuarioReporitorio = repo;
    }

    public void cadastrar(Usuario usuario) throws Exception {

        if (usuario.getNome().isEmpty()) {
            throw new Exception("Nome Vazio!");
        }

        if (usuario.getEmail().isEmpty()) {
            throw new Exception("Email Vazio!");
        }

        if (this.usuarioReporitorio.findByEmail().isPresent()) {
            throw new Exception("Usuário Já Cadastrado!");
        }

        this.usuarioReporitorio.inserir(usuario);
    }
}
