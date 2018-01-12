/*
UIL Invitational B, 2016, Huang - Solution

Huang is in a science class studying how tree rings show the age of a tree.  Fascinated with this notion, he decides
to experiment with an exercise that will celebrate this cool aspect of trees by writing a spiral program using the
characters in various tree names that are common to the world.

For example, bamboo is prevalent through many countries in the tropical regions, and is used quite often in constructing
houses and other elaborate structures.  He decides to use the letters in the word BAMBOO to make a 5X5 spiral that looks like this:

BAMBO
BOOBO
MO*AB
AOBMA
BOOBM

Notice how the letters go across the top, then down the right side, across the bottom, then up the left side, spiraling
towards the middle until they stop when they reach the center. The last instance of the word BAMBOO may be partial and not fit
exactly, but Huang is OK with that.  It's just fun to see the patterns. He also decides to put a '*' in the very center of the
grid to mark the center of the spiral pattern

Input: Several names of trees, all in uppercase, no spaces or symbols, each followed by an odd positive integer N (2<N<20) indicating the size of the spiral to be created.

Output: Create and output an NXN spiral grid of letters using the name of the tree.  Output a blank line after each grid.

Assumptions: It is guaranteed that at least one instance of the word will fit into the grid.

Sample input:
BAMBOO 5
BLOODWOOD 7
CEDAR 9

Sample output:
BAMBO
BOOBO
MO*AB
AOBMA
BOOBM

BLOODWO
WOODBLO
DODWOOD
OOO*OOB
OLLBDDL
LBDOOWO
BDOOWDO

CEDARCEDA
EDARCEDAR
CCEDARCRC
RREDARECE
AACR*CDED
DDRADEADA
EEADECRAR
CCRADECRC
RADECRADE

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;

class Huang {
	public static void main(String...she) throws IOException{
		Scanner f = new Scanner(new File("huang.dat"));
		while(f.hasNext())
		{
			String s = f.next();
			int n = f.nextInt();
			char[][]grid=new char[n][n];
			int top=0, left=0, right=n-1, bottom=n-1;
			int let=0;
			int count=0;
			while(count<n*n)
			{
				//across top
				for(int x=left;x<=right;x++){
					grid[top][x]=s.charAt(let);
					count++;
					if(count==n*n)
						grid[top][x]='*';
					let=(let+1)%s.length();
					
				}
				top++;
				//down right side
				for(int x=top;x<=bottom;x++){
					grid[x][right]=s.charAt(let);
					let=(let+1)%s.length();
					count++;
					if(count==n*n)
						grid[x][right]='*';
				}
				right--;
				//across bottom to left
				for(int x=right;x>=left;x--){
					grid[bottom][x]=s.charAt(let);
					let=(let+1)%s.length();
					count++;
					if(count==n*n)
						grid[bottom][x]='*';
				}
				bottom--;
				//up left side
				for(int x=bottom;x>=top;x--){
					grid[x][left]=s.charAt(let);
					let=(let+1)%s.length();
					count++;
					if(count==n*n)
						grid[x][left]='*';
				}
				left++;
			}
			for(char[] g:grid){
				for(char c:g)
					out.print(c);
				out.println();
			}
			out.println();
		}
	}
}

/*
Test data
BAMBOO 5
BLOODWOOD 7
CEDAR 9
PINE 3
HICKORY 19
MAPLE 11
MAHOGANY 7
HACKBERRY 3

Test output
BAMBO
BOOBO
MO*AB
AOBMA
BOOBM

BLOODWO
WOODBLO
DODWOOD
OOO*OOB
OLLBDDL
LBDOOWO
BDOOWDO

CEDARCEDA
EDARCEDAR
CCEDARCRC
RREDARECE
AACR*CDED
DDRADEADA
EEADECRAR
CCRADECRC
RADECRADE

PIN
E*E
NIP

HICKORYHICKORYHICKO
ICKORYHICKORYHICKOR
HCKORYHICKORYHICKRY
YICKORYHICKORYHIOYH
RHIICKORYHICKORCRHI
OYHHYHICKORYHIYKYIC
KRYYRKORYHICKCHOHCK
CORROCYHICKOOKIRIKO
IKOOKIRICKORROCYCOR
HCKKCHOHC*RYYRKHKRY
YICCIYKYIHYHHYOIOYH
RHIIHRCROKCIIHRCRHI
OYHHYOIHYROKCIYKYIC
KRYYRKCIHYROKCHOHCK
CORROKCIHYROKCIRIKO
IKOOKCIHYROKCIHYCOR
HCKCIHYROKCIHYROKRY
YIHYROKCIHYROKCIHYH
ROKCIHYROKCIHYROKCI

MAPLEMAPLEM
EMAPLEMAPLA
LAPLEMAPLEP
PMMAPLEMEML
AEEAPLEAMAE
MLLME*MPAPM
EPPELPALPLA
LAALPAMELEP
PMMELPAMEML
AELPAMELPAE
MELPAMELPAM

MAHOGAN
YMAHOGY
NYMAHAM
ANY*ONA
GANAGYH
OGOHAMO
HAMYNAG

HAC
R*K
REB

*/