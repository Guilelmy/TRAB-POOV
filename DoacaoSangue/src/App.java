import java.sql.SQLException;
import java.util.Scanner;

import poov.modelo.dao.DAOFactory;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoMenuPrincipal;
        DAOFactory factory = new DAOFactory();
        try {
            factory.abrirConexao();
        } catch (SQLException ex) {
            DAOFactory.mostrarSQLException(ex);
        } finally {
            //factory.fecharConexao();
        }
        
        do {
            System.out.println("Menu Principal:");
            System.out.println("1 - Doador");
            System.out.println("2 - Doação");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcaoMenuPrincipal = scanner.nextInt();
            
            switch (opcaoMenuPrincipal) {
                case 1:
                    int opcaoDoador;
                    do {
                        System.out.println("\nDoador:");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Pesquisar");
                        System.out.println("3 - Alterar");
                        System.out.println("4 - Remover");
                        System.out.println("5 - Voltar");
                        System.out.print("Opção: ");
                        opcaoDoador = scanner.nextInt();
                        
                        switch (opcaoDoador) {
                            case 1:
                                System.out.println("Cadastrar doador...");
                                break;
                            case 2:
                                int opcaoPesquisar;
                                do {
                                    System.out.println("\nPesquisar:");
                                    System.out.println("1 - Pelo código");
                                    System.out.println("2 - Pelo nome");
                                    System.out.println("3 - Pelo CPF");
                                    System.out.println("4 - Voltar");
                                    System.out.print("Opção: ");
                                    opcaoPesquisar = scanner.nextInt();
                                    
                                    switch (opcaoPesquisar) {
                                        case 1:
                                            System.out.println("Pesquisar pelo código...");
                                            break;
                                        case 2:
                                            System.out.println("Pesquisar pelo nome...");
                                            break;
                                        case 3:
                                            System.out.println("Pesquisar pelo CPF...");
                                            break;
                                        case 4:
                                            System.out.println("Voltando ao menu de Doador...");
                                            break;
                                        default:
                                            System.out.println("Opção inválida. Tente novamente.");
                                            break;
                                    }
                                } while (opcaoPesquisar != 4);
                                break;
                            case 3:
                                System.out.println("Alterar doador...");
                                break;
                            case 4:
                                System.out.println("Remover doador...");
                                break;
                            case 5:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                                break;
                        }
                    } while (opcaoDoador != 5);
                    break;
                
                case 2:
                    System.out.println("Menu de Doação...");
                    break;
                    
                case 3:
                    System.out.println("Saindo do programa...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcaoMenuPrincipal != 3);
        
        scanner.close();
    }
}
