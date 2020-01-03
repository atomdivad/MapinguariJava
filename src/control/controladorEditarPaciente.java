package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.paciente;
import model.pacienteDAO;
import view.FrameEditarPaciente;
import view.FrameTabelaPacientes;

public class controladorEditarPaciente {

    private FrameEditarPaciente fep;
    private paciente aux;
    private pacienteDAO data;
    private String cpf;
    private int atualizou = 0;

    public controladorEditarPaciente(String cpf) throws SQLException {
        fep = new FrameEditarPaciente(new TrataEvento());
        this.cpf = cpf;
        data = new pacienteDAO();
        aux = data.buscaPaciente(this.cpf);
        fep.setcTextoCpf(aux.getCpf());
        fep.setcTextoRg(aux.getRg());
        fep.setcTextoNome(aux.getNome());
        SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String data_consulta = null;
        try {
            date = (Date) df.parse(aux.getData_nascimento());
            data_consulta = br.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        fep.setcTextoDataNascimento(data_consulta);
        fep.setcTextoUf(aux.getUf());
        fep.setcTextoCidade(aux.getCidade());
        fep.setcTextoRua(aux.getRua());
        fep.setcTextoAp(aux.getAp());
        fep.setcTextoLote(aux.getLote());
        fep.setcTextoTelefone(aux.getTelefone());
    }

    public class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Enviar":
                    aux.setCpf(fep.getcTextoCpf());
                    aux.setRg(Integer.parseInt(fep.getcTextoRg()));
                    aux.setNome(fep.getcTextoNome());
                    SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    String data_consulta = null;
                    try {
                        date = (Date) br.parse(fep.getcTextoDataNascimento());
                        data_consulta = df.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    aux.setData_nascimento(data_consulta);
                    aux.setUf(fep.getcTextoUf());
                    aux.setCidade(fep.getcTextoCidade());
                    aux.setRua(fep.getcTextoRua());
                    aux.setAp(fep.getcTextoAp());
                    aux.setLote(fep.getcTextoLote());
                    aux.setTelefone(fep.getcTextoTelefone());
                    data.atualizarPaciente(aux, cpf);
                    fep.setVisible(false);
                    atualizou = 1;
                    break;
            }
        }
    }

    public int getAtualizou() {
        return this.atualizou;
    }
}
