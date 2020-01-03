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
import view.FrameAlteraConsulta;
import view.painelTabelaConsultas;

public class controladorEditarConsulta {

    private FrameAlteraConsulta fac;
    private funcionario sec;
    private consulta old;
    private consulta nova;
    private consultaDAO cd;
    private funcionario m;
    private funcionario s;
    private painelTabelaConsultas c;
    public controladorEditarConsulta(painelTabelaConsultas p, funcionario sec) {
        c=p;

        cd = new consultaDAO();
        fac = new FrameAlteraConsulta(new TrataEvento());
        fac.setcTextoCpf((String) p.getTableDados().getValueAt(p.pegaSelecionado(), 0));
        fac.setTextDataChooser((String) p.getTableDados().getValueAt(p.pegaSelecionado(), 2));
        fac.setcTextoHora((String) p.getTableDados().getValueAt(p.pegaSelecionado(), 3));
        fac.setCpfMedico((String) p.getTableDados().getValueAt(p.pegaSelecionado(), 5));
        fac.setCpfSecretaria((String) p.getTableDados().getValueAt(p.pegaSelecionado(), 4));
        fac.setCpfPaciente((String) p.getTableDados().getValueAt(p.pegaSelecionado(), 0));
        fac.setVisible(true);
        ArrayList<consulta> con = p.pegaLista();
        old = con.get(p.getRow());
        m = old.getMedico();
        s = old.getSecretaria();
        this.sec = sec;
    }

    public class TrataEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


            switch (comando) {
                case "Alterar":
                    Date date = null;
                    String data_consulta = null;
                    try {
                        date = (Date) br.parse(fac.getTextDataChooser());
                        data_consulta = df.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    nova = new consulta();
                    nova.setData_consulta(data_consulta);
                    nova.setHora_consulta(fac.getcTextoHora());
                    nova.setSecretaria(sec);
                    nova.setMedico(fac.getComboBoxMedico());
                    nova.setPac(fac.getPaciente());
                    cd.atualizarConsultaFrameSecretaria(nova, old);
                           
                    fac.setVisible(false);
                    break;
            }
        }
    }
}
