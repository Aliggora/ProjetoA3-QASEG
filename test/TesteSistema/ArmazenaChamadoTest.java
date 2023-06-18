package TesteSistema;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class SistemaChamadosTest {
    private Main main;
    private CriarChamado criarChamado;

    @Before
    public void setup() {
        main = new Main();
        criarChamado = new CriarChamado();
        criarChamado.frame.setVisible(false); // Oculta a interface gráfica para os testes
    }

    @Test
    public void testAdminLogin() {
        // Simula o login do administrador
        main.usernameTextField.setText("admin");
        main.passwordField.setText("admin".toCharArray());

        // Simula o clique no botão "Login"
        main.loginButton.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Verifica se o login do administrador foi bem-sucedido
        Assert.assertEquals("Usuário admin logado com sucesso"!", JOptionPane.getFrameForComponent(main.frame).getTitle());

        // Simula a abertura de um chamado pelo administrador
        String tipo = "Hardware";
        String descricao = "Minha placa de vídeo não suporta codec AV1";
        criarChamado.tipoComboBox.setSelectedItem(tipo);
        criarChamado.descricaoTextArea.setText(descricao);
        criarChamado.enviarButton.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Carrega os chamados existentes
        List<Chamado> chamados = ArmazenaChamado.carregarChamados();

        // Verifica se o chamado foi salvo corretamente
        Assert.assertEquals(1, chamados.size());
        Chamado chamado = chamados.get(0);
        Assert.assertEquals(tipo, chamado.getTipo());
        Assert.assertEquals(descricao, chamado.getDescricao());
    }

    @Test
    public void testUserLogin() {
        // Simula o login do usuário
        main.usernameTextField.setText("user");
        main.passwordField.setText("user".toCharArray());

        // Simula o clique no botão "Login"
        main.loginButton.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Verifica se o login do usuário foi bem-sucedido
        Assert.assertEquals("Usuário user logado com sucesso!", JOptionPane.getFrameForComponent(main.frame).getTitle());

        // Simula a abertura de um chamado pelo usuário
        String tipo = "Software";
        String descricao = "Não consigo editar XML no eSocial";
        criarChamado.tipoComboBox.setSelectedItem(tipo);
        criarChamado.descricaoTextArea.setText(descricao);
        criarChamado.enviarButton.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Carrega os chamados existentes
        List<Chamado> chamados = ArmazenaChamado.carregarChamados();

        // Verifica se o chamado foi salvo corretamente
        Assert.assertEquals(1, chamados.size());
        Chamado chamado = chamados.get(0);
        Assert.assertEquals(tipo, chamado.getTipo());
        Assert.assertEquals(descricao, chamado.getDescricao());
        
    }

    @Test
    public void test
