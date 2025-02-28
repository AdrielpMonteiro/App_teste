import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        
        Connection conexao = ConexaoBD.conectar();
        if (conexao != null) {
            System.out.println(" Conexão bem-sucedida com o banco de dados!\n");
        } else {
            System.out.println(" Falha na conexão com o banco de dados.");
            return; 
        }

        
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();

        
        System.out.print("Digite seu nome: ");
        usuario.nome = scanner.nextLine();

        System.out.print("Digite seu email: ");
        usuario.email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        usuario.senha = scanner.nextLine();

        System.out.print("Digite a sua data de nascimento : ");
        usuario.dataNascimento = scanner.nextLine();

        
        System.out.println(" Cadastro Realizado com Sucesso!");
        System.out.println("Nome: " + usuario.nome);
        System.out.println("Email: " + usuario.email);
        System.out.println("Data de Nascimento: " + usuario.dataNascimento);

       
        String sql = "INSERT INTO usuarios (nome, email, senha, data_nascimento) VALUES (?, ?, ?, ?)";

        


        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.nome);
            stmt.setString(2, usuario.email);
            stmt.setString(3, usuario.senha);
            stmt.setString(4, usuario.dataNascimento);



            stmt.executeUpdate();
            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas>0){
                System.out.println("dados salvos");

            }else {
                System.out.println("NENHUM DADO INSERIDO");
            }

            System.out.println("dados salvos com sucesso!");
            
        } catch (SQLException e) {
            System.out.println(" Erro ao salvar DB " + e.getMessage());
        }

        
        scanner.close();

       
        try {
            conexao.close();
            System.out.println(" erro ao fechar conexao");
        } catch (SQLException e) {
            System.out.println(" Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
