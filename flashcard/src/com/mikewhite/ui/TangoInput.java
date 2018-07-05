package com.mikewhite.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mikewhite.db.DatabaseManager;

public class TangoInput extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_QUERY = "INSERT into vocab(`dictionary`, `masu`, `te`, `kanji`, `meaning`) values('%s','%s','%s','%s','%s')";
    private static final int SIZE = 12;

    private JTextField dictionaryTxt;
    private JTextField masuTxt;
    private JTextField teTxt;
    private JTextField kanjiTxt;
    private JTextField meaningTxt;
    private JButton addBtn;

    public TangoInput() {
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel dictLbl = new JLabel("Dictionary Form");
        this.add(dictLbl, gbc);
        gbc.gridx = 1;
        dictionaryTxt = new JTextField(SIZE);
        this.add(dictionaryTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel masuLbl = new JLabel("ます-Form");
        this.add(masuLbl, gbc);
        gbc.gridx = 1;
        masuTxt = new JTextField(SIZE);
        this.add(masuTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel teLbl = new JLabel("て-Form");
        this.add(teLbl, gbc);
        gbc.gridx = 1;
        teTxt = new JTextField(SIZE);
        this.add(teTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel kanjiLbl = new JLabel("かんじ");
        this.add(kanjiLbl, gbc);
        gbc.gridx = 1;
        kanjiTxt = new JTextField(SIZE);
        this.add(kanjiTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel meaningLbl = new JLabel("Meaning");
        this.add(meaningLbl, gbc);
        gbc.gridx = 1;
        meaningTxt = new JTextField(SIZE);
        this.add(meaningTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // check we have data to add
                if (dictionaryTxt.getText().length() == 0 && masuTxt.getText().length() == 0
                        && teTxt.getText().length() == 0 && kanjiTxt.getText().length() == 0
                        && meaningTxt.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please fill in data to add", "Error Adding Data",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // add item to database
                try {
                    DatabaseManager.getInstance().execute(String.format(INSERT_QUERY, dictionaryTxt.getText(),
                            masuTxt.getText(), teTxt.getText(), kanjiTxt.getText(), meaningTxt.getText()));
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }

                // clear fields
                dictionaryTxt.setText("");
                masuTxt.setText("");
                teTxt.setText("");
                kanjiTxt.setText("");
                meaningTxt.setText("");
            }

        });
        this.add(addBtn, gbc);
    }
}
