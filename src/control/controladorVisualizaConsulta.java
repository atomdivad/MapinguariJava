package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.consulta;
import model.consultaDAO;
import model.funcionario;
import view.FrameVisualizaConsulta;

public class controladorVisualizaConsulta {

    private FrameVisualizaConsulta fvec;
    private funcionario sec;
    private consulta old;
    private consultaDAO cd;

    public controladorVisualizaConsulta(funcionario s) {
        fvec = new FrameVisualizaConsulta(new TrataEvento());
        cd = new consultaDAO();
        this.sec = s;
    }

    public class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Editar":
                    controladorEditarConsulta cep = new controladorEditarConsulta(fvec.pegaObj(), sec);
                    break;
                case "Excluir":
                    ArrayList<consulta> con = fvec.pegaObj().pegaLista();
                    old = con.get(fvec.pegaObj().getRow());
                    cd.removeAgendamentoConsulta(old);
                    break;
            }
        }
    }
}
