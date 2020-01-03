package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameTabelaPacientes extends JFrame {
    private painelTabelaClientes ptc;

    public FrameTabelaPacientes(ActionListener listener) {
                

        ptc = new painelTabelaClientes(listener);
        ptc.setOpaque(true); //content panes must be opaque
        this.setContentPane(ptc);
        this.setTitle("Pacientes Cadastrados");
        this.setSize(1050,300);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  
        this.setVisible(true);
        
    }
    public int pegaSelecionado(){
        return ptc.pegaSelecionado();
    }
    public painelTabelaClientes pegaObj(){
        return ptc;
    }
    
}
