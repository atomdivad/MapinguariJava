package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import model.funcionario;
import model.funcionarioDAO;

public class FrameUsuario extends JFrame {
    private javax.swing.JLabel labelCargo;
    private javax.swing.JLabel labelNomeCargo;
    private javax.swing.JLabel labelNomeUsuario;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    public FrameUsuario(funcionario s){
        labelTitulo = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelNomeUsuario = new javax.swing.JLabel();
        labelCargo = new javax.swing.JLabel();
        labelNomeCargo = new javax.swing.JLabel();
        
        labelTitulo.setText("Mapinguari System");
        
        labelUsuario.setText("Usuário:");
        
        labelNomeUsuario.setText(s.getNome());

        labelCargo.setText("Cargo:");
        funcionarioDAO fd = new funcionarioDAO();
        String desc=fd.buscaCargoDescricao(s.getCargo_nome());
        labelNomeCargo.setText(s.getCargo_nome()+"   Descrição: "+desc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsuario)
                            .addComponent(labelCargo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomeCargo)
                            .addComponent(labelNomeUsuario))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(labelNomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCargo)
                    .addComponent(labelNomeCargo))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
                        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  
    }
}
