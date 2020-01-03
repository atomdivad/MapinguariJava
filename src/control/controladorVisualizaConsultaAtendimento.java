package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.consulta;
import model.consultaDAO;
import model.funcionario;
import view.FrameVisualizaConsultaAtendimento;

public class controladorVisualizaConsultaAtendimento {

    private FrameVisualizaConsultaAtendimento fvec;
    private funcionario medico;
    private consulta old;
    private consultaDAO cd;

    public controladorVisualizaConsultaAtendimento(funcionario m) {
        this.medico = m;
        fvec = new FrameVisualizaConsultaAtendimento(new TrataEvento(), medico);
        cd = new consultaDAO();

    }

    public class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Atender":
                    controladorAtendeConsulta cac = new controladorAtendeConsulta(fvec.pegaObj());
                    fvec.setVisible(false);
                    break;
            }
        }
    }
}
