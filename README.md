# Youtube-vs-Panopto

**Description:**

A colleague and friend of Prof. Lupoli from another university recently reached out about the video lecture labs at UMBC. After discussing the
logistics and best practices, Prof. Lupoli was informed that his friend’s university did not require them to post their lecture videos on a video sharing service 
called Ponopto (PT). Apparently, YouTube’s (YT) closed captioning is not as accurate as some other services. 

This individually completed project will only touch some of the aspects to determine if this overall statement is true. The biggest objective for this project
is to determine the count of each word spoken in either video sharing service. 

The project’s overall goal is to determine differences, similarities and ZERO values found in the data files

**Part 1 - Gathering the Data**

●	no duplicate words
●	in alphabetical order
●	each word on a line
●	punctuation has been removed
●	apostrophes and “-” are allowed

**Part 2 - Hashing/Mapping**

In this part, the goal will be to hash the gathered data by its first letter.  The hashmap (hash/map) can be anything you wish,
for example, a great question.
Also, since we are to have things in order, from a-z, and a hash map/table, by definition does not keep track of order, is this some sort of pseudo-hash map/table
that's basically a linked list/vector/array? Or does the internal order of the hash table not matter really, the files really just (need) to be in order?
Under “a” in your hashmap, should store all of the Words (and complete data members) that start with “a”. And same for the rest of the letters. 

**Part 3 - Collecting Data Structure that you decide**

You will have a choice on HOW the hashmap will store the data for that particular letter. You have a single option of a Java:
1.	Red Black Tree  (rename to RedBlackTree.java)
2.	Binary Search Tree (rename to BST.java)
3.	B-Tree (or called 2-3 Tree, max degree of 3) (rename to BTree.java)

You can “borrow” code from a book, website, etc… you do not have to create the code. 

**Part 4 - The Test Driver**

The Driver (and Driver.java) is really up to you. This will be your platform to get everything ready and running. It should be able to
call all important functions create the data files required. 

**Part 5 - Test Class Interface

We will test your code with a file named Testing.java. This will be the unit testing file. You will use the Driver.java class and file as the link between our 
required calls below in order to test your work. Please pay careful attention to all functions and their argument requirements. Testing.java will be calling driver
functions and testing them in its main.

