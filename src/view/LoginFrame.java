package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class LoginFrame extends JFrame{

    private JButton jButtonEntrar;
    private JButton jButtonLimpar;
    private JLabel jLabel1;
    private JLabel jLabelSenha;
    private JLabel jLabelUsuario;
    private JPanel jPanelLogin;
    private JPasswordField jTextFieldSenha;
    private JTextField jTextFieldUsuario;

    public LoginFrame(ActionListener tratadorEvento) {
        jPanelLogin = new javax.swing.JPanel();
        jLabelSenha = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new JTextField();
        jTextFieldSenha = new JPasswordField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();



        jPanelLogin.setBackground(new Color(255, 255, 255));

        jLabelSenha.setText("Senha: ");

        jLabelUsuario.setText("CPF: ");



        jButtonLimpar.setText("Limpar");


        jButtonEntrar.setText("Entrar");

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/view/mapinguari240x150.gif"))); // NOI18N

        GroupLayout jPanelLoginLayout = new GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
                jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelSenha)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSenha, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelUsuario)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
                .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButtonEntrar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLimpar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanelLoginLayout.setVerticalGroup(
                jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelUsuario))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jLabelSenha)
                .addComponent(jTextFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonLimpar)
                .addComponent(jButtonEntrar))
                .addGap(22, 22, 22)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanelLogin, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE));

        jPanelLogin.getAccessibleContext().setAccessibleName("");
        jButtonEntrar.addActionListener(tratadorEvento);
        jButtonLimpar.addActionListener(tratadorEvento);
        jTextFieldUsuario.addActionListener(tratadorEvento);
        jTextFieldSenha.addActionListener(tratadorEvento);

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Mapinguari Clínica");
        this.setVisible(true);
        pack();
                        this.setLocationRelativeTo(null);
    }

    public String getSenha() {
        return jTextFieldSenha.getText();
    }

    public String getUsuario() {
        return jTextFieldUsuario.getText();
    }

    public void setjTextFieldSenha(String jTextFieldSenha) {
        this.jTextFieldSenha.setText(jTextFieldSenha);
    }

    public void setjTextFieldUsuario(String jTextFieldUsuario) {
        this.jTextFieldUsuario.setText(jTextFieldUsuario);
    }
}
