/*
Antonio Francisco Lacerda Pereira 10436919
Henrique Totti Ulbricht Lapa 10436584
*/
package dev.toni;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements GerenciadorNomes {
    private Connection connection;

    public GerenciadorNomesBD() {
        String ipv4 = "192.168.1.100"; 
        String url = "jdbc:postgresql://" + ipv4 + ":5432/nomesdb";
        String user = "seu_usuario";
        String password = "sua_senha";

        try {
            System.out.println("Tentando conectar ao banco de dados...");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            criarTabelaSeNaoExistir();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void criarTabelaSeNaoExistir() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS nomes (id SERIAL PRIMARY KEY, nome VARCHAR(255))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'nomes' verificada/criada com sucesso!");
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM nomes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter nomes: " + e.getMessage());
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        String sql = "INSERT INTO nomes (nome) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
            System.out.println("Nome adicionado com sucesso: " + nome);
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar nome: " + e.getMessage());
            e.printStackTrace();
        }
    }
}