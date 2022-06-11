package project1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Hashing {
    static BST [] wordbst;

    static Vector<Word> wordlist;

    public Hashing(Vector<Word> list)
    {
        wordbst = new BST[26];
        for(int i =0; i<26; i++)
            wordbst[i] = new BST();
        wordlist = new Vector<Word>();
        wordlist = list;
        populateHash();
    }

    public static int getIndex(String a)
    {
        if(a.charAt(0) >= 'a' && a.charAt(0) <= 'z')
            return a.charAt(0)-'a';
        else
            return 0;
    }

    public static void writeListEqual()
    {
        try {
            FileWriter myWriter = new FileWriter("resultsListEqual.txt");
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            //myWriter.close();
            wordlist.sort(new Word());
            for (Word word : wordlist) {
                if(word.getCountPT() == word.getCountYT()) {
                    myWriter.write(word.getWord() + "\t\t" + word.getCountYT() + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeListDifference()
    {
        try {
            FileWriter myWriter = new FileWriter("resultsListDiff.txt");
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            //myWriter.close();
            wordlist.sort(new Word());
            for (Word word : wordlist) {
                if(word.getCountPT() != word.getCountYT()) {
                    if(word.getCountYT() == 0)
                    {
                        myWriter.write(word.getWord() + "\t\t+" + word.getCountPT() + " PT - ZERO\n");
                    }
                    else if(word.getCountPT() == 0)
                    {

                        myWriter.write(word.getWord() + "\t\t+" + word.getCountYT() + " YT - ZERO\n");
                    }
                    else if(word.getCountPT() > word.getCountYT())
                    {
                        myWriter.write(word.getWord() + "\t\t+" + word.getCountPT()+ " PT\n");
                    }
                    else
                    {
                        myWriter.write(word.getWord() + "\t\t+" + word.getCountYT()+ " YT\n");
                    }
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeEqual() throws Exception
    {
        try {
            FileWriter myWriter = new FileWriter("resultsEqual.txt");

            for(int i =0; i<26; i++)
            {
                wordbst[i].equal_write(myWriter);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeDifference() throws Exception
    {
        try {
            FileWriter myWriter = new FileWriter("resultsDiff.txt");

            for(int i =0; i<26; i++)
            {
                wordbst[i].different_write(myWriter);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void populateHash()
    {
        for(Word word :wordlist)
        {
            int index = getIndex(word.getWord());
            wordbst[index].insert(word);
        }
    }
}