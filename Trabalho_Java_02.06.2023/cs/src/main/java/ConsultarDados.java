import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConsultarDados {
    public static void main(String[] args) {
        String SQLconsultarDados = "SELECT * FROM pessoa";
        String driver = "jdbc:postgresql://localhost:5432/DadosGerais";
        Statement st = null;
        ResultSet result = null;
        
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "123")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
            System.out.println("Consultando dados na tabela...");
            st = conn.createStatement();
            result = st.executeQuery(SQLconsultarDados);
            
            while (result.next()) {
                System.out.println("-----------------");
                System.out.println("CPF: " + result.getString(1));
                System.out.println("Nome: " + result.getString(2));
            }
            
            result.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}

