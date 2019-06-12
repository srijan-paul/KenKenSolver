import java.util.ArrayList;

public class Ruleset{

	private int total;
	private char operation;
	private ArrayList<Cell> cells ;

	public Ruleset(int t, char op){
		total = t;
		operation = op;
		cells = new ArrayList<Cell>();
	}

	public void addCell(Cell c){
		cells.add(c);
	}

	public boolean contains(Cell c){

		if(cells.contains(c)){
			return true;
		}

		return false;
	}

	public int getTotal(){
		return total;
	}

	public char getOperation(){
		return operation;
	}

	public ArrayList<Cell> getCells(){
		return cells;
	}

	public boolean hasEmptyCells(){
		
		for(Cell c : cells){
			if(c.getValue() == 0){
				return true;
			}
		}

		return false;
	}

	public void print(){

		String str = "";
		for(Cell c : cells){
			str += "("+c.getRow()+","+c.getCol()+")";
		}
		str += "\n" + String.valueOf(operation);
		System.out.println(str);
	}
}
