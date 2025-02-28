import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    // URL do banco de dados (ajuste com seu banco, usuário e senha)
    private static final String URL = "jdbc:mysql://localhost:3306/app_teste";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection conectar() {
        try {
            // Tenta estabelecer a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
