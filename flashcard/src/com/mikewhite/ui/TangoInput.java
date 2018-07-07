package com.mikewhite.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mikewhite.db.DatabaseManager;

public class TangoInput extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String INSERT_QUERY = "INSERT into vocab(`hiragana`, `kanji`, `meaning`) values('%s','%s','%s')";
    private static final String DUP_CHECK_QUERY = "SELECT count(id) as cnt from vocab where hiragana='%s' and kanji='%s' and meaning='%s'";
    private static final int SIZE = 12;

    private JTextField hiraganaTxt;
    private JTextField kanjiTxt;
    private JTextField meaningTxt;
    private JButton addBtn;

    public TangoInput() {
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel dictLbl = new JLabel("ひらがな");
        this.add(dictLbl, gbc);
        gbc.gridx = 1;
        hiraganaTxt = new JTextField(SIZE);
        this.add(hiraganaTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel kanjiLbl = new JLabel("かんじ");
        this.add(kanjiLbl, gbc);
        gbc.gridx = 1;
        kanjiTxt = new JTextField(SIZE);
        this.add(kanjiTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel meaningLbl = new JLabel("英語");
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
                if (hiraganaTxt.getText().length() == 0 || kanjiTxt.getText().length() == 0
                        || meaningTxt.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "All fields are required", "Error Adding Data",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // check for duplicates before adding
                if (isDuplicate(hiraganaTxt.getText(), kanjiTxt.getText(), meaningTxt.getText())) {
                    JOptionPane.showMessageDialog(null, "Vocabulary already exists", "Duplicate Entry",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // add item to database
                try {
                    DatabaseManager.getInstance().execute(String.format(INSERT_QUERY, hiraganaTxt.getText(),
                            kanjiTxt.getText(), meaningTxt.getText()));
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }

                // clear fields
                hiraganaTxt.setText("");
                kanjiTxt.setText("");
                meaningTxt.setText("");
            }

        });
        this.add(addBtn, gbc);
    }

    private boolean isDuplicate(String hiragana, String kanji, String meaning) {
        ResultSet rs;
        try {
            rs = DatabaseManager.getInstance().fetch(String.format(DUP_CHECK_QUERY, hiragana, kanji, meaning));
            rs.next();
            int count = rs.getInt(1);
            return count >= 1;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }
}
