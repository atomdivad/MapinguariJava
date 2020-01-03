package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.funcionario;

public class FrameHistoricoConsulta extends JFrame {

    private painelHistoricoConsultas phc;

    public FrameHistoricoConsulta(ActionListener listener, funcionario m) {
        phc = new painelHistoricoConsultas(listener, m);
        phc.setOpaque(true); //content panes must be opaque
        this.setContentPane(phc);
        this.setTitle("Histórico de Consultas Atendidas Por: "+m.getNome());
        this.setSize(1050, 300);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - this.getSize().width) / 2,
                (tela.height - this.getSize().height) / 2);
//        this.setVisible(true);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);//reeeeeeeeeeetiiiiiiiii
    }
    public int pegaSelecionado() {
        return phc.pegaSelecionado();
    }

    public painelHistoricoConsultas pegaObj() {
        return phc;
    }
}
