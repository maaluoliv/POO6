import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException{
        Select select =  new Select();
        Scanner ler = new Scanner(System.in);
        int menu = 0, id;
        while (menu != 4) {
            System.out.println("============= OPÇÕES DE BUSCA =============");
            System.out.println("1 - Buscar Livros");
            System.out.println("2 - Buscar Clientes");
            System.out.println("3 - Buscar Pedidos");
            System.out.println("4 - Sair");
            System.out.println("==============================================");
            System.out.println("==Por gentileza escolha uma opção de [1-4]: ==");
            System.out.println("==============================================");
            menu = ler.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("============= LIVROS =============");
                    try {
                        select.buscaLivros();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("============= CLIENTES =============");
                    try {
                        select.buscaClientes();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("============= PEDIDOS POR CLIENTES =============");
                    System.out.println("Escreva o id do cliente: ");
                    id = ler.nextInt();
                    try {
                        select.buscarPedidos(id);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println("SISTEMA ENCERRADO!");
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;

            }
        }

    }
}
