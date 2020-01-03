package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class funcionarioDAO {

    private Connection myConnection;
    private String cpf;

    public funcionarioDAO() {
        myConnection = FabricaConexoes.getConnection();
    }

    public ArrayList<funcionario> buscaMedicos() {
        ArrayList<funcionario> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from funcionario where cargo_nome=? and flag_ativo=?";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setString(1, "Médico");
            stmt.setInt(2, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario aux = new funcionario();
                aux.setCpf(rs.getString("cpf"));
                aux.setNome(rs.getString("nome"));
                aux.setData_nascimento(rs.getString("data_nascimento"));
                aux.setTelefone(rs.getString("telefone"));
                aux.setFlag_ativo(rs.getInt("flag_ativo"));
                aux.setUf(rs.getString("uf"));
                aux.setCidade(rs.getString("cidade"));
                aux.setRua(rs.getString("rua"));
                aux.setAp(rs.getString("ap"));
                aux.setLote(rs.getString("lote"));
                aux.setCargo_nome(rs.getString("cargo_nome"));
                aux.setSenha(rs.getString("senha"));
                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }
    
    public funcionario buscaSecretaria(String cpf) {
        this.cpf = cpf;
        funcionario aux = new funcionario();
        try {
            String sqlCom = "select * from funcionario where cpf=? and cargo_nome=?";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setString(1, this.cpf);
            stmt.setString(2, "Secretária");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                aux.setCpf(rs.getString("cpf"));
                aux.setNome(rs.getString("nome"));
                aux.setData_nascimento(rs.getString("data_nascimento"));
                aux.setFlag_ativo(rs.getInt("flag_ativo"));
                aux.setUf(rs.getString("uf"));
                aux.setCidade(rs.getString("cidade"));
                aux.setRua(rs.getString("rua"));
                aux.setAp(rs.getString("ap"));
                aux.setLote(rs.getString("lote"));
                aux.setTelefone(rs.getString("telefone"));
                aux.setCargo_nome(rs.getString("cargo_nome"));
                aux.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return aux;
    }

    public funcionario buscaMedico(String cpf) {
        this.cpf = cpf;
        funcionario aux = new funcionario();
        try {
            String sqlCom = "select * from funcionario where cpf=? and cargo_nome=?";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setString(1, this.cpf);
            stmt.setString(2, "Médico");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                aux.setCpf(rs.getString("cpf"));
                aux.setNome(rs.getString("nome"));
                aux.setData_nascimento(rs.getString("data_nascimento"));
                aux.setFlag_ativo(rs.getInt("flag_ativo"));
                aux.setUf(rs.getString("uf"));
                aux.setCidade(rs.getString("cidade"));
                aux.setRua(rs.getString("rua"));
                aux.setAp(rs.getString("ap"));
                aux.setLote(rs.getString("lote"));
                aux.setTelefone(rs.getString("telefone"));
                aux.setCargo_nome(rs.getString("cargo_nome"));
                aux.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return aux;
    }

    public funcionario buscaFuncionario(String cpf) {
        this.cpf = cpf;
        funcionario aux = new funcionario();
        try {
            String sqlCom = "select * from funcionario where cpf=?";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setString(1, this.cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                aux.setCpf(rs.getString("cpf"));
                aux.setNome(rs.getString("nome"));
                aux.setData_nascimento(rs.getString("data_nascimento"));
                aux.setFlag_ativo(rs.getInt("flag_ativo"));
                aux.setUf(rs.getString("uf"));
                aux.setCidade(rs.getString("cidade"));
                aux.setRua(rs.getString("rua"));
                aux.setAp(rs.getString("ap"));
                aux.setLote(rs.getString("lote"));
                aux.setTelefone(rs.getString("telefone"));
                aux.setCargo_nome(rs.getString("cargo_nome"));
                aux.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return aux;
    }
        public String buscaCargoDescricao(String n) {
        String desc=null;
        try {
            String sqlCom = "select descricao from cargo where nome=?";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setString(1, n);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                desc=rs.getString("descricao");
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return desc;
    }
}
