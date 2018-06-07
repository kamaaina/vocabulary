package com.mikewhite.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import com.mikewhite.db.DatabaseManager;
import com.mikewhite.model.TangoModel;
import com.mikewhite.ui.FlashcardPanel;

public class FlashcardController {
    private FlashcardPanel panel;
    private List<TangoModel> models;
    private DatabaseManager dbmgr;
    private int size;
    private int index = -1;

    public FlashcardController(FlashcardPanel panel) {
        this.panel = panel;
        models = new ArrayList<>();
        dbmgr = DatabaseManager.getInstance();
        if (dbmgr.connect("localhost", "test", "test")) {
            try {
                ResultSet rs = dbmgr.fetch("select dictionary,masu,te,kanji,meaning from vocab");
                while (rs.next()) {
                    TangoModel tm = new TangoModel();
                    tm.setDictionaryForm(rs.getString(1));
                    tm.setMasuForm(rs.getString(2));
                    tm.setTeForm(rs.getString(3));
                    tm.setKanji(rs.getString(4));
                    tm.setMeaning(rs.getString(5));
                    models.add(tm);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Unable to connect to database");
        }
        size = models.size();
        Collections.shuffle(models);
    }

    public TangoModel next() {
        if (++index == size)
            index = 0;
        return models.get(index);
    }
}
