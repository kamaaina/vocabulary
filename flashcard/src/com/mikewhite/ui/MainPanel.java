package com.mikewhite.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private JButton nextBtn;
    private JCheckBox kanjiChk;
    private JCheckBox englishChk;

    public MainPanel() {
        label = new JLabel();
        label.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(label, gbc);

        JPanel btnPnl = new JPanel();
        nextBtn = new JButton("Next");
        kanjiChk = new JCheckBox("Kanji");
        kanjiChk.addActionListener(new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (kanjiChk.getText().equals("Kanji")) {
                    kanjiChk.setText("Hiragana");
                } else {
                    kanjiChk.setText("Kanji");
                }
            }
            
        });
        englishChk = new JCheckBox("English");
        btnPnl.setLayout(new FlowLayout());
        btnPnl.add(nextBtn);
        btnPnl.add(kanjiChk);
        btnPnl.add(englishChk);
        gbc.weightx = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridy = 1;
        this.add(btnPnl, gbc);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                Font labelFont = label.getFont();
                String labelText = label.getText();

                int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
                int componentWidth = label.getWidth();

                // Find out how much the font can grow in width.
                double widthRatio = (double) componentWidth / (double) stringWidth;

                int newFontSize = (int) (labelFont.getSize() * widthRatio);
                int componentHeight = label.getHeight();

                // Pick a new font size so it will not be larger than the height of label.
                int fontSizeToUse = Math.min(newFontSize, componentHeight);

                // Set the label's font size to the newly determined size.
                label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
            }
        });

        label.setText("おはようございます");
    }
}
