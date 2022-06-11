package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class FileIO {

    public static boolean openTextFile(String filename)
    {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
    }

    public static Vector<Word> readFile(boolean flag) {
        Vector<Word> vec = new Vector<Word>();
        try {
            File myObj = new File("D:\\WORK\\fahad\\JavaString\\PT1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                myReader.nextLine();
                String line = myReader.nextLine();
                if (Objects.equals(line, ""))
                    break;
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    word = cleanWord(word);
                    if (checkWord(word)) {
                        Word temp = new Word(word);
                        if (vec.contains(temp)) {
                            int index = vec.indexOf(temp);
                            vec.get(index).setCountPT(vec.get(index).getCountPT() + 1);
                        } else {
                            vec.add(temp);
                            int index = vec.indexOf(temp);
                            vec.get(index).setCountPT(1);
                        }
                    }
                }
                myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("D:\\WORK\\fahad\\JavaString\\YT1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (Objects.equals(line, ""))
                    break;
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    word = cleanWord(word);
                    if (checkWord(word)) {
                        Word temp = new Word(word);
                        if (vec.contains(temp)) {
                            int index = vec.indexOf(temp);
                            vec.get(index).setCountYT(vec.get(index).getCountYT() + 1);
                        } else {
                            vec.add(temp);
                            int index = vec.indexOf(temp);
                            vec.get(index).setCountYT(1);
                        }
                    }
                }
            }
            vec.sort(new Word());
            myReader.close();
            if (flag) {
                writeDebug(vec);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return vec;
    }

    static boolean checkWord(String str)
    {
        if(str.length() <= 0)
            return false;
        return str.charAt(0) >= 'a' && str.charAt(0) <= 'z';
    }

    public static void writeDebug(Vector<Word> vec) {
        try {
            FileWriter myWriter = new FileWriter("debug1.txt");
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            //myWriter.close();
            for (Word word : vec) {
                myWriter.write(word.getWord() + "\n");
                //System.out.println(word);
            }
            myWriter.close();
            System.out.println(vec.size() + " Words read.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    public static String cleanWord(String str) {
        str = str.toLowerCase();
        String newstr = "";
        for(int i =0; i< str.length(); i++)
        {
            if((str.charAt(i)>= 'a' && str.charAt(i) <= 'z') || str.charAt(i) == '-' || str.charAt(i) == 39)
            {
                newstr += str.charAt(i);
            }

        }
        return newstr;
    }

}