
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 * @author sno
 * 
 * Tile Bonanza
 * Given a scene of randomly distributed black and white tiles, you get positive
 * points two squares of like color are adjacent and half negative points if two
 * squares of opposite color are adjacent. Given the number of allowed moves, 
 * how should the tiles be redistributed to get the maxium score. 
 * 
 *
 */
public class Francisco {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("francisco.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-- > 0) {
			int turns = f.nextInt();f.nextLine();
			int size = f.nextInt();f.nextLine();
			int [][] input = new int[size][size];
			for(int i = 0; i < size; i ++) {
				for(int j = 0; j < size; j ++) {
					input[i][j] = f.nextInt();
				}
			}
			
			Board b = new Board(input);
			
			// Reset default class vars
			maxScore = Integer.MIN_VALUE;
			solution = new HashSet<Board>();
			
			tryMoves(b, turns, 1);
			System.out.println("MAXIMUM SCORE: " + (int)maxScore);
			if(solution.size() > 1) {
				System.out.println("THERE ARE " + solution.size() + " OPTIMAL BOARDS.");
				System.out.println();
			} else {
				System.out.println("THERE IS " + solution.size() + " OPTIMAL BOARD.");
				for(Board q: solution) {
					System.out.println(q);
				}
			}
		}
	}
	
	public static double maxScore = Double.MIN_VALUE;
	public static HashSet<Board> solution = new HashSet<Board>();
	
	public static void tryMoves(Board b, int maxDepth, int curDepth) {
		if(curDepth > maxDepth) {
			return;
		}
		for(int i = 0; i < b.squares.length; i++) {
			for(int j = 0; j < b.squares.length; j++) {
				for(int k = -1; k <= 1; k ++) {
					for(int l = -1; l <= 1; l++) {
						Board c = b.copy();
						int status = c.move(i,j,k,l);
						if(status != 0) {
							continue;
						}
						if (c.score() > maxScore) {
							maxScore = c.score();
							solution = new HashSet<Board>();
						}
						if(c.score() == maxScore) {
							//implement the behavior of a set
							boolean contains = false;
							for(Board q: solution) {
								if(q.equals(c)) {
									contains = true;
								}
							}
							
							if(!contains) {
								solution.add(c);
							}
						}
						tryMoves(c, maxDepth, curDepth+1);
					}
				}
			}
		}
	}

}

class Board {
	//0 - empty, 1 - black, 2 - white
	public int [][] squares;
	public int moves = 0;
	public Board(int size) {
		squares = new int[size][size];
	}
	public Board(int [][] board) {
		squares = board;
	}
	
	public int move(int r, int c, int dr, int dc) {
		if(this.squares[r][c] == 0) {
			//System.out.println("NO PIECE HERE TO MOVE! r: " + r + " c: " + c);
			return 1;
		}
		if(r + dr < 0 || r + dr >= squares.length) {
			//System.out.println("R OUT OF BOUNDS r: " + r + " dr: " + dr);
			return 1;
		}
		if(c + dc < 0 || c + dc >= squares.length) {
			//System.out.println("C OUT OF BOUNDS c: " + c + " dc: " + dc);
			return 1;
		}
		if(this.squares[r+dr][c+dc] != 0) {
			//System.out.println("ALREADY A PIECE HERE! r+dr: " + (r+dr) + " c+dc: " + (c+dc));
			return 1;
		}
		
		int piece = this.squares[r][c];
		this.squares[r][c] = 0;
		this.squares[r+dr][c+dc] = piece;
		return 0;
	}
	
	public boolean equals(Board b) {
		for(int i = 0; i < this.squares.length; i++) {
			for(int j = 0; j < this.squares.length; j++) {
				if(this.squares[i][j] != b.squares[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public double score() {
		double score = 0.0;
		for(int i = 0; i < this.squares.length; i++) {
			for(int j = 0; j < this.squares.length; j++) {
				int centerPiece = this.squares[i][j];
				for(int k = -1; k <= 1; k ++) {
					for(int l = -1; l <= 1; l++) {
						if(k == 0 && l == 0 || centerPiece == 0) {
							continue;
						}
						try {
							if(this.squares[i+k][j+l] == centerPiece) {
								score += 10;
							}
							if(this.squares[i+k][j+l] != 0 && this.squares[i+k][j+l] != centerPiece) {
								score -= 5;
							}
						} catch (Exception e) {
						}
						
					}
				}
			}
		}
		return score;
	}
	
	public Board copy() {
		int [][] copiedBoard = new int[squares.length][squares.length];
		for(int i = 0; i < this.squares.length; i++) {
			for(int j = 0; j < this.squares.length; j++) {
				copiedBoard[i][j] = this.squares[i][j];
			}
		}
		return new Board(copiedBoard);
	}
	
	public String toString() {
		String out = "";
		for(int i = 0; i < this.squares.length; i++) {
			for(int j = 0; j < this.squares.length; j++) {
				out+=this.squares[i][j] + " ";
			}
			out+="\n";
		}
		return out;
	}
}
/*
Test data:
9
1
3
1 0 0 
0 2 0 
2 0 1
1
3
0 0 1
0 2 1
2 0 0
3
5
0 0 1 0 2
0 2 0 2 0
1 0 1 0 1
0 2 0 2 0
0 0 1 0 0
1
3
0 0 1
0 2 0
0 0 0
2
6
0 0 0 1 1 1
0 0 0 1 1 1
0 0 0 1 1 1
2 2 2 0 0 0
2 2 2 0 0 0
2 2 2 0 0 0
3
3
1 2 1
2 1 2
1 2 0
2
4
0 0 0 0
1 0 0 1
2 0 0 2
0 0 0 0
1
10
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 0 1 1 1
2 2 2 2 2 2 1 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
4
4
0 0 1 2
0 0 2 1
1 2 0 0
2 1 0 0

Test output:
MAXIMUM SCORE: 10
THERE ARE 2 OPTIMAL BOARDS.

MAXIMUM SCORE: 40
THERE IS 1 OPTIMAL BOARD.
0 0 1
2 0 1
2 0 0

MAXIMUM SCORE: 70
THERE ARE 8 OPTIMAL BOARDS.

MAXIMUM SCORE: 0
THERE ARE 5 OPTIMAL BOARDS.

MAXIMUM SCORE: 790
THERE IS 1 OPTIMAL BOARD.
0 0 0 1 1 1
0 0 0 1 1 1
0 0 0 1 1 1
2 2 2 0 0 0
2 2 2 0 0 0
2 2 2 0 0 0

MAXIMUM SCORE: 70
THERE ARE 4 OPTIMAL BOARDS.

MAXIMUM SCORE: 20
THERE ARE 2 OPTIMAL BOARDS.

MAXIMUM SCORE: 5930
THERE IS 1 OPTIMAL BOARD.
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
2 2 2 2 2 2 0 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2

MAXIMUM SCORE: 90
THERE ARE 4 OPTIMAL BOARDS.
*/