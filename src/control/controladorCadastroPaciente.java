package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.paciente;
import model.pacienteDAO;
import view.FrameCadastroPaciente;

public class controladorCadastroPaciente {
    private FrameCadastroPaciente fcc;

    public controladorCadastroPaciente() {
        this.fcc = new FrameCadastroPaciente(new TrataEvento());
        fcc.setVisible(true);
    }
    public class TrataEvento implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Enviar":
                    paciente pc = new paciente();
                    pc.setAp(fcc.getcTextoAp());
                    pc.setCidade(fcc.getcTextoCidade());
                    pc.setCpf(fcc.getcTextoCpf());
                                        SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    String data_consulta=null;
                    try {
                        date = (Date) br.parse(fcc.getcTextoDataNascimento());
                        data_consulta = df.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pc.setData_nascimento(data_consulta);
                    pc.setLote(fcc.getcTextoLote());
                    pc.setNome(fcc.getcTextoNome());
                    pc.setNumero_consultas_realizadas(0);
                    pc.setRg(Integer.parseInt(fcc.getcTextoRg()));
                    pc.setRua(fcc.getcTextoRua());
                    pc.setTelefone(fcc.getcTextoTelefone());
                    pc.setUf(fcc.getcTextoUf());
                    pacienteDAO pcd = new pacienteDAO();
                    try {
                        pcd.cadastrarPaciente(pc);
                        JOptionPane.showMessageDialog(null,"Paciente Cadastrado");
                        fcc.setVisible(false);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Erro ao cadastrar");
                    }
                    break;
                case "Limpar":
                    fcc.setcTextoAp(null);
                    fcc.setcTextoCidade(null);
                    fcc.setcTextoCpf(null);
                    fcc.setcTextoDataNascimento(null);
                    fcc.setcTextoLote(null);
                    fcc.setcTextoNome(null);
                    fcc.setcTextoRg(null);
                    fcc.setcTextoRua(null);
                    fcc.setcTextoTelefone(null);
                    fcc.setcTextoUf(null);
                    break;
            }
        }
        
    }
}
