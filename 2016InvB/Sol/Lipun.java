/*
UIL Invitational B, 2016, Lipun - Solution

Lipun has just learned some theory regarding binary search trees, specifically about depth, leaf nodes, internal and external nodes and path length.
He needs some help from you writing a program that will build a binary search tree from some text data, and then report all of these new concepts.
He wants to take any word, like INVITATIONAL, build a binary search tree in alpha order, allowing duplicate letters, which will be
inserted to the left when the duplicate is encountered, and then calculate and report the following:

Depth - distance from root to farthest leaf node
Number of Leaf Nodes - number of nodes with no children
Number of External Nodes - number of potential nodes
Internal Path Length - sum of all distances from each node to the root
External Path Length - sum of all distances from potential nodes to the root

For example, the tree for the word INVITATIONAL is:
        I
      /   \
    I      N
   /      /  \
  A       N   V
 / \     /   /
A   I   L   T
           / 
          T
         /    
        O

The expected output is: 5 4 13 29 53

The depth of this tree is 5, since the letter "O" is 5 levels away from the root.

There are four leaf nodes - A, I, L and O.

There are 13 locations a new node could be inserted, AKA, external nodes.  The letters I on level 1, 
N and V on level 2, and both Ts have one available pointer for a new node, and then all four leaf nodes
each have two available pointers, for a total of 13 external nodes.

The internal path length is the sum of the distances of all internal nodes to the root.  The nodes I and N are at level 1, 
and therefore are each 1 level away from the root, for an internal path length so far of 2. A, N and V are at level 2, for 
a total IPL of 6, A, I, L and T are level 3, IPL of 12, and then T and O add 4 and 5 to the sum, for a grand internal path length total 
of 2+6+12+4+5 = 29.

The external path length is calculated from the 13 external nodes, 1 at level 2 (right child pointer from the I), 
2 each from level 3 (both right child pointers for N and V) for a total EPL of 6, 7 each at level 4 (both pointers from A, I, and L, plus the right child pointer for T) for a level 4 EPL total of 28, plus a level 5 right child pointer from T, and two level 6 pointers 
from O. The total external path length is: 2+6+28+5+12 = 53

Input: Several uppercase words, each on one line.

Output: Five integers for each word, indicating tree depth, number of leaf nodes, number of external nodes, internal path length, and external path length.

Sample input:
INVITATIONAL
UIL
DISTRICT

Sample output:
5 4 13 29 53
2 1 4 3 9
4 4 9 16 32
*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
class BST {
	public static  Node root;
	public BST(){
		root = null;
	}
	public void insert(char id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<=current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public int depth(Node current){
		if(current==null)
			return 0;
		int left=0;
		int right=0;
		if(current.left!=null)
			left=depth(current.left)+1;
		if(current.right!=null)
			right=depth(current.right)+1;
		return Math.max(left,right);
	}
	public int numLeafs(Node current){
		
		if(current==null)
			return 0;
		if(current.left==null&&current.right==null){
			return 1;
		}
		return numLeafs(current.left)+numLeafs(current.right);
	}
	public int inPathLen(Node cur, int level){
		if(cur==null)
			return 0;
		return level+inPathLen(cur.left,level+1)+inPathLen(cur.right,level+1);
	}
	public int exPathLen(Node cur, int level){
		if(cur==null)
			return level;
		return exPathLen(cur.left,level+1)+exPathLen(cur.right,level+1);
	}
	public int exNodes(Node cur){
		if(cur==null)
			return 1;
		return exNodes(cur.left)+exNodes(cur.right);
	}
	public static void main(String...bst) throws IOException{
		Scanner f = new Scanner(new File("lipun.dat"));
		while(f.hasNext())
		{
			BST b = new BST();
			String s = f.next();
			for(int x=0;x<s.length();x++)
				b.insert(s.charAt(x));
			out.print(b.depth(b.root));
			out.print(" "+b.numLeafs(b.root));
			out.print(" "+b.exNodes(b.root));
			out.print(" "+b.inPathLen(b.root,0));
			out.println(" "+b.exPathLen(b.root,0));
		}
	}
}
class Node{
	char data;
	Node right,left;
	Node(char l){
		data=l;
		right=null;
		left=null;
	}
}

/*
Test data
INVITATIONAL
UIL
DISTRICT
REGION
STATE
CHAMPION
TEAM
PROGRAMMINGCONTESTSAREFUN

Test output
5 4 13 29 53
2 1 4 3 9
4 4 9 16 32
5 1 7 15 27
2 2 6 6 16
5 3 9 19 35
2 2 5 5 13
7 10 26 93 143

*/