package com.mikewhite.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mikewhite.controller.FlashcardController;
import com.mikewhite.model.TangoModel;

public class FlashcardPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtField;
    private JTextField meaningTxt;
    private JButton dictBtn;
    private JButton masuBtn;
    private JButton teBtn;
    private JButton kanjiBtn;
    private JButton nextBtn;
    private FlashcardController controller;
    private TangoModel tangoModel;

    public FlashcardPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        controller = new FlashcardController(this);

        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Font font = new Font("Calbri", Font.BOLD, 46);
        txtField = new JTextField(12);
        txtField.setFont(font);
        txtField.setEditable(false);
        txtField.setHorizontalAlignment(JTextField.CENTER);
        add(txtField, gbc);

        gbc.gridy = 1;
        meaningTxt = new JTextField(12);
        meaningTxt.setForeground(Color.BLUE);
        meaningTxt.setEditable(false);
        meaningTxt.setHorizontalAlignment(JTextField.CENTER);
        add(meaningTxt, gbc);

        gbc.gridy = 2;
        font = new Font("Calbri", Font.BOLD, 14);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        dictBtn = new JButton("Dictionary Form");
        dictBtn.setFont(font);
        dictBtn.setEnabled(false);
        dictBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(tangoModel.getDictionaryForm());
            }

        });
        masuBtn = new JButton("ます Form");
        masuBtn.setFont(font);
        masuBtn.setEnabled(false);
        masuBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(tangoModel.getMasuForm());
            }

        });
        teBtn = new JButton("て Form");
        teBtn.setFont(font);
        teBtn.setEnabled(false);
        teBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(tangoModel.getTeForm());
            }

        });
        kanjiBtn = new JButton("かんじ");
        kanjiBtn.setFont(font);
        kanjiBtn.setEnabled(false);
        kanjiBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(tangoModel.getKanji());
            }

        });
        panel.add(dictBtn);
        panel.add(masuBtn);
        panel.add(teBtn);
        panel.add(kanjiBtn);
        add(panel, gbc);

        gbc.gridy = 3;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        nextBtn = new JButton("Next");
        nextBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                loadVocabulary(controller.next());
                txtField.setText("");
            }

        });
        panel.add(nextBtn);
        add(panel, gbc);
    }

    private void loadVocabulary(TangoModel tm) {
        tangoModel = tm;
        meaningTxt.setText(tangoModel.getMeaning());
        dictBtn.setEnabled(tangoModel.getDictionaryForm() != null);
        masuBtn.setEnabled(tangoModel.getMasuForm() != null);
        teBtn.setEnabled(tangoModel.getTeForm() != null);
        kanjiBtn.setEnabled(tangoModel.getKanji() != null);
    }
}
