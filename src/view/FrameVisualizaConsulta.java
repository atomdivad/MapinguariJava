package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FrameVisualizaConsulta extends JFrame {

    private painelTabelaConsultas ptc;

    public FrameVisualizaConsulta(ActionListener listener) {
        ptc = new painelTabelaConsultas(listener);
        ptc.setOpaque(true); //content panes must be opaque
        this.setContentPane(ptc);
        this.setTitle("Consultas Agendadas");
        this.setSize(1050, 300);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - this.getSize().width) / 2,
                (tela.height - this.getSize().height) / 2);
        this.setVisible(true);
    }

    public int pegaSelecionado() {
        return ptc.pegaSelecionado();
    }

    public painelTabelaConsultas pegaObj() {
        return ptc;
    }
}
