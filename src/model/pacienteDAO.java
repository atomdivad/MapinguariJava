package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class pacienteDAO {

    private Connection myConnection;
    private String cpf;

    public pacienteDAO() {
        myConnection = FabricaConexoes.getConnection();
    }

    public ArrayList<paciente> buscaPacientes() {
        ArrayList<paciente> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from paciente order by nome desc";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                paciente aux = new paciente();
                aux.setCpf(rs.getString("cpf"));
                aux.setRg(rs.getInt("rg"));
                aux.setNome(rs.getString("nome"));
                aux.setData_nascimento(rs.getString("data_nascimento"));
                aux.setUf(rs.getString("uf"));
                aux.setCidade(rs.getString("cidade"));
                aux.setRua(rs.getString("rua"));
                aux.setAp(rs.getString("ap"));
                aux.setLote(rs.getString("lote"));
                aux.setNumero_consultas_realizadas(rs.getInt("numero_consultas_realizadas"));
                aux.setTelefone(rs.getString("telefone"));
                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public paciente buscaPaciente(String cpf) {
        this.cpf = cpf;
        paciente aux = new paciente();
        try {
            String sqlCom = "select * from paciente where cpf=?";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setString(1,this.cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                aux.setCpf(rs.getString("cpf"));
                aux.setRg(rs.getInt("rg"));
                aux.setNome(rs.getString("nome"));
                aux.setData_nascimento(rs.getString("data_nascimento"));
                aux.setUf(rs.getString("uf"));
                aux.setCidade(rs.getString("cidade"));
                aux.setRua(rs.getString("rua"));
                aux.setAp(rs.getString("ap"));
                aux.setLote(rs.getString("lote"));
                aux.setNumero_consultas_realizadas(rs.getInt("numero_consultas_realizadas"));
                aux.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return aux;
    }

    public boolean cadastrarPaciente(paciente p) throws SQLException {
        String insert = "insert into paciente values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = myConnection.prepareStatement(insert);
        stmt.setString(1, p.getCpf());
        stmt.setInt(2, p.getRg());
        stmt.setString(3, p.getNome());
        stmt.setString(4, p.getData_nascimento());
        stmt.setString(5, p.getUf());
        stmt.setString(6, p.getCidade());
        stmt.setString(7, p.getRua());
        stmt.setString(8, p.getAp());
        stmt.setString(9, p.getLote());
        stmt.setInt(10, p.getNumero_consultas_realizadas());
        stmt.setString(11, p.getTelefone());
        try {
            stmt.execute();
            myConnection.close();
            return true;
        } catch (SQLException e) {
            myConnection.close();
            throw new SQLException(e);
        }
    }
public void atualizarPaciente(paciente d,String cpfOld) {
        int resultado = 0;
        String comandoSql = "UPDATE paciente SET cpf=?,rg=?,nome=?,data_nascimento=?,uf=?,cidade=?,rua=?,ap=?,lote=?,telefone=? WHERE cpf=?";
        try {
            try (PreparedStatement stm = myConnection.prepareStatement(comandoSql)) {
                stm.setString(1, d.getCpf());
                stm.setInt(2, d.getRg());
                stm.setString(3, d.getNome());
                stm.setString(4, d.getData_nascimento());
                stm.setString(5, d.getUf());
                stm.setString(6, d.getCidade());
                stm.setString(7, d.getRua());
                stm.setString(8, d.getAp());
                stm.setString(9, d.getLote());
                stm.setString(10, d.getTelefone());
                stm.setString(11, cpfOld);
                
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null,"Alterado com Sucesso");
            }
            myConnection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar");
            throw new RuntimeException(e);

        }
    }

}
