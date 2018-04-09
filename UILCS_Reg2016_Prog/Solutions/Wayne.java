/**
After completing a unit on binary search trees, Wayne was considering how to keep these search trees better balanced.  He had learned that the IPL (internal path length) of a tree is a good indicator of how balanced it is.
The internal path length of a tree is the sum of the depths of each node in the tree, and the better balanced a tree is, the lower the IPL value is.

His idea was to take a data set, build a normal binary search tree by starting with the first element as the root node, and inserting the others in order, allowing duplicate values and sliding ties to the left. He would measure the IPL of the normal tree, and then use a "two-ahead" technique in an attempt to build a more balanced tree.
The way this works is to consider the first three elements of the data set, arrange them in order, and insert the middle element as the root. After that, add another element from the data set, arrange them in order again, and insert the middle element.
Continue this process until the last data element is added to the group of three, and again, the middle of those last three is inserted.  When only two elements remain, insert the lesser of those two, and then the last one standing.

Supposedly, Wayne thought, this would make for a more balanced tree, which in turn would be more efficient.  The IPL of this tree should be a lower value.

He decided to research this process with several sets of data, showing the IPL of the normal BST, then the "two-ahead" BST, and then determine if there was an improvement, and by how much.

Write a program to simulate Wayne's research.

Input - Several words, all in caps, containing no symbols or spaces, each word at least three characters in length.

Output - For each word, build a standard binary search tree, with duplicate values allowed, and ties going to the left, and then output the IPL for that tree.  Do the same using the "two-ahead" tree as described above and output the IPL for that tree.  Finally, output the analysis, indicating how much "BETTER" or "WORSE" the second tree is from the first.

Sample data:
BINARYTREE
RESEARCH
TWOAHEAD

Sample Output:
25 21 4 BETTER
16 16 SAME
19 21 2 WORSE

 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Wayne {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("wayne.dat"));
		while(f.hasNext()) {
			String s = f.next();
		    char[]list=s.toCharArray();

//		build normal BST
		BTree b = new BTree(list[0]);
        for(int x=1;x<list.length;x++)
           b.insert(b.root, list[x]);
//		b.printPre(b.root);
//		out.println();
//		b.printIn(b.root);
//    	out.println();
		int bipl = b.iPL(b.root,0);
		out.print(bipl+" ");
		
//		build balanced BST using 2-char lookahead
		ArrayList<Character> lets = new ArrayList();
		lets.add(list[0]);
		lets.add(list[1]);
		lets.add(list[2]);
		Collections.sort(lets);
		int x = 3;
//		out.println(lets.get(1));
		BTree a = new BTree(lets.remove(1));
		while(lets.size()>0){
			if(x<list.length)
				lets.add(list[x++]);
			Collections.sort(lets);
			
			if(lets.size()==3)
			{
//				out.println(lets.get(1));
				a.insert(a.root, lets.remove(1));
			}
			else
			if(lets.size()<=2)
			{
//				out.println(lets.get(0));
				a.insert(a.root, lets.remove(0));
			}
		}
//		a.printPre(a.root);
//		out.println();
//		a.printIn(a.root);
//		out.println();
		int aipl = a.iPL(a.root,0);
		out.print(aipl+" ");
		int diff = bipl-aipl;
		out.println(diff>0?diff+" BETTER":diff<0?-diff+" WORSE":"SAME");
		
		}

	}
}
class BTree {
  static class Node {
    Node left,right;
    char value;
    public Node(char value) {
      this.value = value;
    }
  }
  Node root;
  public BTree() 
  {
  	
  }
  public BTree(char n) 
  {
  	root = new Node(n);
  }
  public void insert(Node node,char value) {
    if (value <= node.value) {
      if (node.left != null) {
        insert(node.left, value);
      } else {
        node.left = new Node(value);
        }
    } else if (value > node.value) {
      if (node.right != null) {
        insert(node.right, value);
      } else {
        node.right = new Node(value);
        }
    }
  }
  int iPL(Node node, int val) {
    int path = val;
    if (node.left != null)
    	path += iPL(node.left, val+1);
    if (node.right != null)
    	path += iPL(node.right, val+1);
    return path;
    }

//preorder output
  public void printPre(Node node) {
    if (node != null) {
      System.out.print("_" + node.value);
      printPre(node.left);
      printPre(node.right);
    }
  }
//preorder output
  public void printIn(Node node) {
    if (node != null) {
      printIn(node.left);
      System.out.print("_" + node.value);
      printIn(node.right);
    }
  }

}
/*
Test Data:
BINARYTREE
RESEARCH
TWOAHEAD
UIL
PROGRAMMINGCONTEST
WRITTENTEST
SUPERCALIFRAGILISTICEXPIALIDOCIOUS
YOU

Test Output:
25 21 4 BETTER
16 16 SAME
19 21 2 WORSE
3 2 1 BETTER
59 58 1 BETTER
33 25 8 BETTER
162 163 1 WORSE
3 2 1 BETTER

*/