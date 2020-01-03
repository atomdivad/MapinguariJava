package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class FrameHistoricoPaciente extends JFrame{
        private javax.swing.JTextArea areaTextoHistorico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTitulo;

    public FrameHistoricoPaciente() {
                jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoHistorico = new javax.swing.JTextArea();
        labelTitulo = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        areaTextoHistorico.setColumns(20);
        areaTextoHistorico.setRows(5);
        areaTextoHistorico.setEditable(false);
        areaTextoHistorico.setLineWrap(true);

        jScrollPane1.setViewportView(areaTextoHistorico);

        labelTitulo.setText("Histórico do Paciente:");

        labelNome.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNome)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitulo)
                    .addComponent(labelNome))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
                        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  
    }
    public void setLabelNome(String n){
        this.labelNome.setText(n);
    }
    public void setHistorico(String n){
        this.areaTextoHistorico.append(n);
    }
}
