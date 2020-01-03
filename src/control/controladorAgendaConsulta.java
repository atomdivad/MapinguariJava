package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.consulta;
import model.consultaDAO;
import model.funcionario;
import model.paciente;
import view.FrameAgendaConsulta;
import view.FramePacienteSeleciona;

public class controladorAgendaConsulta {

    private FrameAgendaConsulta fac;
    private FramePacienteSeleciona fps;
    private funcionario secretaria;
    private String data_consulta;
    public controladorAgendaConsulta(funcionario s) {
        this.secretaria = s;
        fac = new FrameAgendaConsulta(new TrataEvento());
        fac.setVisible(true);
        fps = new FramePacienteSeleciona(new TrataEvento());
        fps.setVisible(false);
    }

    public class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Selecionar":
                    fac.setcTextoCpf((String) fps.pegaObj().getTableDados().getValueAt(fps.pegaSelecionado(), 0));
                    fac.setCpfPaciente((String) fps.pegaObj().getTableDados().getValueAt(fps.pegaSelecionado(), 1));
                    fps.setVisible(false);
                    break;
                case "Agendar":
                    SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;

                    try {
                        date = (Date) br.parse(fac.getTextDataChooser());
                        data_consulta = df.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    funcionario medico = fac.getComboBoxMedico();
                    paciente pc = fac.getPaciente();
                    consulta c = new consulta(medico, secretaria, pc, null, null, 0, fac.getcTextoHora(), data_consulta);
                    consultaDAO cd = new consultaDAO();
                    try {
                        cd.AgendarConsulta(c);
                        fac.setVisible(false);
                        fps.setVisible(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Pesquisar":
        
                    fps.setVisible(true);
                    // fps.pegaObj().getTableDados().getValueAt(fps.pegaSelecionado(), column);

                    break;
            }
        }
    }
}
