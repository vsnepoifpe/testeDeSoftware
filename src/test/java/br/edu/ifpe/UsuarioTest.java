package br.edu.ifpe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {


    @Mock
    private UsuarioReporitorio usuarioReporitorio;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    public void configurar() {
        usuario = Usuario.builder()
                .nome("Vilmar")
                .email("vilmar@gmail.com")
                .cpf("11111111111")
                .build();
    }

    @Test
    public void testeUsuarioCadastroComSucesso() {
        
        assertDoesNotThrow(() -> this.usuarioService.cadastrar(this.usuario)); 
        
        verify(this.usuarioReporitorio, times(1)).inserir(this.usuario);
    }

    @Test
    public void testeUsuarioCadastroComNomeVazio() {
        this.usuario.setNome("");
        
        when(this.usuarioReporitorio.findByEmail()).then(null);

        Exception ex = assertThrows(Exception.class, () -> {
            this.usuarioService.cadastrar(this.usuario);
        });

        Assertions.assertEquals(ex.getMessage(), 
        "Nome Vazio!");

        verify(this.usuarioReporitorio, times(0)).inserir(this.usuario);
    }

    @Test
    public void testeUsuarioCadastroComEmailVazio() {
        this.usuario.setEmail("");

        when(this.usuarioReporitorio.findByEmail()).then(null);

        Exception ex = assertThrows(Exception.class, () -> {
            this.usuarioService.cadastrar(this.usuario);
        });

        Assertions.assertEquals(ex.getMessage(), 
        "Email Vazio!");

        verify(this.usuarioReporitorio, never()).inserir(this.usuario);
    }

}
