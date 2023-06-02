import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirDados {
    public static void main(String[] args){
        String SQLinserirDados = "INSERT INTO pessoa (cpf, nome)"+"VALUES (192834671, 'Igor')";
        String driver = "jdbc:postgresql://localhost:5432/DadosGerais";
        Statement st = null;
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "123")){
            if(conn != null){
                System.out.println("Connected to the database!");
            }else{
                System.out.println("Failed to make connection!");
            }
            System.out.println("Inserindo dados na tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLinserirDados);
            System.out.println("Dados Inseridos!");
            st.close();
            conn.close();
        }catch (SQLException e){
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
