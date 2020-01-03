package view;

import br.com.calendario.util.TextDataChooser;
import com.mysql.jdbc.EscapeTokenizer;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.funcionario;
import model.funcionarioDAO;
import model.paciente;
import model.pacienteDAO;
import sun.util.BuddhistCalendar;

public class FrameAgendaConsulta extends JFrame{
    private final TextDataChooser TextDataChooser;
    private javax.swing.JButton botaoAgendar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoPesquisarCpf;
    private javax.swing.JTextField cTextoCpf;
    private javax.swing.JTextField cTextoHora;
    private javax.swing.JComboBox comboBoxMedico;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelMedico;
    private funcionario func;
    private paciente pc;
    private ArrayList<funcionario> fl;
    private pacienteDAO pd = new pacienteDAO();
      private funcionarioDAO fd = new funcionarioDAO();
    public FrameAgendaConsulta(ActionListener listener) {
        TextDataChooser = new TextDataChooser();
        comboBoxMedico = new JComboBox();
        labelCpf = new javax.swing.JLabel();
        labelMedico = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        cTextoHora = new javax.swing.JTextField();
        cTextoCpf = new javax.swing.JTextField();
        botaoPesquisarCpf = new javax.swing.JButton();
        labelData = new javax.swing.JLabel();
        botaoAgendar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fl = fd.buscaMedicos();
       int tam = fl.size();
        String[] lista = new String[tam];
        for(int i=0;i<tam;i++){
            funcionario e=fl.get(i);
            lista[i]=e.getNome();
        }
        comboBoxMedico.setModel(new javax.swing.DefaultComboBoxModel(lista));
        
        labelCpf.setText("Paciente CPF: ");

        labelMedico.setText("Médico:");

        labelHora.setText("Hora:");

        botaoPesquisarCpf.setText("Pesquisar");

        labelData.setText("Data:");

        botaoAgendar.setText("Agendar");

        botaoLimpar.setText("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelCpf)
                        .addGap(4, 4, 4)
                        .addComponent(cTextoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(botaoAgendar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(labelHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cTextoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(labelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextDataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCpf)
                    .addComponent(labelMedico)
                    .addComponent(comboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHora)
                    .addComponent(cTextoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelData)
                    .addComponent(TextDataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAgendar)
                    .addComponent(botaoLimpar))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        botaoAgendar.addActionListener(listener);
        botaoPesquisarCpf.addActionListener(listener);
        pack();
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  
    }

    public String getTextDataChooser() {
        return TextDataChooser.getText();
    }

    public String getcTextoCpf() {
        return cTextoCpf.toString();
    }
    public paciente getPaciente(){
        return pc;
    }
    public String getcTextoHora() {
        return cTextoHora.getText();
    }

    public funcionario getComboBoxMedico() {
        func=fl.get(comboBoxMedico.getSelectedIndex());
        return func;
    }

    public void setcTextoCpf(String cTextoCpf) {
        this.cTextoCpf.setText(cTextoCpf);
    }
    public void setCpfPaciente(String cpf){
        pc = pd.buscaPaciente(cpf);
    }
}
