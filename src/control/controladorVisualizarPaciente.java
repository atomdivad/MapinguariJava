package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.pacienteDAO;
import view.FrameEditarPaciente;
import view.FrameTabelaPacientes;

public class controladorVisualizarPaciente {
    private FrameTabelaPacientes ftc;
    private int atualizou=0;
    public controladorVisualizarPaciente() {
                ftc = new FrameTabelaPacientes(new TrataEvento());
    }
        public class TrataEvento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch(comando){
                case "Editar":
//                    System.out.println(ftc.pegaSelecionado());
//                    System.out.println(ftc.pegaObj().getTableDados().getValueAt(ftc.pegaSelecionado(), 1));
            try {
                controladorEditarPaciente cep = new controladorEditarPaciente((String)(ftc.pegaObj().getTableDados().getValueAt(ftc.pegaSelecionado(), 1)));
            } catch (SQLException ex) {
                Logger.getLogger(controladorVisualizarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
                    //cep.setCpf((String)(ftc.pegaObj().getTableDados().getValueAt(ftc.pegaSelecionado(), 1)));
                    break;
            }
        }
    }
}
