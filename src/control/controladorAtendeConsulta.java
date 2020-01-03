package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.consulta;
import model.consultaDAO;
import model.funcionario;
import model.paciente;
import view.FrameAtendeConsulta;
import view.FrameHistoricoPaciente;
import view.painelTabelaConsultasAtendimento;

public class controladorAtendeConsulta {
    private painelTabelaConsultasAtendimento pca;
    private FrameAtendeConsulta fac;
    private consulta c;
    public controladorAtendeConsulta(painelTabelaConsultasAtendimento pc) {
        fac = new FrameAtendeConsulta(new TrataEvento());
                pca = pc;
                            ArrayList<consulta> cl = pca.pegaLista();
                    c = cl.get(pca.pegaSelecionado());
                    fac.setLabelData(c.getData_consulta());
                    fac.setLabelHora(c.getHora_consulta());
                    fac.setLabelPacienteNome(c.getPac().getNome());
                    fac.setVisible(true);
                    fac.setDefaultCloseOperation(FrameAtendeConsulta.DISPOSE_ON_CLOSE);

    }
    public class TrataEvento implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            consultaDAO cd = new consultaDAO();
            String comando = e.getActionCommand();
            switch(comando){
                case "Finalizar":
                    c.setPrescricao_consulta(fac.getjTextArea1());
                    c.setDescricao_consulta(fac.getjTextArea2());
                    cd.atualizarConsultaFrameAtendeMedico(c);
                    fac.setVisible(false);
                    break;
                case "Consultar Histórico":
                   FrameHistoricoPaciente fhp = new FrameHistoricoPaciente();
                    
                    ArrayList<paciente> pc;
                    paciente p;
                    p=c.getPac();
                    ArrayList<consulta> cl;
                    cl=cd.buscaConsultasMedicoFrame(p.getCpf());
                    fhp.setLabelNome(p.getNome());
                    for(int i=0;i<cl.size();i++){
                        consulta c=cl.get(i);
                                            SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    String data_consulta=null;
                    try {
                        date = (Date) df.parse(c.getData_consulta());
                        data_consulta = br.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        fhp.setHistorico("\t\tData da Consulta: "+data_consulta+" "+c.getHora_consulta());
                        fhp.setHistorico("\n\t[Descrição] "+c.getDescricao_consulta()+"\n");
                        fhp.setHistorico("\n\t[Prescrição] "+c.getPrescricao_consulta()+"\n");
                        if(i+1!=cl.size()){
                            fhp.setHistorico("\n\t-------------------------------------------------------------------------------------------------------------------------\n");
                        }
                    }
                    

                    fhp.setVisible(true);
                    break;
                case "Limpar":
                    fac.setjTextArea1(null);
                    fac.setjTextArea2(null);
                    break;
            }
        }
        
    }
}
