package project1;

import java.util.Comparator;

public class Word implements Comparator<Word> {
    String word;

    int countPT;
    int countYT;

    public String getWord() {
        return word;
    }

    public int getCountPT() {
        return countPT;
    }

    public int getCountYT() {
        return countYT;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCountPT(int countPT) {
        this.countPT = countPT;
    }

    public void setCountYT(int countYT) {
        this.countYT = countYT;
    }

    @Override
    public String toString() {
        return "----------\n" + word + "\n" + countPT + "\n" + countYT + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof String)
            return word.equals(o);

        if (!(o instanceof Word c)) {
            return false;
        }
        return word.equals(c.word);
    }

    public Word() {
        countPT = countYT = 0;
    }

    public Word(String word) {
        this.word = word;
        countPT = countYT = 0;
    }

    public int compare(Word d, Word d1) {
        return d.word.compareTo(d1.word);
    }
}