/*
UIL 2016 Invitational A, Program Eight
Linked

Wikipedia articles often have links to other Wikipedia articles for the objects that 
already have articles. We can use this direct linking to deduce how related two Wikipedia 
articles could be. To say that two articles, a and b are related means to say that there 
exists a series of links you could click that could get you to the same article c starting from 
article a and article b. Furthermore, the strength of this relationship is determined by the smallest 
number of cumulative clicks it takes to get from a to this mutual, shared article plus the number of 
clicks it took from b.

More concretely, imagine we had these Wikipedia articles, where the @ sign indicates a link from 
one article to another, and before the : represents the title of the article. 

black_lab: A dog_breed@ that has black@ fur. 
Jack_Russell: A hyper dog_breed@ that is often used to assist when hunting.
black: A color.
dog_breed: A phenotype of a dog@.
cat: A small mammal@ that the internet loves.
dog: A larger mammal@ that is a common household pet.
mammal: An animal@ with fur and births its young.
animal: A living organism that eats organic matter.
carrot: A yummy orange plant.

In this example, black_lab and Jack_Russell articles are related because they both link to the dog_breed 
article with one click from black_lab and one click from Jack_Russell, so 2 cumulative clicks. By the same 
situation, cat and dog are related because they both link to mammal with one click from cat and one click 
dog, so again, 2 cumulative clicks. Now, black_lab and cat are related because they both link to mammal, 
3 clicks from black_lab (once on dog_breed, once on dog, then to mammal) and then one click from cat, so 
4 cumulative clicks. There is a notion of an article being linked to itself which implies that black_lab 
is related to dog_breed by 1 cumulative click (1 click from black_lab and 0 clicks from dog_breed). 
Furthermore, this means that Jack_Russell is related to animal by 4 cumulative clicks (4 clicks - Jack_Russell 
to dog_breed to dog to mammal to animal + 0 clicks from animal). Lastly, carrot and cat are not related 
because there are no links that can be clicked starting from these two articles to end up at the same 
article (because carrot is connected to nothing and nothing is connected to carrot).

Of the article pairs we just analyzed (black_lab - Jack_Russell), (cat - dog), (black_lab - cat), 
(black_lab - dog_breed), (Jack_Russell - animal), and (carrot - cat): (black_lab - dog_breed) is the 
strongest relationship because it has the fewest cumulative clicks. (carrot - cat) is the weakest 
because it has the highest number of cumulative clicks (infinite since they are not related).

Now, using these definitions of related and cumulative clicks, given a list of article name pairs, put 
them in order from strongest relationship to weakest relationship.

Input: The first line will have an integer indicating the number of data sets to follow. In each data 
set the first line will contain an integer indicating the number of Wikipedia articles in this data set. 
Each article will take up one line, starting with a single string as its title, followed by a colon. All 
words in the article ending with @ are considered linked to another article as denoted by the 
title. After the articles there will be another integer indicating the number of article pairs to be 
analyzed. Each article pair will have two strings with the titles of the two articles to be analyzed.

For example, "dog_breed@" appearing in a sentence means that there is exists an article with the title, 
"dog_breed", as you can see in the sample data below.  The two strings for each article listing include 
the title and then a brief description, separated by ": ". The description will have zero or more references
as described above. For instance, the first data listing below has two references, "dog_breed@" and "black@".
The listing for "black" has no references at all.

Output: The given list of article pairs reordered from strongest relationship to weakest relationship in 
the given Wikipedia article configuration. If more than one pair have the same strength relationship, 
order them alphabetically. Output a blank line between each data set.

Assumptions: All links will exist in the data set. All article sets will have at least 2 articles. 
In an article pair the two articles will be different. All article titles will be unique. All articles 
will have a title and content.

Sample Input:
2
9
black_lab: A dog_breed@ that has black@ fur. 
Jack_Russell: A hyper dog_breed@ that is often used to assist when hunting.
black: A color.
dog_breed: A phenotype of a dog@.
cat: A small mammal@ that the internet loves.
dog: A larger mammal@ that is a common household pet.
mammal: An animal@ with fur and births its young.
animal: A living organism that eats organic matter.
carrot: A yummy orange plant.
6
black_lab  Jack_Russell 
cat  dog 
black_lab  cat 
black_lab  dog_breed 
Jack_Russell  animal 
carrot cat 
10
a: b@
b: c@
c: d@
d: e@
e: f@
f: g@
g: h@
h: i@
i: j@
j: nothing
5
a b
a c
a d
a j
i j


Sample Output:
black_lab dog_breed
black_lab Jack_Russell
cat dog
Jack_Russell animal
black_lab cat
carrot cat

a b
i j
a c
a d
a j


Input:
6
9
black_lab: A dog_breed@ that has black@ fur. 
Jack_Russell: A hyper dog_breed@ that is often used to assist when hunting.
black: A color.
dog_breed: A phenotype of a dog@.
cat: A small mammal@ that the internet loves.
dog: A larger mammal@ that is a common household pet.
mammal: An animal@ with fur and births its young.
animal: A living organism that eats organic matter.
carrot: A yummy orange plant.
6
black_lab  Jack_Russell 
cat  dog 
black_lab  cat 
black_lab  dog_breed 
Jack_Russell  animal 
carrot cat 
10
a: b@
b: c@
c: d@
d: e@
e: f@
f: g@
g: h@
h: i@
i: j@
j: nothing
5
a b
a c
a d
a j
i j
16
a: b@ c@
b: d@ e@ 
c: f@ g@
d: h@ i@
e: j@ k@
f: l@ m@
g: n@ o@
h: nothing
i: nothing
j: nothing
k: nothing
l: nothing
m: nothing
n: nothing
o: nothing
q: nothing
4
a b
o h
f g
q g
2
a: nothing
b: nothing
1
a b
5
a: b@ c@ d@ e@
b: a@ c@ d@ e@
c: a@ b@ d@ e@
d: a@ b@ c@ e@
e: a@ b@ c@ d@
5
a b
b d
c e
d e
a e 
16
a: nothing
b: a@
c: a@
d: b@
e: b@
f: c@
g: c@
h: d@
i: d@
j: e@
k: e@
l: f@
m: f@
n: g@
o: g@
q: nothing
4
a b
o h
f g
q g

Output:
black_lab dog_breed
black_lab Jack_Russell
cat dog
Jack_Russell animal
black_lab cat
carrot cat

a b
i j
a c
a d
a j

a b
f g
o h
q g

a b

a b
a e
b d
c e
d e

a b
f g
o h
q g


*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 
 @author sno
 
 Given n articles with well notated links, and given m specific article pairs j and k that 
 exist in n, put them in order from most related pairs to lease related pair where related
 is inversely proportional to the number of cummulative clicks from q and t to a shared article. 

Synopsis of solution:

First build a directional graph from input
Reverse all the directional edges (before this was a graph of which articles link to which other articles, 
now it is a graph of which articles share this article commonly) [non-trivial algo]

To calculate how strong the relationship is:
at each node, q, in the reversed graph, find all the nodes that have shortest path length n away from q 
and all the nodes that have shortest path length m away from q (where n and m are between 0 and 
#numberOfNodesInGraph) [dijkstra's algo]

Now, these nodes that are n away (call them a) and these nodes that are m away (call them b) are all the 
articles pairs (one from set a and one from set b) that have "cumulative click" value of (n + m) that 
share q as their common article

Record this value for these two nodes, if we already have a value for these two nodes, chose the larger one, 
because it means that is the shorter path.
Now for each given article pair, put them in a list and sort them.
 *
 */
public class A_Eight {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("a_eight.dat"));
		int numDataSets = f.nextInt();f.nextLine();
		while(numDataSets-- > 0) {
			Relatedness.allRelatedness.clear();
			ArrayList<Node> graph = new ArrayList<Node>();
			HashMap<String, Node> nameToNode = new HashMap<String, Node>();
			HashMap<Node, ArrayList<String>> linkDataMapper = new HashMap<Node, ArrayList<String>>();
			int numArticles = f.nextInt();f.nextLine();
			while(numArticles-- > 0) {
				String article = f.nextLine();
				//stores which other articles this article references
				ArrayList<String> links = new ArrayList<String>();
				String title = parse(article, links);
				Node node = new Node(title);
				graph.add(node);
				nameToNode.put(title, node);
				linkDataMapper.put(node, links);
			}
			
			for(Node node: graph) {
				node.addLink(node);
				for(String articleName: linkDataMapper.get(node)) {
					node.addLink(nameToNode.get(articleName));
				}
			}
			
			//System.out.println(graph); // At this point graph is fully populated
			ArrayList<Node> reversedGraph = reverseGraph(graph); // and now its links go the other way
			HashMap<String, Node> nameToNewNode = new HashMap<String, Node>();
			for(Node node: reversedGraph) {
				nameToNewNode.put(node.title, node);
			}
			//System.out.println(reversedGraph);
			Relatedness.calculateRelatedness(reversedGraph);
			
			// get the set into sorted order
			Relatedness [] sortRelationships = new Relatedness[Relatedness.allRelatedness.size()];
			sortRelationships = Relatedness.allRelatedness.toArray(sortRelationships);
			Arrays.sort(sortRelationships);
			/*for(Relatedness r: sortRelationships) {
				System.out.print(r + ", ");
			}*/
			
			int numQueries = f.nextInt();f.nextLine();
			ArrayList<Relatedness> finalOutput = new ArrayList<Relatedness>();
			while(numQueries-- > 0) {
				String queryA = f.next();
				String queryB = f.next();
				Node queryNodeA = nameToNewNode.get(queryA);
				Node queryNodeB = nameToNewNode.get(queryB);
				boolean exists = false;
				for(Relatedness r: sortRelationships) {
					if(r.a == queryNodeA && r.b == queryNodeB) {
						finalOutput.add(r);
						exists = true;
						break; // there better be only one
					}
				}
				// no relationship exists
				if(!exists) {
					finalOutput.add(new Relatedness(queryNodeA, queryNodeB));
				}
			}
			Collections.sort(finalOutput);
			for(Relatedness r: finalOutput) {
				System.out.println(r);
			}
			System.out.println();
		}
	}
	
	// Returns the title of the article and fills the links found in the article.
	public static String parse(String article, ArrayList<String> links) {
		String title = article.substring(0, article.indexOf(':'));
		Scanner words = new Scanner(article.substring(article.indexOf(':')+1));
		
		//finds the links in the article
		while(words.hasNext()) {
			String word = words.next();
			if (word.indexOf('@') > -1) {
				links.add(word.substring(0, word.indexOf('@')));
			}
		}
		return title;
	}
	// Returns the given graph with all the directed edges reversed
	public static ArrayList<Node> reverseGraph(ArrayList<Node> graph) {
		ArrayList<Node> reversedGraph = new ArrayList<Node>();
		for(Node node: graph) {
			reversedGraph.add(new Node(node.title));
		}
		
		for(Node node: graph) {
			for(Node linkedNode: node.links) {
				for(Node foundNode: reversedGraph) {
					if(foundNode.title == linkedNode.title) {
						for(Node foundTitleNode: reversedGraph) {
							if(foundTitleNode.title == node.title) {
								foundNode.addLink(foundTitleNode);
							}
						}
					}
				}
			}
		}
		
		return reversedGraph;
	}
	// Returns all the nodes that are distance away from the source node.
	public static ArrayList<Node> getNodesInLevel(ArrayList<Node> graph, Node source, int distance) {		
		HashMap<Node, Integer> distances = new HashMap<Node, Integer>();
		distances.put(source, 0);
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(source);
		HashSet<Node> visited = new HashSet<Node>();
		
		// run dijikstra to find out the shortest distances to all nodes from this node
		while(queue.size() > 0) {
			Node node = queue.removeFirst();
			if(visited.contains(node)) {
				continue;
			}
			for(Node linkedNode: node.links) {
				if(distances.containsKey(linkedNode)) {
					distances.put(linkedNode, distances.get(linkedNode) > distances.get(node) + 1 ? distances.get(node) + 1: distances.get(linkedNode));
				} else {
					distances.put(linkedNode, distances.get(node) + 1);
				}
				queue.addLast(linkedNode);
			}
			visited.add(node);
		}
		
		ArrayList<Node> nodesInLevel = new ArrayList<Node>();
		for(Node node: distances.keySet()) {
			if(distances.get(node) == distance) {
				nodesInLevel.add(node);
			}
		}
		return nodesInLevel;
	}
}
/**
 * Node structure to hold the links and the title of this article.
 * */
class Node {
	public ArrayList<Node> links;
	public String title;
	public Node(String title) {
		this.title = title;
		this.links = new ArrayList<Node>();
	}
	public Node(String title, ArrayList<Node> links) {
		this.title = title;
		this.links = links;
	}
	public void addLink(Node node) {
		links.add(node);
	}
	
	// for debugging
	@Override
	public String toString() {
		String output = title + ": (";
		for(Node node: links) {
			output += node.title + ", ";
		}
		output = output.substring(0, output.length()-2) +  ")";
		return output;
	}
}
/**
 * Stores nodes and how related they are. Using a heuristic stored in relatednessScore. 
 */
class Relatedness implements Comparable<Relatedness>{
	public double relatednessScore = 0.0;
	public Node a;
	public Node b;
	public static HashSet<Relatedness> allRelatedness = new HashSet<Relatedness>();
	public Relatedness(Node a, Node b) {
		this.a = a;
		this.b = b;
	}
	// compare by score, if score is the same then put in order alphabetically.
	@Override
	public int compareTo(Relatedness r) {
		int comparisonByScore = ((Double) r.relatednessScore).compareTo(this.relatednessScore);
		if(comparisonByScore == 0) {
			int comparisonAlphabetically = this.a.title.compareTo(r.a.title);
			if(comparisonAlphabetically == 0) {
				return this.b.title.compareTo(r.b.title);
			}
			return comparisonAlphabetically;
		}
		return comparisonByScore;
	}
	@Override
	public boolean equals(Object relatedness) {
		Relatedness r = (Relatedness) relatedness;
		return this.a == r.a && this.b == r.b;
	}
	@Override
	public int hashCode() {
		return this.a.hashCode() + this.b.hashCode();
	}
	@Override
	public String toString() {
		return this.a.title + " " + this.b.title + " ";
	}
	// Finds the relatedness score corresponding to these two nodes.
	public static Relatedness get(Node a, Node b) {
		for(Relatedness r: allRelatedness) {
			if(r.a == a && r.b == b){
				return r;
			}
		}
		return null;
	}
	// Adds the highest score found either the one we already have or the new one we have just find.
	public static void add(Node a, Node b, double val) {
		if (get(a, b) == null) {
			allRelatedness.add(new Relatedness(a, b));
		}
		Relatedness r = get(a, b);
		r.relatednessScore = Math.max(val, r.relatednessScore);
	}
	/*
	 * Determines relatedness for all the pair of nodes in the given graph. This relatedness
	 * is determined by two nodes sharing a common descendant scaled by the path length they 
	 * to travel from one to other through the common descendant. 
	 */
	public static void calculateRelatedness(ArrayList<Node> graph) {		
		for(Node node: graph) {
			for(int i = 0; i < graph.size(); i++) {
				for(int j = 0; j < graph.size(); j++) {
					ArrayList<Node> nodesInLevelA = Linked.getNodesInLevel(graph, node, i);
					ArrayList<Node> nodesInLevelB = Linked.getNodesInLevel(graph, node, j);
					for(Node a: nodesInLevelA) {
						for(Node b: nodesInLevelB) {
							// it is uninteresting that a node is most closely related to itself
							if(a == b) {
								continue;
							}	
							// the actual value used here doesn't matter just that it scales inversly 
							// with path distance through the common descendant
							Relatedness.add(a, b, 1.0/(Math.pow(2,i+j))); 
						}
					}
				}
			}
		}
	}
}