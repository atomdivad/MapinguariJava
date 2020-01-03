package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.consulta;
import model.consultaDAO;
import model.paciente;
import view.FrameHistoricoPaciente;
import view.FrameTabelaPacientesSessaoMedico;

public class controladorVisualizaPacienteSessaoMedico {

    private FrameTabelaPacientesSessaoMedico ftpc;

    public controladorVisualizaPacienteSessaoMedico() {
        ftpc = new FrameTabelaPacientesSessaoMedico(new TrataEvento());
    }

    public class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Histórico":
                    FrameHistoricoPaciente fhp = new FrameHistoricoPaciente();

                    ArrayList<paciente> pc;
                    paciente p;
                    pc = ftpc.pegaObj().pegaLista();
                    p = pc.get(ftpc.pegaObj().pegaSelecionado());
                    consultaDAO cd = new consultaDAO();
                    ArrayList<consulta> cl;
                    cl = cd.buscaConsultasMedicoFrame(p.getCpf());
                    fhp.setLabelNome(p.getNome());
                    for (int i = 0; i < cl.size(); i++) {
                        consulta c = cl.get(i);
                        SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;
                        String data_consulta = null;
                        try {
                            date = (Date) df.parse(c.getData_consulta());
                            data_consulta = br.format(date);
                        } catch (ParseException ex) {
                            Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        fhp.setHistorico("\t\tData da Consulta: " + data_consulta + " " + c.getHora_consulta());
                        fhp.setHistorico("\n\t[Descrição] " + c.getDescricao_consulta() + "\n");
                        fhp.setHistorico("\n\t[Prescrição] " + c.getPrescricao_consulta() + "\n");
                        if (i + 1 != cl.size()) {
                            fhp.setHistorico("\n\t-------------------------------------------------------------------------------------------------------------------------\n");
                        }
                    }
                    fhp.setVisible(true);
                    break;
            }
        }
    }
}
