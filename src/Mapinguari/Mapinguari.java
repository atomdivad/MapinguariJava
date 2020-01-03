package Mapinguari;

import control.controladorAgendaConsulta;
import control.controladorFrameMedico;
import control.controladorFrameSecretaria;
import control.controladorLogin;
import control.controladorVisualizaConsulta;
import java.awt.EventQueue;
import java.util.ArrayList;
import model.funcionario;
import model.funcionarioDAO;
import model.paciente;
import model.pacienteDAO;
import view.FrameAgendaConsulta;
import view.LoginFrame;
import view.FrameSecretaria;
import view.painelCadastroCliente;
import view.painelTabelaClientes;

public class Mapinguari {

    public static void main(String[] args) {
        //a forma correta e despachar a thread do frame um uma thread propria em vez da thread
        //principal que quando ela morrer o frame pode continuar rodando..
        //o codigo abaixo deve ser feito para uma aplicação com mts componentes
        EventQueue.invokeLater(new Runnable() {//objeto anonimo que implementa a interface runnable ( codificar o metodo chamado run) 
            @Override
            public void run() {
               controladorLogin cl = new controladorLogin();
                                //painelTabelaClientes.createAndShowGUI();

                
                //FrameAgendaConsulta fac = new FrameAgendaConsulta();
//                funcionarioDAO fd = new funcionarioDAO();
//                funcionario f = fd.buscaFuncionario("03139821123");
//                controladorFrameMedico fm = new controladorFrameMedico(f);
//               controladorFrameSecretaria fc = new controladorFrameSecretaria(f);
//               
                //painelCadastroCliente pc = new painelCadastroCliente();
                //controladorVisualizaConsulta c = new controladorVisualizaConsulta(f);

            }
        });
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });
    
        /*
        pacienteDAO rs = new pacienteDAO();
        ArrayList<paciente> ap;
        ap = rs.buscaPacientes();
        for(int i=0;i<ap.size();i++){
            paciente e=ap.get(i);
            System.out.println(e.getNome()+" "+e.getCpf()+" "+e.getRg()+" "+e.getData_nascimento());
        }*/
    }
        
}
