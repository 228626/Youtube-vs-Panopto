package project1;
import java.io.FileWriter;

/*
Citation: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
Taken from here, but edited by adding functions and changing Node structure.
*/
public class BST {

    /* Class containing left
       and right child of current node
     * and key value*/
    class Node {
        Word key;
        Node left, right;

        public Node(Word item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of com.company.BST
    Node root;

    // Constructor
    BST() { root = null; }

    // This method mainly calls insertRec()
    void insert(Word key) { root = insertRec(root, key); }

    /* A recursive function to
       insert a new key in com.company.BST */
    Node insertRec(Node root, Word key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.getWord().compareTo(root.key.getWord()) <0)
            root.left = insertRec(root.left, key);
        else
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void equal_write(FileWriter writer) throws Exception
    {
        equal_write_helper(writer, root);
    }

    void different_write(FileWriter writer) throws Exception
    {
        different_write_helper(writer, root);
    }

    void different_write_helper(FileWriter myWriter, Node root) throws Exception
    {
        if (root != null) {
            different_write_helper(myWriter,root.left);

            if(root.key.getCountPT() != root.key.getCountYT()) {
                if(root.key.getCountYT() == 0)
                {
                    myWriter.write(root.key.getWord() + "\t\t+" + root.key.getCountPT() + " PT - ZERO\n");
                }
                else if(root.key.getCountPT() == 0)
                {

                    myWriter.write(root.key.getWord() + "\t\t+" + root.key.getCountYT() + " YT - ZERO\n");
                }
                else if(root.key.getCountPT() > root.key.getCountYT())
                {
                    myWriter.write(root.key.getWord() + "\t\t+" + root.key.getCountPT()+ " PT\n");
                }
                else
                {
                    myWriter.write(root.key.getWord() + "\t\t+" + root.key.getCountYT()+ " YT\n");
                }
            }

            different_write_helper(myWriter,root.right);
        }
    }

    //SELF MADE FUNCTION TO WRITE TO THE FILE
    void equal_write_helper(FileWriter writer, Node root) throws Exception
    {
        if (root != null) {
            equal_write_helper(writer,root.left);
            if(root.key.getCountPT() == root.key.getCountYT()) {
                writer.write(root.key.getWord() + "\t\t" + root.key.getCountYT() + "\n");
            }
            equal_write_helper(writer,root.right);
        }
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to
    // do inorder traversal of com.company.BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}