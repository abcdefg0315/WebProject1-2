package org.example;

public class Word {
    private int id;
    private String word;
    private String meaning;
    private int level;
    private String created_date;
    private boolean memorized;

    public Word(String word, String meaning, int level) {
        this.word = word;
        this.meaning = meaning;
        this.level = level;
    }

    public Word(int id, String word, String meaning, int level, String created_date, boolean memorized) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.level = level;
        this.created_date = created_date;
        this.memorized = memorized;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public boolean isMemorized() {
        return memorized;
    }

    public void setMemorized(boolean memorized) {
        this.memorized = memorized;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                ", level=" + level +
                ", created_date='" + created_date + '\'' +
                ", memorized=" + memorized +
                '}';
    }
}
