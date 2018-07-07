package com.mikewhite.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mikewhite.controller.FlashcardController;
import com.mikewhite.model.TangoModel;

public class FlashcardPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JFrame frame;
    private JTextField txtField;
    private JTextField meaningTxt;
    private JButton hiraganaBtn;
    private JButton kanjiBtn;
    private JButton englishBtn;
    private JButton nextBtn;
    private JButton addBtn;
    private JButton deleteBtn;
    private JRadioButton hiraganaRdo;
    private JRadioButton kanjiRdo;
    private JRadioButton meaningRdo;
    private FlashcardController controller;
    private TangoModel tangoModel;
    private int mode;

    public FlashcardPanel(JFrame frame) {
        this.frame = frame;
        mode = 3;
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
        hiraganaBtn = new JButton("ひらがな");
        hiraganaBtn.setFont(font);
        hiraganaBtn.setEnabled(false);
        hiraganaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText(tangoModel.getHiragana());
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

        englishBtn = new JButton("英語");
        englishBtn.setFont(font);
        englishBtn.setEnabled(false);
        englishBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                meaningTxt.setText(tangoModel.getMeaning());
            }

        });
        panel.add(hiraganaBtn);
        panel.add(kanjiBtn);
        panel.add(englishBtn);
        add(panel, gbc);

        gbc.gridy = 3;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        nextBtn = new JButton("Next");
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                meaningTxt.setText("");
                txtField.setText("");
                loadVocabulary(controller.next());
            }
        });
        panel.add(nextBtn);

        addBtn = new JButton("Add...");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dlg = new JDialog(frame, "Add Vocabulary");
                dlg.setModal(true);
                dlg.setLocationRelativeTo(null);
                dlg.add(new TangoInput());
                dlg.pack();
                dlg.setVisible(true);
                controller.updateModel();
            }
        });
        panel.add(addBtn);

        deleteBtn = new JButton("Delete..");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dlg = new JDialog(frame, "Delete Vocabulary");
                dlg.setModal(true);
                dlg.setLocationRelativeTo(null);
                dlg.add(new DeleteTango(controller.getModel()));
                dlg.pack();
                dlg.setVisible(true);
                controller.updateModel();
            }
        });
        panel.add(deleteBtn);

        add(panel, gbc);

        gbc.gridy = 4;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        hiraganaRdo = new JRadioButton("ひらがな");
        hiraganaRdo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mode = 1;
            }
        });
        kanjiRdo = new JRadioButton("かんじ");
        kanjiRdo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mode = 2;
            }
        });
        meaningRdo = new JRadioButton("英語");
        meaningRdo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mode = 3;
            }
        });
        meaningRdo.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(hiraganaRdo);
        group.add(kanjiRdo);
        group.add(meaningRdo);
        panel.add(hiraganaRdo);
        panel.add(kanjiRdo);
        panel.add(meaningRdo);
        add(panel, gbc);
    }

    private void loadVocabulary(TangoModel tm) {
        tangoModel = tm;
        if (mode == 3) { // english
            meaningTxt.setText(tangoModel.getMeaning());
            hiraganaBtn.setEnabled(tangoModel.getHiragana() != null && tangoModel.getHiragana().length() > 0);
            kanjiBtn.setEnabled(tangoModel.getKanji() != null && tangoModel.getKanji().length() > 0);
        } else if (mode == 2) { // kanji
            englishBtn.setEnabled(true);
            hiraganaBtn.setEnabled(tangoModel.getHiragana() != null && tangoModel.getHiragana().length() > 0);
            txtField.setText(tangoModel.getKanji());
        } else { // hiragana
            englishBtn.setEnabled(true);
            txtField.setText(tangoModel.getHiragana());
            kanjiBtn.setEnabled(tangoModel.getKanji() != null && tangoModel.getKanji().length() > 0);
        }
    }
}
