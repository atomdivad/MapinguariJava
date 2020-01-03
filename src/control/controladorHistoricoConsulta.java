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
import view.FrameAlteraConsulta;
import view.FrameAlteraHistoricoConsulta;
import view.FrameHistoricoConsulta;
import view.FrameHistoricoPaciente;

public class controladorHistoricoConsulta {

    funcionario medico;
    private FrameHistoricoConsulta fhc;
    private consulta c;
    public controladorHistoricoConsulta(funcionario m) {
        this.medico = m;
        fhc = new FrameHistoricoConsulta(new TrataEvento(), m);
        fhc.setVisible(true);
    }

    public class TrataEvento implements ActionListener {
        private ArrayList<consulta> cl;
        private consultaDAO cd = new consultaDAO();;
        private FrameAlteraHistoricoConsulta fac;
        private consulta c;
        @Override
        public void actionPerformed(ActionEvent e) {
                                SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String comando = e.getActionCommand();
            switch (comando) {
                case "Visualizar":
                    FrameHistoricoPaciente fhp = new FrameHistoricoPaciente();
                    ArrayList<paciente> pc;
                    paciente p;
                    cl = fhc.pegaObj().pegaLista();
                    c = cl.get(fhc.pegaSelecionado());
                    p = c.getPac();


                    fhp.setLabelNome(p.getNome());


                    Date date = null;
                    String data_consulta = null;
                    try {
                        date = (Date) df.parse(c.getData_consulta());
                        data_consulta = br.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    fhp.setHistorico("\t\tData da Consulta: " + data_consulta + " " + c.getHora_consulta());
                    fhp.setHistorico("\n\t[Descrição] " + c.getDescricao_consulta() + "\n");
                    fhp.setHistorico("\n\t[Prescrição] " + c.getPrescricao_consulta() + "\n");
                    fhp.setVisible(true);
                    break;
                case "Consultar Histórico":
                    FrameHistoricoPaciente fhp2 = new FrameHistoricoPaciente();
                    
                    ArrayList<paciente> pc2;
                    paciente p2;
                    p2=c.getPac();
                    ArrayList<consulta> cl2;
                    cl2=cd.buscaConsultasMedicoFrame(p2.getCpf());
                    fhp2.setLabelNome(p2.getNome());
                    for(int i=0;i<cl.size();i++){
                        consulta c=cl.get(i);

                    Date date2 = null;
                    String data_consulta2=null;
                    try {
                        date2 = (Date) df.parse(c.getData_consulta());
                        data_consulta2 = br.format(date2);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        fhp2.setHistorico("\t\tData da Consulta: "+data_consulta2+" "+c.getHora_consulta());
                        fhp2.setHistorico("\n\t[Descrição] "+c.getDescricao_consulta()+"\n");
                        fhp2.setHistorico("\n\t[Prescrição] "+c.getPrescricao_consulta()+"\n");
                        if(i+1!=cl.size()){
                            fhp2.setHistorico("\n\t-------------------------------------------------------------------------------------------------------------------------\n");
                        }
                    }
                    

                    fhp2.setVisible(true);
                    break;
                case "Alterar":
                    fac = new FrameAlteraHistoricoConsulta(this);
                    cl = fhc.pegaObj().pegaLista();
                    c = cl.get(fhc.pegaSelecionado());
                    fac.setLabelData(c.getData_consulta());
                    fac.setLabelHora(c.getHora_consulta());
                    fac.setjTextArea1(c.getPrescricao_consulta());
                    fac.setjTextArea2(c.getDescricao_consulta());
                    fac.setLabelPacienteNome(c.getPac().getNome());
                    fac.setVisible(true);
                    break;
                case "Atualizar":
                    c.setPrescricao_consulta(fac.getjTextArea1());
                    c.setDescricao_consulta(fac.getjTextArea2());
                    cd.atualizarConsultaFrameAtendeMedicoHistorico(c);
                    fac.setVisible(false);
                    break;
            }
        }
    }
}
