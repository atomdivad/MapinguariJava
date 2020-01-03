package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePacienteSeleciona extends JFrame {
    private painelTabelaPacienteSeleciona ptc;

    public FramePacienteSeleciona(ActionListener listener) {
                

        ptc = new painelTabelaPacienteSeleciona(listener);
        ptc.setOpaque(true); //content panes must be opaque
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(ptc);
        this.setTitle("Pacientes Cadastrados");
        this.setSize(1050,300);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  

        
    }
    public int pegaSelecionado(){
        return ptc.pegaSelecionado();
    }
    public painelTabelaPacienteSeleciona pegaObj(){
        return ptc;
    }
    
}