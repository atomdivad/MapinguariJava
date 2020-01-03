package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class painelCadastroCliente extends JFrame{
        private JPanel painelCentral;
    private JLabel labelNome;
    private JLabel labelRa;
    private JLabel labelSenha;
    private JTextField textoSenha;
    private JTextField textoNome;
    private JTextField textoRA;
    private JButton botaoSalvar;
        public painelCadastroCliente(){
            
        labelNome = new JLabel("Nome: ");
        textoNome = new JTextField("");
        textoNome.setColumns(30);
        painelCentral = new JPanel();
        labelRa = new JLabel("RA: ");
        textoRA = new JTextField("");
        textoRA.setColumns(30);
        labelSenha = new JLabel("Senha: ");
        textoSenha = new JTextField("");
        textoSenha.setColumns(30);
        botaoSalvar = new JButton("Salvar");
        painelCentral.add(labelNome,BorderLayout.NORTH);
        painelCentral.add(textoNome);
        painelCentral.add(labelRa);
        painelCentral.add(textoRA);
        this.add(painelCentral,BorderLayout.CENTER);
        this.add(botaoSalvar,BorderLayout.SOUTH);
     
        this.setSize(420, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    public String getTextoRa(){
        return textoRA.getText();
    }
    public String getTextoNome(){
        return textoNome.getText();
    }
    public String getSenha(){
        return textoSenha.getText();
    }
}
