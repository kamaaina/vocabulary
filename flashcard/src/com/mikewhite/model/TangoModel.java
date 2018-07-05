package com.mikewhite.model;

public class TangoModel {
    private int id;
    private String dictionaryForm;
    private String masuForm;
    private String teForm;
    private String kanji;
    private String meaning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDictionaryForm() {
        return dictionaryForm;
    }

    public void setDictionaryForm(String dictionaryForm) {
        this.dictionaryForm = dictionaryForm;
    }

    public String getMasuForm() {
        return masuForm;
    }

    public void setMasuForm(String masuForm) {
        this.masuForm = masuForm;
    }

    public String getTeForm() {
        return teForm;
    }

    public void setTeForm(String teForm) {
        this.teForm = teForm;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

}
