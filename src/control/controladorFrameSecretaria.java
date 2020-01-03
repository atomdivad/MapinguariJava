package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.funcionario;
import view.FrameSecretaria;
import view.FrameTabelaPacientes;
import view.FrameUsuario;
import view.painelCadastroCliente;
import view.painelTabelaClientes;

public class controladorFrameSecretaria {
    private FrameSecretaria fs;
    private funcionario secretaria;
    public controladorFrameSecretaria(funcionario secretaria) {
        fs = new FrameSecretaria(new TrataEvento());
        fs.setVisible(true);
        this.secretaria = secretaria;
    }
    public class TrataEvento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando=e.getActionCommand();
            switch (comando) {
                case "Agendar Consulta":   
                    controladorAgendaConsulta cac = new controladorAgendaConsulta(secretaria);
                    break;
                case "Visualizar ou Modificar Consultas Pendentes":
                    controladorVisualizaConsulta c = new controladorVisualizaConsulta(secretaria);
                    break;
                case "Inserir":
                    controladorCadastroPaciente ccp = new controladorCadastroPaciente();
                    break;
                case "Visualizar Pacientes":
                    controladorVisualizarPaciente ftc =  new controladorVisualizarPaciente();
                    break;
                case "Usuário do Sistema":
                    FrameUsuario fu = new FrameUsuario(secretaria);
                    fu.setVisible(true);
                    break;
            }
        }
        
    }
}
