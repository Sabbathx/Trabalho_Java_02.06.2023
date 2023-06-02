import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcluindoDados {
    public static void main(String[] args){
        String SQLexcluirDados = "DELETE from pessoa";
        String driver = "jdbc:postgresql://localhost:5432/DadosGerais";
        Statement st = null;
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "123")){
            if(conn != null){
                System.out.println("Connected to the Database!");
            }else{
                System.out.println("Failed to make connection!");
            }
            System.out.println("Excluindo dados da tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLexcluirDados);
            System.out.println("Dados Excluidos!");
            st.close();
            conn.close();
}catch(SQLException e){
    System.err.format("SQL State: %s\n%s" , e.getSQLState(), e.getMessage());
    
    }
  }
}


