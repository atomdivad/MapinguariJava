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

public class painelTabelaConsultasAtendimento extends JPanel {

    private JTable tableDados;
//    private boolean DEBUG = true;
    private JButton botaoAtender;
    private funcionario medico;
    private consultaDAO cd = new consultaDAO();
    private ArrayList<consulta> dados = new ArrayList<>();
    private int rowI;

    public painelTabelaConsultasAtendimento(ActionListener listener,funcionario m) {
        botaoAtender = new JButton();
        botaoAtender.setText("Atender");
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
        add(botaoAtender, BorderLayout.SOUTH);
        botaoAtender.addActionListener(listener);
    }

    public class tabelaModelo extends DefaultTableModel implements TableModelListener {

        private String[] columnNames = {"CPF", "Nome Paciente", "Data", "Hora", "Secretaria", "Médico"};

        public tabelaModelo() {

            this.setColumnIdentifiers(columnNames);
            dados = cd.buscaConsultasMedicoFrameGeral(medico.getCpf());//consulta para um medico especifico

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

        public boolean isCellEditable(int row, int col) {
            return false;
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
