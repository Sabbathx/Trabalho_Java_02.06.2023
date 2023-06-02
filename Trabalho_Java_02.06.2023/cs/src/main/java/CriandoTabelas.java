import java.util.Scanner;

public class CriandoTabelas {
    static String driverJDBC = "org.postgresql.Driver";
    
    public static void main(String args[]) {
        try{
            System.out.println("Carregando driver JDBC...");
            Class.forName(driverJDBC);
            System.out.println("Driver carregado!");
        }catch(ClassNotFoundException e){
            System.out.printf("Falha no carregamento! %s", e);
        }
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 6) {
            System.out.println("------------ Menu de Seleção ------------");
            System.out.println("|1. Criar a Tabela Pessoa               |");
            System.out.println("|2. Inserir Valores nome e cpf na Tabela|");
            System.out.println("|3. Consultar os Dados da Tabela        |");
            System.out.println("|4. Atualizar os Dados da Tabela        |");
            System.out.println("|5. Excluir os Dados da Tabela          |");
            System.out.println("|6: Sair                                |");
            System.out.println("-----------------------------------------");
            System.out.print("Digite a opção desejada: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
            
            switch (opcao) {
                case 1:
                    InserindoDados.main(args);
                    break;
                case 2:
                    InserirDados.main(args);
                    break;
                case 3:
                    ConsultarDados.main(args);
                    break;
                case 4:
                    AtualizarDados.main(args);
                    break;
                case 5:
                    ExcluindoDados.main(args);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }
}