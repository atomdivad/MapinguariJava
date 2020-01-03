package view;

import control.controladorAgendaConsulta;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.consulta;
import model.consultaDAO;
import model.funcionario;

public class painelHistoricoConsultas extends JPanel {

    private JTable tableDados;
//    private boolean DEBUG = true;
    private JButton botaoAlterar;
    private JButton botaoVisualizar;
    private funcionario medico;
    private consultaDAO cd = new consultaDAO();
    private ArrayList<consulta> dados;
    private int rowI;

    public painelHistoricoConsultas(ActionListener listener,funcionario m) {
        botaoAlterar = new JButton();
        botaoVisualizar = new JButton();
        botaoVisualizar.setText("Visualizar");
        botaoAlterar.setText("Alterar");
        this.medico = m;
        tableDados = new JTable(new tabelaModelo());
        tableDados.setPreferredScrollableViewportSize(new Dimension(1024, 210));
        tableDados.setFillsViewportHeight(true);
        tableDados.getModel().addTableModelListener(tableDados);

        //tableDados.addMouseListener(null);
//        if (DEBUG) {
//            tableDados.addMouseListener(new MouseAdapter() {
//                public void mouseClicked(MouseEvent e) {
//                    System.out.println(tableDados.getSelectedRow());
//                    //System.out.println(model.getValueAt(table.getSelectedRow(), 0));
//                    painelCadastroCliente pcc = new painelCadastroCliente();
//                    // printDebugData(tableDados);
//
//                }
//            });
//        }
        JScrollPane scrollPane = new JScrollPane(tableDados);
        add(scrollPane, BorderLayout.CENTER);
        add(botaoVisualizar,BorderLayout.SOUTH);
        add(botaoAlterar, BorderLayout.SOUTH);
        botaoVisualizar.addActionListener(listener);
        botaoAlterar.addActionListener(listener);
    }

    public class tabelaModelo extends DefaultTableModel implements TableModelListener {

        private String[] columnNames = {"CPF", "Nome Paciente", "Data", "Hora", "Secretaria", "Médico"};

        public tabelaModelo() {

            this.setColumnIdentifiers(columnNames);
            dados = cd.buscaConsultasMedicoFrameGeralFinalizada(medico.getCpf());//consulta para um medico especifico

        }

        @Override
        public int getRowCount() {
            int rows = 0;
            if (dados != null && dados.size() > 0) {
                rows = dados.size();
            }
            return rows;

        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            consulta con = null;
            Object s = null;
            if (dados != null && dados.size() > 0) {
                rowI = rowIndex;
                con = (consulta) dados.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        s = con.getPac().getCpf();
                        break;
                    case 1:
                        s = con.getPac().getNome();
                        break;
                    case 2:
                        SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;
                        String data_consulta = null;

                        try {
                            date = (Date) df.parse(con.getData_consulta());
                            data_consulta = br.format(date);
                        } catch (ParseException ex) {
                            Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        s = data_consulta;
                        break;
                    case 3:
                        s = con.getHora_consulta();
                        break;
                    case 4:
                        s = con.getSecretaria().getNome();
                        break;
                    case 5:
                        s = con.getMedico().getNome();
                        break;
                }
            }
            return s;
        }
        @Override
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            view.painelTabelaClientes.tabelaModelo model = (view.painelTabelaClientes.tabelaModelo) e.getSource();
            String columnName = model.getColumnName(column);
            Object data = model.getValueAt(row, column);
            data.toString();
        }
    }

    public int pegaSelecionado() {
        return tableDados.getSelectedRow();
    }

    public JTable getTableDados() {
        return tableDados;
    }

    public ArrayList<consulta> pegaLista() {
        return dados;
    }

    public int getRow() {
        return rowI;
    }
}
