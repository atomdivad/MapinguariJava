package view;

import br.com.calendario.util.TextDataChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class FrameCadastroPaciente extends JFrame {
    private final TextDataChooser TextDataChooser;
    private JButton buttonEnviar;
    private JButton buttonLimpar;
    private JTextField cTextoAp;
    private JTextField cTextoCidade;
    private JTextField cTextoCpf;
    private JTextField cTextoDataNascimento;
    private JTextField cTextoLote;
    private JTextField cTextoNome;
    private JTextField cTextoRg;
    private JTextField cTextoRua;
    private JTextField cTextoTelefone;
    private JTextField cTextoUf;
    private JLabel labelAp;
    private JLabel labelCidade;
    private JLabel labelCpf;
    private JLabel labelDataNascimento;
    private JLabel labelLote;
    private JLabel labelNome;
    private JLabel labelRg;
    private JLabel labelRua;
    private JLabel labelTelefone;
    private JLabel labelTitulo;
    private JLabel labeluf;

    public FrameCadastroPaciente(ActionListener listener) {
                TextDataChooser = new TextDataChooser();
        labelTitulo = new JLabel();
        labelNome = new JLabel();
        cTextoNome = new JTextField();
        labelCpf = new JLabel();
        cTextoCpf = new JTextField();
        labelRg = new JLabel();
        cTextoRg = new JTextField();
        labelTelefone = new JLabel();
        cTextoTelefone = new JTextField();
        labelDataNascimento = new JLabel();
        cTextoDataNascimento = new JTextField();
        labeluf = new JLabel();
        cTextoUf = new JTextField();
        labelCidade = new JLabel();
        cTextoCidade = new JTextField();
        labelRua = new JLabel();
        cTextoRua = new JTextField();
        labelAp = new JLabel();
        cTextoAp = new JTextField();
        labelLote = new JLabel();
        cTextoLote = new JTextField();
        buttonEnviar = new JButton();
        buttonLimpar = new JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Inserção de Clientes");
        labelTitulo.setText("Cadastro de Clientes");

        labelNome.setText("Nome: ");

        labelCpf.setText("CPF: ");

        labelRg.setText("RG:");

        labelTelefone.setText("Telefone:");

        labelDataNascimento.setText("Data Nascimento:");

        labeluf.setText("UF:");

        labelCidade.setText("Cidade:");

        labelRua.setText("Rua:");

        labelAp.setText("AP:");

        labelLote.setText("Lote:");

        buttonEnviar.setText("Enviar");

        buttonLimpar.setText("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelLote)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cTextoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelRua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cTextoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buttonEnviar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonLimpar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelAp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cTextoAp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTitulo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelCpf)
                                        .addGap(6, 6, 6)
                                        .addComponent(cTextoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelRg)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cTextoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cTextoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextDataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cTextoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labeluf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cTextoUf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(cTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCpf)
                    .addComponent(labelRg)
                    .addComponent(labelTelefone)
                    .addComponent(cTextoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataNascimento)
                    .addComponent(TextDataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade)
                    .addComponent(cTextoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeluf)
                    .addComponent(cTextoUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLote)
                    .addComponent(cTextoLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRua)
                    .addComponent(cTextoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAp)
                    .addComponent(cTextoAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEnviar)
                    .addComponent(buttonLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
//        cTextoNome.addActionListener(listener);
//        cTextoCpf.addActionListener(listener);
//        cTextoRg.addActionListener(listener);
//        cTextoTelefone.addActionListener(listener);
//        cTextoDataNascimento.addActionListener(listener);
//        cTextoUf.addActionListener(listener);
//        cTextoCidade.addActionListener(listener);
//        cTextoRua.addActionListener(listener);
//        cTextoAp.addActionListener(listener);
//        cTextoLote.addActionListener(listener);
        buttonEnviar.addActionListener(listener);
        buttonLimpar.addActionListener(listener);
//        this.setVisible(true);                                
        pack();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  
    }
    public String getcTextoAp() {
        return cTextoAp.getText();
    }

    public String getcTextoCidade() {
        return cTextoCidade.getText();
    }

    public String getcTextoCpf() {
        return cTextoCpf.getText();
    }

    public String getcTextoDataNascimento() {
        return TextDataChooser.getText();
    }

    public String getcTextoLote() {
        return cTextoLote.getText();
    }

    public String getcTextoNome() {
        return cTextoNome.getText();
    }

    public String getcTextoRg() {
        return cTextoRg.getText();
    }

    public String getcTextoRua() {
        return cTextoRua.getText();
    }

    public String getcTextoTelefone() {
        return cTextoTelefone.getText();
    }

    public String getcTextoUf() {
        return cTextoUf.getText();
    }
    
    public void setcTextoAp(String cTextoAp) {
        this.cTextoAp.setText(cTextoAp);
    }

    public void setcTextoCidade(String cTextoCidade) {
        this.cTextoCidade.setText(cTextoCidade);
    }

    public void setcTextoCpf(String cTextoCpf) {
        this.cTextoCpf.setText(cTextoCpf);
    }

    public void setcTextoDataNascimento(String cTextoDataNascimento) {
        this.cTextoDataNascimento.setText(cTextoDataNascimento);
    }

    public void setcTextoLote(String cTextoLote) {
        this.cTextoLote.setText(cTextoLote);
    }

    public void setcTextoNome(String cTextoNome) {
        this.cTextoNome.setText(cTextoNome);
    }

    public void setcTextoRg(String cTextoRg) {
        this.cTextoRg.setText(cTextoRg);
    }

    public void setcTextoRua(String cTextoRua) {
        this.cTextoRua.setText(cTextoRua);
    }

    public void setcTextoTelefone(String cTextoTelefone) {
        this.cTextoTelefone.setText(cTextoTelefone);
    }

    public void setcTextoUf(String cTextoUf) {
        this.cTextoUf.setText(cTextoUf);
    }
}
