package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameSecretaria extends JFrame {

    private JMenuItem infoFuncionario;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenu menuConsultas;
    private JMenu menuInfo;
    private JMenuItem menuItemAgendarConsulta;
    private JMenuItem menuItemInserirPacientes;
    private JMenuItem menuItemVisualizarEditarPacientes;
    private JMenuItem menuItemVisualizarModificarConsultas;
    private JMenu menuPacientes;
    private painelFundo painelFundo1;
    private GroupLayout tabela;

    public FrameSecretaria(ActionListener listener) {


        jMenuItem1 = new javax.swing.JMenuItem();
        painelFundo1 = new view.painelFundo("/home/david/NetBeansProjects/Mapinguari/src/view/url.jpeg");
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConsultas = new javax.swing.JMenu();
        menuItemAgendarConsulta = new javax.swing.JMenuItem();
        menuItemVisualizarModificarConsultas = new javax.swing.JMenuItem();

        menuPacientes = new javax.swing.JMenu();
        menuItemInserirPacientes = new javax.swing.JMenuItem();
        menuItemVisualizarEditarPacientes = new javax.swing.JMenuItem();
        menuInfo = new javax.swing.JMenu();
        infoFuncionario = new javax.swing.JMenuItem();



        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout painelFundo1Layout = new javax.swing.GroupLayout(painelFundo1);
        painelFundo1.setLayout(painelFundo1Layout);
        painelFundo1Layout.setHorizontalGroup(
                painelFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 750, Short.MAX_VALUE));
        painelFundo1Layout.setVerticalGroup(
                painelFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 500, Short.MAX_VALUE));
        this.setResizable(false);
        this.setTitle("Mapinguari Clínica Médica");
        menuConsultas.setText("Consultas");

        menuItemAgendarConsulta.setText("Agendar Consulta");
        menuConsultas.add(menuItemAgendarConsulta);

        menuItemVisualizarModificarConsultas.setText("Visualizar ou Modificar Consultas Pendentes");
        menuConsultas.add(menuItemVisualizarModificarConsultas);



        jMenuBar1.add(menuConsultas);

        menuPacientes.setText("Pacientes");

        menuItemInserirPacientes.setText("Inserir");
        menuPacientes.add(menuItemInserirPacientes);

        menuItemVisualizarEditarPacientes.setText("Visualizar Pacientes");
        menuPacientes.add(menuItemVisualizarEditarPacientes);

        jMenuBar1.add(menuPacientes);

        menuInfo.setText("Informações");

        infoFuncionario.setText("Usuário do Sistema");

        menuInfo.add(infoFuncionario);

        jMenuBar1.add(menuInfo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        //getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelFundo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelFundo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        menuItemAgendarConsulta.addActionListener(listener);
        menuItemVisualizarModificarConsultas.addActionListener(listener);

        menuItemInserirPacientes.addActionListener(listener);
        menuItemVisualizarEditarPacientes.addActionListener(listener);
        infoFuncionario.addActionListener(listener);
        pack();  
             this.getContentPane().setLayout(layout);
                     Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
            setLocation((tela.width-this.getSize().width)/2,   
                      (tela.height-this.getSize().height)/2);  
    }

    public GroupLayout getTabela() {
        return tabela;
    }
}
