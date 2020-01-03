package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.funcionario;
import view.FrameMedico;
import view.FrameSecretaria;
import view.FrameTabelaPacientes;
import view.FrameUsuario;
import view.painelCadastroCliente;
import view.painelTabelaClientes;

public class controladorFrameMedico {
    private FrameMedico fm;
    private funcionario medico;
    public controladorFrameMedico(funcionario m) {
        fm = new FrameMedico(new TrataEvento());
        fm.setVisible(true);
        this.medico = m;
    }
    public class TrataEvento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando=e.getActionCommand();
            switch (comando) {
                case "Atender Consulta": 
                    controladorVisualizaConsultaAtendimento cvca = new controladorVisualizaConsultaAtendimento(medico);
                    break;
                case "Visualizar Histórico de Consultas":
                    controladorHistoricoConsulta chc = new controladorHistoricoConsulta(medico);
                    break;
                case "Visualizar Pacientes":
                    controladorVisualizaPacienteSessaoMedico cvpsm = new controladorVisualizaPacienteSessaoMedico();
                    break;
                case "Usuário do Sistema":
                    FrameUsuario fu = new FrameUsuario(medico);
                    fu.setVisible(true);
                    break;
            }
        }
        
    }
}
