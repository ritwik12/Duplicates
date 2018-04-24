# Duplicates
Finding duplicates from a File and printing it to another file with duplicate count and creating another file with unique values.<br>

find all the duplicate lines and store the duplicate line as well as there count in the file duplicate.txt and then generate a new file "output.txt" which does not contain any repeating lines. <br>

# Approaches
## Using Data Structures (Duplicates.java)

There are two approaches for this. One is using Data structures such as ArrayList, Hashtable and HashSet. This approach is based on the characteristics of HashSet and Hashtable i.e they contains only unique elements. By comparing ArrayList and Hashtable we can calculate duplicate counts of duplicates. And HashSet is used to get unique lines to be printed in output.txt. <br>

## Without using Data Structures (DuplicateswithoutDS.java)

This approach doesn't use any Data structures for getting Duplicates count from a file or removing Duplicates from a file.

For example: <br>
If the input file contains lines like <br>
```
abc
123
abc
xyz
dce
xyz
```
<br>
Your program should produce two files, namely: duplicate.txt with the following contents <br>

```
abc 2
xyz 2
```
<br>
And another file output.txt with the following contents: <br>

```
abc
123
xyz
dce
```
# master_as.txt file
Here the file contains 431 lines with some duplicate lines

![master_as](https://user-images.githubusercontent.com/20038775/38994941-5d70e2da-4405-11e8-9a09-c2ea02af2cc6.JPG)

# output.txt file
Here the file contains 407 lines which are all unique after removing all the duplicates from master_as.txt file.

![output](https://user-images.githubusercontent.com/20038775/38994947-5e71b02e-4405-11e8-87e1-c626d4ab166b.JPG)

# duplicates.txt file
Here the file contains the duplicate lines from master_as.txt with their duplicate count.

![duplicates](https://user-images.githubusercontent.com/20038775/38995811-634f4d8e-4407-11e8-95ad-d55b2f90f1bc.JPG)

The following image shows the duplicate count for all the lines

![print](https://user-images.githubusercontent.com/20038775/38994949-5f43d1e4-4405-11e8-8f04-e6406aaca297.JPG)

# Alternate approach
In linux, <br>
To print duplicate lines only, with counts:
```
sort FILE | uniq -cd
```
To print counts for all lines including those that appear only once:
```
sort FILE | uniq -c
```



 
