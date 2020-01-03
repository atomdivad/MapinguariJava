package view;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.funcionario;
import view.painelTabelaConsultas;

public class FrameVisualizaConsultaAtendimento extends JFrame {

    private painelTabelaConsultasAtendimento ptc;

    public FrameVisualizaConsultaAtendimento(ActionListener listener,funcionario m) {
        ptc = new painelTabelaConsultasAtendimento(listener,m);
        ptc.setOpaque(true); //content panes must be opaque
        this.setContentPane(ptc);
        this.setTitle("Consultas Agendadas");
        this.setSize(1050, 300);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - this.getSize().width) / 2,
                (tela.height - this.getSize().height) / 2);
        this.setVisible(true);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);//reeeeeeeeeeetiiiiiiiiiiiiiraaaaaaaarrrrrrrr apos testes

    }

    public int pegaSelecionado() {
        return ptc.pegaSelecionado();
    }

    public painelTabelaConsultasAtendimento pegaObj() {
        return ptc;
    }
}
