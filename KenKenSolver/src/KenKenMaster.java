import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;



public class KenKenMaster{

	private Cell[][] board;
	private ArrayList<Ruleset> rules;


	public KenKenMaster(){
		rules = new ArrayList<Ruleset>();
	}

	public void parseBoard(File f){

		try{

			Scanner sc = new Scanner(f);
			int currLine = 0;
			int n = -1;

			while(sc.hasNextLine()){
				String next = sc.nextLine();
				currLine ++;
			
				String [] nextArr = next.split(" ");
				
				if(currLine == 1){
					n = Integer.valueOf(next);
					board = new Cell[n][n];

					for(int i = 0; i < n ; i++){
						
						for(int j = 0; j < n; j ++){
							board[i][j] = new Cell(i, j);

						}
					}
				
				}else{

					int row = -1;
					int col = - 1;
					int num = Integer.valueOf(nextArr[0]);
					
					char operation = nextArr[1].charAt(0);

					Ruleset rule = new Ruleset(num, operation);

					for(int i = 2 ; i < nextArr.length; i++){
						
						if(i%2 == 0){
							row = Integer.valueOf(nextArr[i]);
						}else{
							
							col = Integer.valueOf(nextArr[i]);							
							
							if(operation == '#'){
								board[row][col].setValue(num);		
							}else{
								rule.addCell(board[row][col]);
							}

						}//close if-else
	
					}	

					if(operation != '#'){rules.add(rule);}


				}//close if-else
			
			}//close while
		
		}catch(Exception e){

		}

	}//close method

	public void print(){
		int n = board.length;
		for(int i = 0; i < n ; i++){
			for(int j = 0 ; j < n; j++){
				System.out.print( " " + board[i][j].getValue());
			}
			System.out.println("");
		}
		System.out.println("");
	}//close method

	public boolean solve(Cell[][] board){

		int n = board.length;
		int row = -1;
		int col = -1;

		//check if there are empty cells, if none return true

		for(Ruleset rule : rules){

			if(!rule.hasEmptyCells()){

				
				switch(rule.getOperation()){
					case '+' :
						int sum = 0;

						for(Cell c : rule.getCells()){
							sum += c.getValue();
						}


						if(sum != rule.getTotal()){
							return false;
						}

						break;

					case '-' :
						
						int difference = 0;
						for(Cell c : rule.getCells()){
							difference = Math.abs(difference - c.getValue());
						}

						if(difference != rule.getTotal()){
							return false;
						}		

						break;

					case '*' :

						int product = 1;
						for(Cell c : rule.getCells()){
							product *= c.getValue();
						}

						if(product != rule.getTotal()){
							return false;
						}	
						
						break;

					case '/' :
						
						float total = 1;
						int temp = 0;
						for(Cell c : rule.getCells()){
							 temp = c.getValue();
							if(temp > total){
								total = (float)temp/total;
							}else if(temp < total){
								total = total/temp;
							}
						}

						if(total != rule.getTotal()){
							return false;
						}
						break;


				}//close switch
			

			}//close empty check
			
		}

		boolean isEmpty = false;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(board[i][j].getValue() == 0){
					row = i;
					col = j;

					isEmpty = true;
					break;
				}
			}

			if(isEmpty){
				break;
			}	
		}
		

		if(!isEmpty){
			return true;
		}

		//if there is an empty cell, take that as the current cell and then try values one by one

		for(int i = 0 ; i < 10 ; i++){
			if(isSafe(board, row, col, i)){
				board[row][col].setValue(i);

				if(solve(board)){
					return true;
				}else{
					board[row][col].setValue(0);
				}
			}
		}

		return false;
	
	}//close method

	public boolean isSafe(Cell[][] board, int row, int col, int value){
		
		int n = board.length;
		//check for row-column clashes

		for(int i = 0 ; i < n ; i++){
			if(board[row][i].getValue() == value){
				return false;
			}

			if(board[i][col].getValue() == value){
				return false;
			}
		}
		//check for Ruleset clashes

		
		

		return true;
	}

	public Cell[][] getBoard(){
		return board;
	}

}//close method