package com.mikewhite.main;

import javax.swing.JFrame;

import com.mikewhite.ui.FlashcardPanel;

public class Main {
    public Main() {
        JFrame frame = new JFrame("Flashcard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FlashcardPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new Main();
    }

}
