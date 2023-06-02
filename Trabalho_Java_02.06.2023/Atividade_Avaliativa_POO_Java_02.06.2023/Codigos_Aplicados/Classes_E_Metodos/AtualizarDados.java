import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AtualizarDados {
    public static void main(String[] args){
        String SQLatualizarDados = "UPDATE pessoa SET nome = 'Ramon'";
        String driver = "jdbc:postgresql://localhost:5432/DadosGerais";
        Statement st = null;
        
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "123")){
            if(conn != null){
                System.out.println("Connected to the Database!");
            }else{
                System.out.println("Failed to make connection!");
            }
            System.out.println("Atualizando dados na tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLatualizarDados);
            System.out.println("Dados atualizados!");
            st.close();
            conn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
