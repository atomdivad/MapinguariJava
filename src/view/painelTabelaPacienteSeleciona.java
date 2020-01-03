package view;

import control.controladorAgendaConsulta;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.paciente;
import model.pacienteDAO;

public class painelTabelaPacienteSeleciona extends JPanel {

    private JTable tableDados;
    private boolean DEBUG = true;
    private JButton botaoSelecionar;
        private pacienteDAO rs = new pacienteDAO();
    public painelTabelaPacienteSeleciona(ActionListener listener) {
        botaoSelecionar = new JButton();
        
        botaoSelecionar.setText("Selecionar");
        
        
        tableDados = new JTable(new painelTabelaPacienteSeleciona.tabelaModelo());
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
        add(scrollPane,BorderLayout.CENTER);
        add(botaoSelecionar,BorderLayout.SOUTH);
        botaoSelecionar.addActionListener(listener);
        
              
    }

    public class tabelaModelo extends DefaultTableModel implements TableModelListener {

        String[] columnNames = {"Nome", "CPF", "Data de Nascimento", "RG", "UF", "Telefone", "Cidade", "Rua", "Ap", "Lote", "Numero de Consultas"};
        ArrayList<paciente> dados = new ArrayList<>();

        public tabelaModelo() {

            this.setColumnIdentifiers(columnNames);
            dados = rs.buscaPacientes();

        }
        @Override
        public int getRowCount() {
            int rows = 0;
            if (this.dados != null && this.dados.size() > 0) {
                rows = this.dados.size();
            }
            return rows;

        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            paciente pac = null;
            Object s = null;
            if (this.dados != null && this.dados.size() > 0) {
                pac = (paciente) this.dados.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        s = pac.getNome();
                        break;
                    case 1:
                        s = pac.getCpf();
                        break;
                    case 2:
                    SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    String data_consulta = null;

                    try {
                        date = (Date) df.parse(pac.getData_nascimento());
                        data_consulta = br.format(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(controladorAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        s = data_consulta;
                        break;
                    case 3:
                        s = pac.getRg();
                        break;
                    case 4:
                        s = pac.getUf();
                        break;
                    case 5:
                        s = pac.getTelefone();
                        break;
                    case 6:
                        s = pac.getCidade();
                        break;
                    case 7:
                        s = pac.getRua();
                        break;
                    case 8:
                        s = pac.getAp();
                        break;
                    case 9:
                        s = pac.getLote();
                        break;
                    case 10:
                        s = pac.getNumero_consultas_realizadas();
                        break;
                }
            }
            return s;
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            painelTabelaClientes.tabelaModelo model = (painelTabelaClientes.tabelaModelo) e.getSource();
            String columnName = model.getColumnName(column);
            Object data = model.getValueAt(row, column);
            data.toString();
        }
    }
    public int pegaSelecionado(){
        return tableDados.getSelectedRow();
    }
    public JTable getTableDados(){
        return tableDados;
    }
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        TableModel model = table.getModel();
        //System.out.print(table.getColumn(table));
        System.out.println("--------------------------");
        System.out.println("Value of data: ");

        System.out.println(table.getSelectedRow());
        System.out.println(model.getValueAt(table.getSelectedRow(), 0));


//        for (int i=0; i < numRows; i++) {
//            System.out.print("    row " + i + ":");
//            for (int j=0; j < numCols; j++) {
//                System.out.print("  " + model.getValueAt(i, j));
//            }
//            System.out.println();
//        }
        System.out.println("--------------------------");
    }

//    public static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("TableDemo");
//        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        painelTabelaClientes newContentPane = new painelTabelaClientes();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
}