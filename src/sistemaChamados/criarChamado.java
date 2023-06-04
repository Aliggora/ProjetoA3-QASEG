package sistemaChamados;

import java.util.Scanner;

public class criarChamado {

    private armazenaChamado armazenaChamado;
    private Scanner scanner;
    private String tipoChamadoSelecionado;

    public criarChamado(armazenaChamado armazenaChamado) {
        this.armazenaChamado = armazenaChamado;
        this.scanner = new Scanner(System.in);
        this.tipoChamadoSelecionado = "Desconhecido";
    }

    public void criarChamado() {
        System.out.println("Criar um chamado");
        System.out.println("----------------");

        System.out.println("Selecione o tipo de chamado:");
        System.out.println("1. Sistema Operacional");
        System.out.println("2. Hardware");
        System.out.println("3. Software");
        System.out.println("4. Telefonia Fixa");
        System.out.println("5. File Server");
        System.out.println("6. Internet");
        System.out.println("7. E-mail");
        System.out.println("8. Telefonia Movel");
        System.out.print("Opcao: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                tipoChamadoSelecionado = "Sistema Operacional";
                break;
            case 2:
                tipoChamadoSelecionado = "Hardware";
                break;
            case 3:
                tipoChamadoSelecionado = "Software";
                break;
            case 4:
                tipoChamadoSelecionado = "Telefonia Fixa";
                break;
            case 5:
                tipoChamadoSelecionado = "File Server";
                break;
            case 6:
                tipoChamadoSelecionado = "Internet";
                break;
            case 7:
                tipoChamadoSelecionado = "E-mail";
                break;
            case 8:
                tipoChamadoSelecionado = "Telefonia Móvel";
                break;
            default:
                System.out.println("Opção inválida. O chamado será criado com tipo desconhecido.");
                tipoChamadoSelecionado = "Desconhecido";
                break;
        }

        System.out.print("Digite a descricao do chamado: ");
        String descricao = scanner.nextLine();

        Chamado chamado = new Chamado(tipoChamadoSelecionado, descricao);
        armazenaChamado.adicionarChamado(chamado);

        System.out.println("Chamado criado com sucesso!");
        System.out.println("Tipo: " + chamado.getTipoChamado());
        System.out.println("Descricao: " + chamado.getDescricao());
        System.out.println();
    }

    public String getTipoChamadoSelecionado() {
        return tipoChamadoSelecionado;
    }
}
