package maps_questions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSuduko {

public static boolean isValidSudukoArrayListOfMap(char[][] board) {		
		
		List<Map<Integer, Integer>> mapRow = new ArrayList<Map<Integer,Integer>>();
		List<Map<Integer, Integer>> mapCol = new ArrayList<Map<Integer, Integer>>();
		List<Map<Integer, Integer>> mapBox = new ArrayList<Map<Integer, Integer>>();
		
		for (int i = 0; i < 9; i++) {
			mapRow.add(i, new HashMap<Integer, Integer>());
			mapCol.add(i, new HashMap<Integer, Integer>());
			mapBox.add(i, new HashMap<Integer, Integer>());			
		}
		
		for(int i =0; i<9; i++) {
			for(int j= 0; j< 9 ; j++) {
				char num = board[i][j];
				System.out.println("num: " + num);
				int boxId = (i/3)*3 + j/3;
				System.out.println("boxId= " + boxId);
				
				if (num != '.') {
					int n = num - '0';
					//System.out.println("n: " + n);					
					mapRow.get(i).put(n, mapRow.get(i).getOrDefault(n, 0)+1);
					mapCol.get(j).put(n, mapCol.get(j).getOrDefault(n, 0)+1);
					mapBox.get(boxId).put(n, mapBox.get(boxId).getOrDefault(n, 0)+1);
					//check validity
					if((mapRow.get(i).get(n) >1) || (mapCol.get(j).get(n) >1) || (mapBox.get(boxId).get(n) >1)) {
						System.out.println("one of rule failed.");
						return false;
					}
				}
				
			}
		}		
		return true;
	}

	public static boolean isValidSudukoArrayOfMap(char[][] board) {
		
		Map<Integer, Integer>[] mapRow = new HashMap[9];
		Map<Integer, Integer>[] mapCol = new HashMap[9];
		Map<Integer, Integer>[] mapBox = new HashMap[9];
		
		for (int i = 0; i < 9; i++) {
			mapRow[i] = new HashMap<Integer, Integer>();
			mapCol[i] = new HashMap<Integer, Integer>();
			mapBox[i] = new HashMap<Integer, Integer>();
		}
		
		
		for(int i =0; i<9; i++) {
			for(int j= 0; j< 9 ; j++) {
				char num = board[i][j];
				System.out.println("num: " + num);
				int boxId = (i/3)*3 + j/3;
				System.out.println("boxId= " + boxId);
				
				if (num != '.') {
					int n = num - '0';
					//System.out.println("n: " + n);
					
					//System.out.println("i and j : " + i +" " + j);
					
					mapRow[i].put(n, mapRow[i].getOrDefault(n, 0)+1);
					mapCol[j].put(n, mapCol[j].getOrDefault(n, 0)+1);
					mapBox[boxId].put(n, mapBox[boxId].getOrDefault(n, 0)+1);
					
					/*System.out.println("(mapRow[i].get(n): " + (mapRow[i].get(n)));
					System.out.println("(mapCol[j].get(n): " + (mapCol[j].get(n)));
					System.out.println("(mapBox[boxId].get(n): " + (mapBox[boxId].get(n)));*/
					//check validity
					if((mapRow[i].get(n) > 1) || (mapCol[j].get(n) > 1) ||(mapBox[boxId].get(n) > 1)) {
						System.out.println("one of rule failed.");
						return false;
					}
				}
				
			}
		}		
		return true;
	}
	public static void main(String args[]) {
		
		/*char[][] board = { 
				{'5','3','.','.','7','.','.','.','.'},
				{'.','.','.','1','.','5','.','.','.','.'},
				{'1','.','.','2','.','.','.','.','.','.'},
				{'.','.','.','3','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','3','.','.','.','.'},
				
		};*/
		
		char board[][] = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                { '.', '.', '.', '.', '8', '.', '.', '7', '0' } 
                }; 
		
		System.out.println("isValid suduko: " + isValidSudukoArrayListOfMap(board));
		
	}
}
