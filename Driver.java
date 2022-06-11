package project1;

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Driver {

    static Hashing hash;

    static void readFiles()
    {
        hash = new Hashing(FileIO.readFile(true));
    }

    static void createListEqual()
    {
        Hashing.writeListEqual();
    }
    static void createListDiff()
    {
        Hashing.writeListDifference();
    }

    static void createEqual() throws Exception
    {
        Hashing.writeEqual();
    }

    static void createDiff() throws Exception
    {
        Hashing.writeDifference();
    }

    /*
    public static void main(String[] args) throws Exception {
        Vector <Word> words = FileIO.readFile(true); //Retrieve word list with debug mode on
        System.out.println("Part 1...\ndebug1.txt created successfully, words retrieved.");

        Hashing hash = new Hashing(words); //Populate BST

        System.out.println("Part 2...\nCreating resultsListEqual.txt and resultsListDiff.txt");
        Hashing.writeListEqual();
        Hashing.writeListDifference();

        System.out.println("Part 3... Creating resultsEqual.txt and resultsDiff.txt");
        Hashing.writeEqual();
        Hashing.writeDifference();



    }*/
}