package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class consultaDAO {

    private Connection myConnection;

    public consultaDAO() {
        myConnection = FabricaConexoes.getConnection();
    }

    public void AgendarConsulta(consulta c) throws SQLException {
        String insert = "insert into agendamento_consulta (data_consulta,hora_consulta,paciente_cpf,secretaria_cpf,medico_cpf1) values (?,?,?,?,?)";
        PreparedStatement stmt = myConnection.prepareStatement(insert);
        stmt.setString(1, c.getData_consulta());
        stmt.setString(2, c.getHora_consulta());
        stmt.setString(3, c.getPac().getCpf());
        stmt.setString(4, c.getSecretaria().getCpf());
        stmt.setString(5, c.getMedico().getCpf());

        try {
            stmt.execute();
            myConnection.close();
            JOptionPane.showMessageDialog(null, "Consulta Agendada");
        } catch (SQLException e) {
            myConnection.close();
            JOptionPane.showMessageDialog(null, "Erro ao agendar consulta");
            throw new SQLException(e);

        }
    }

    public ArrayList<consulta> buscaConsultasSecretariaFrame() {
        ArrayList<consulta> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from agendamento_consulta where flag_consulta_finalizada=? order by data_consulta desc, hora_consulta desc";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consulta aux = new consulta();
                aux.setData_consulta(rs.getString("data_consulta"));
                aux.setHora_consulta(rs.getString("hora_consulta"));
                String cpf = rs.getString("medico_cpf1");
                funcionarioDAO fd = new funcionarioDAO();
                funcionario medico, secretaria;
                medico = fd.buscaMedico(cpf);
                aux.setMedico(medico);
                String cpf_sec = rs.getString("secretaria_cpf");
                secretaria = fd.buscaSecretaria(cpf_sec);
                aux.setSecretaria(secretaria);
                String cpf_pac;
                cpf_pac = rs.getString("paciente_cpf");
                pacienteDAO pd = new pacienteDAO();
                paciente p = pd.buscaPaciente(cpf_pac);
                aux.setPac(p);

                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<consulta> buscaConsultaSecretariaFrame() {
        ArrayList<consulta> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from agendamento_consulta where data_consulta=? and hora_consulta=? and paciente_cpf=? and medico_cpf1=?"
                    + "and secretaria_cpf=? order by data_consulta desc, hora_consulta desc";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consulta aux = new consulta();
                aux.setData_consulta(rs.getString("data_consulta"));
                aux.setHora_consulta(rs.getString("hora_consulta"));
                String cpf = rs.getString("medico_cpf1");
                funcionarioDAO fd = new funcionarioDAO();
                funcionario medico, secretaria;
                medico = fd.buscaMedico(cpf);
                aux.setMedico(medico);
                String cpf_sec = rs.getString("secretaria_cpf");
                secretaria = fd.buscaSecretaria(cpf_sec);
                aux.setSecretaria(secretaria);
                String cpf_pac;
                cpf_pac = rs.getString("paciente_cpf");
                pacienteDAO pd = new pacienteDAO();
                paciente p = pd.buscaPaciente(cpf_pac);
                aux.setPac(p);

                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void atualizarConsultaFrameSecretaria(consulta n, consulta old) {

        String comandoSql = "UPDATE agendamento_consulta set data_consulta=?, hora_consulta=?, secretaria_cpf=?, medico_cpf1=?"
                + "where data_consulta=? and hora_consulta=? and paciente_cpf=? and secretaria_cpf=? and medico_cpf1=?";
        try {
            try (PreparedStatement stm = myConnection.prepareStatement(comandoSql)) {
                stm.setString(1, n.getData_consulta());
                stm.setString(2, n.getHora_consulta());
                stm.setString(3, n.getSecretaria().getCpf());
                stm.setString(4, n.getMedico().getCpf());
                stm.setString(5, old.getData_consulta());
                stm.setString(6, old.getHora_consulta());
                stm.setString(7, old.getPac().getCpf());
                stm.setString(8, old.getSecretaria().getCpf());
                stm.setString(9, old.getMedico().getCpf());
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
            }
            myConnection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
            throw new RuntimeException(e);

        }
    }

    public void atualizarConsultaFrameAtendeMedico(consulta n) {

        String comandoSql = "UPDATE agendamento_consulta set flag_consulta_finalizada=?,prescricao_medica=?,descricao_consulta=?"
                + "where data_consulta=? and hora_consulta=? and paciente_cpf=? and secretaria_cpf=? and medico_cpf1=?";
        try {
            try (PreparedStatement stm = myConnection.prepareStatement(comandoSql)) {
                stm.setInt(1, 1);
                stm.setString(2, n.getPrescricao_consulta());
                stm.setString(3, n.getDescricao_consulta());
                stm.setString(4, n.getData_consulta());
                stm.setString(5, n.getHora_consulta());
                stm.setString(6, n.getPac().getCpf());
                stm.setString(7, n.getSecretaria().getCpf());
                stm.setString(8, n.getMedico().getCpf());
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Atendimento efetuado com Sucesso");
            }
            myConnection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Finalizar Atendimento");
            throw new RuntimeException(e);

        }
    }

    public void atualizarConsultaFrameAtendeMedicoHistorico(consulta n) {//atualiza dados consulta finalizada
        String comandoSql = "UPDATE agendamento_consulta set prescricao_medica=?,descricao_consulta=?"
                + "where data_consulta=? and hora_consulta=? and paciente_cpf=? and secretaria_cpf=? and medico_cpf1=?";
        try {
            try (PreparedStatement stm = myConnection.prepareStatement(comandoSql)) {
                stm.setString(1, n.getPrescricao_consulta());
                stm.setString(2, n.getDescricao_consulta());
                stm.setString(3, n.getData_consulta());
                stm.setString(4, n.getHora_consulta());
                stm.setString(5, n.getPac().getCpf());
                stm.setString(6, n.getSecretaria().getCpf());
                stm.setString(7, n.getMedico().getCpf());
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!!");
            }
            myConnection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Finalizar Atendimento");
            throw new RuntimeException(e);

        }
    }

    public void removeAgendamentoConsulta(consulta c) {

        String comandoSql = "DELETE FROM agendamento_consulta WHERE data_consulta = ? and"
                + " hora_consulta=? and paciente_cpf=? and"
                + " secretaria_cpf=? and medico_cpf1=?";
        try {
            try (PreparedStatement stm = myConnection.prepareStatement(comandoSql)) {
                stm.setString(1, c.getData_consulta());
                stm.setString(2, c.getHora_consulta());
                stm.setString(3, c.getPac().getCpf());
                stm.setString(4, c.getSecretaria().getCpf());
                stm.setString(5, c.getMedico().getCpf());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Agendamento removido com Sucesso");
            }
            myConnection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
            throw new RuntimeException(e);
        }
    }

    public ArrayList<consulta> buscaConsultasMedicoFrame(String paciente_cpf) {//consulta para historico
        ArrayList<consulta> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from agendamento_consulta where flag_consulta_finalizada=? and paciente_cpf=? order by data_consulta desc, hora_consulta desc";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setInt(1, 1);
            stmt.setString(2, paciente_cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consulta aux = new consulta();
                aux.setData_consulta(rs.getString("data_consulta"));
                aux.setHora_consulta(rs.getString("hora_consulta"));
                String cpf = rs.getString("medico_cpf1");
                funcionarioDAO fd = new funcionarioDAO();
                funcionario medico, secretaria;
                medico = fd.buscaMedico(cpf);
                aux.setMedico(medico);
                aux.setPrescricao_consulta(rs.getString("prescricao_medica"));
                aux.setDescricao_consulta(rs.getString("descricao_consulta"));
                String cpf_sec = rs.getString("secretaria_cpf");
                secretaria = fd.buscaSecretaria(cpf_sec);
                aux.setSecretaria(secretaria);
                String cpf_pac;
                cpf_pac = rs.getString("paciente_cpf");
                pacienteDAO pd = new pacienteDAO();
                paciente p = pd.buscaPaciente(cpf_pac);
                aux.setPac(p);

                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<consulta> buscaConsultasMedicoFrameGeral(String medico_cpf) {//consulta para atendimento
        ArrayList<consulta> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from agendamento_consulta where flag_consulta_finalizada=? and medico_cpf1=? order by data_consulta desc, hora_consulta desc";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setInt(1, 0);
            stmt.setString(2, medico_cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consulta aux = new consulta();
                aux.setData_consulta(rs.getString("data_consulta"));
                aux.setHora_consulta(rs.getString("hora_consulta"));
                String cpf = rs.getString("medico_cpf1");
                funcionarioDAO fd = new funcionarioDAO();
                funcionario medico, secretaria;
                medico = fd.buscaMedico(cpf);
                aux.setMedico(medico);
                aux.setPrescricao_consulta(rs.getString("prescricao_medica"));
                aux.setDescricao_consulta(rs.getString("descricao_consulta"));
                String cpf_sec = rs.getString("secretaria_cpf");
                secretaria = fd.buscaSecretaria(cpf_sec);
                aux.setSecretaria(secretaria);
                String cpf_pac;
                cpf_pac = rs.getString("paciente_cpf");
                pacienteDAO pd = new pacienteDAO();
                paciente p = pd.buscaPaciente(cpf_pac);
                aux.setPac(p);

                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<consulta> buscaConsultasMedicoFrameGeralFinalizada(String medico_cpf) {//consulta para historico finalizada
        ArrayList<consulta> lista = new ArrayList<>();
        try {
            String sqlCom = "select * from agendamento_consulta where flag_consulta_finalizada=? and medico_cpf1=? order by data_consulta desc, hora_consulta desc";
            PreparedStatement stmt = myConnection.prepareStatement(sqlCom);
            stmt.setInt(1, 1);
            stmt.setString(2, medico_cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consulta aux = new consulta();
                aux.setData_consulta(rs.getString("data_consulta"));
                aux.setHora_consulta(rs.getString("hora_consulta"));
                String cpf = rs.getString("medico_cpf1");
                funcionarioDAO fd = new funcionarioDAO();
                funcionario medico, secretaria;
                medico = fd.buscaMedico(cpf);
                aux.setMedico(medico);
                aux.setPrescricao_consulta(rs.getString("prescricao_medica"));
                aux.setDescricao_consulta(rs.getString("descricao_consulta"));
                String cpf_sec = rs.getString("secretaria_cpf");
                secretaria = fd.buscaSecretaria(cpf_sec);
                aux.setSecretaria(secretaria);
                String cpf_pac;
                cpf_pac = rs.getString("paciente_cpf");
                pacienteDAO pd = new pacienteDAO();
                paciente p = pd.buscaPaciente(cpf_pac);
                aux.setPac(p);

                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("erro ao executar o comando sql na busca");
            throw new RuntimeException(e);
        }
        return lista;
    }
}