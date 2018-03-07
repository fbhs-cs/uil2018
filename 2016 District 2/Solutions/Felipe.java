import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Felipe, UIL District 2, 2016
 * @author Owen

Felipe is fascinated with binary search trees, especially with the four different traversals
he just learned in class: inorder, preorder, postorder, and reverse order.

According to the rules he learned in class about building a character tree using a word, he
practices doing this with his friend's names, and especially enjoys using his girlfriend's 
beautiful name, EKATERINA, with whom he is head-over-heels in love!

He starts with the first letter, E, as the root, and then sees that the next letter, K, is
alphabetically after E, so he inserts it as a right node to the E, and then the A as a left
node to the E.  When he gets to the T, he goes right at the E, and then right again at the K, and
proceeds on through the rest of the letters of her name, resulting in the binary search tree
shown below. He decides to allow duplicate letters and slides those to the left as they reach
a matching node.

      E
    /   \
  A       K
 / \     / \
A   E   I   T
           /
          R
         /
        N

He then proceeds to traverse in order, which means start at the top of the tree, going
as deep to the left along each branch, and only outputting a node when reaching the end
of a branch (a leaf node) or outputting a node after its left branch has been completely 
processed.

The inorder traversal (alpha order) of this tree would be: AAEEIKNRT
The preorder traversal (output a node BEFORE traversing either the left or 
right subtrees) would be: EAAEKINRT
Postorder traversal (output after both branches are completely traversed): AEAINRTKE
The reverse order traversal is just the inorder traversal backwards, which Felipe 
thinks about, and then realizes what to do, resulting in: TRNKIEEAA

Input: Several names, each on one line, and each followed by a single character indicating the
traversal to be performed: E(preorder), O(postorder), I(inorder), R(reverse order).
 
Output: The indicated traversal for each name, as shown in the examples.

Sample Input:
EKATERINA I
EKATERINA E
EKATERINA O
EKATERINA R

Sample Output:
AAEEIKNRT
EAAEKITRN
AEAINRTKE
TRNKIEEAA

 */
public class Felipe {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("felipe.dat"));
		while(f.hasNext()) {
		String s=f.next();
		String t = f.next();
		TreeNode a = null;
			for(int x=0;x<s.length();x++)			{
				char c=s.charAt(x);
				a=TreeNode.addNode(c,a);
			}
			switch(t)			{
				case "E":TreeNode.preTrav(a);break;
				case "I":TreeNode.inTrav(a);break;
				case "O":TreeNode.postTrav(a);break;
				case "R":TreeNode.revTrav(a);break;
			}
			out.println();
		}
	}
}
class TreeNode
{
	char data;
	TreeNode left, right;

	TreeNode(char l){
		this(l,null,null);
	}
	TreeNode(char d,TreeNode l, TreeNode r)	{
		data = d;
		left = l;
		right = r;
	}
	static TreeNode addNode(char c,TreeNode t)	{
		if(t==null)
			t=new TreeNode(c,null,null);
		else
		if(c<=t.data)
			t.left=addNode(c,t.left);
		else
			t.right=addNode(c,t.right);
		return t;
	}
	static void preTrav(TreeNode r)	{
		if(r!=null)		{
			out.print(r.data);
			preTrav(r.left);
			preTrav(r.right);
		}
	}
	static void inTrav(TreeNode r)	{
		if(r!=null)		{
			inTrav(r.left);
			out.print(r.data);
			inTrav(r.right);
		}
	}
	static void postTrav(TreeNode r)	{
		if(r!=null)		{
			postTrav(r.left);
			postTrav(r.right);
			out.print(r.data);
		}
	}
	static void revTrav(TreeNode r)	{
		if(r!=null)		{
			revTrav(r.right);
			out.print(r.data);
			revTrav(r.left);
		}
	}

}
/*
EKATERINA I
EKATERINA E
EKATERINA O
EKATERINA R
AIGUO O
DAISUKE I
HEATHER R
ROSANNAROSANNADANNA E
JAKUB R
MADAM I
TED O
MARCO R

AAEEIKNRT
EAAEKITRN
AEAINRTKE
TRNKIEEAA
GOUIA
ADEIKSU
TRHHEEA
ROAAAAAANNNNDNNORSS
UKJBA
AADMM
DET
ROMCA

*/