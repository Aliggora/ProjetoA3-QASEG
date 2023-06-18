package sistemaChamados;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class UsuarioNGTest {

    @Test
    public void lerUsuariosTest() {
        List<Usuario> usuariosEsperados = new ArrayList<>();
        usuariosEsperados.add(new Usuario("João Silva", "123", "joao.silva", "senha123"));
        usuariosEsperados.add(new Usuario("Maria Santos", "456", "maria.santos", "senha456"));

        List<Usuario> usuariosLidos = Usuario.lerUsuarios();

        assertEquals(usuariosLidos.size(), usuariosEsperados.size());
        for (int i = 0; i < usuariosLidos.size(); i++) {
            Usuario usuarioLido = usuariosLidos.get(i);
            Usuario usuarioEsperado = usuariosEsperados.get(i);

            assertEquals(usuarioLido.getNome(), usuarioEsperado.getNome());
            assertEquals(usuarioLido.getRegistro(), usuarioEsperado.getRegistro());
            assertEquals(usuarioLido.getUsername(), usuarioEsperado.getUsername());
            assertEquals(usuarioLido.getSenha(), usuarioEsperado.getSenha());
        }
    }

    @Test
    public void gravarUsuariosTest() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João Silva", "123", "joao.silva", "senha123"));
        usuarios.add(new Usuario("Maria Santos", "456", "maria.santos", "senha456"));

        Usuario.gravarUsuarios(usuarios);

        List<Usuario> usuariosLidos = Usuario.lerUsuarios();

        assertEquals(usuariosLidos.size(), usuarios.size());
        for (int i = 0; i < usuariosLidos.size(); i++) {
            Usuario usuarioLido = usuariosLidos.get(i);
            Usuario usuarioEsperado = usuarios.get(i);

            assertEquals(usuarioLido.getNome(), usuarioEsperado.getNome());
            assertEquals(usuarioLido.getRegistro(), usuarioEsperado.getRegistro());
            assertEquals(usuarioLido.getUsername(), usuarioEsperado.getUsername());
            assertEquals(usuarioLido.getSenha(), usuarioEsperado.getSenha());
        }
    }
}
