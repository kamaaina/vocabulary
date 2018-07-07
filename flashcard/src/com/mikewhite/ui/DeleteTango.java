package com.mikewhite.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mikewhite.db.DatabaseManager;
import com.mikewhite.model.TangoModel;

public class DeleteTango extends JPanel {

    private static final long serialVersionUID = 1L;

    private final String DELETE_VOCAB = "DELETE from vocab where id=%d";

    private JTable tangoTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private List<TangoModel> tangoList;
    private JButton deleteBtn;

    private final Object[] COLUMNS = { "Id", "英語", "日本語" };

    public DeleteTango(List<TangoModel> tangoList) {
        this.tangoList = tangoList;
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        tableModel = new DefaultTableModel();
        tangoTable = new JTable();
        // tangoTable.setSelectionMode(); // FIXME: single selection
        tangoTable.setModel(tableModel);
        tableModel.setColumnIdentifiers(COLUMNS);
        tangoTable.setRowHeight(tangoTable.getRowHeight() + 3);
        tangoTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        // tangoTable.getColumnModel().getColumn(1).setPreferredWidth(170);
        // tangoTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        // tangoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tangoTable.setAutoCreateRowSorter(true);

        // display list of vocabulary in table
        for (TangoModel tm : tangoList) {
            Object rowData[] = new Object[3];
            rowData[0] = tm.getId();
            rowData[1] = tm.getMeaning();
            rowData[2] = tm.getHiragana();
            tableModel.addRow(rowData);
        }
        scrollPane = new JScrollPane(tangoTable);
        this.add(scrollPane, gbc);

        gbc.gridx = 1;
        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tangoTable.getSelectedRow();
                while (selectedIndex >= 0) {

                    int modelIndex = tangoTable.convertRowIndexToModel(selectedIndex);
                    int id = (int) tableModel.getValueAt(modelIndex, 0);

                    // delete from database
                    try {
                        DatabaseManager.getInstance().execute(String.format(DELETE_VOCAB, id));
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                    tableModel.removeRow(modelIndex);
                    selectedIndex = tangoTable.getSelectedRow();
                }
            }

        });
        this.add(deleteBtn, gbc);
    }
}
