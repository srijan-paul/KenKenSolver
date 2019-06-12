public class Cell{

	private int row;
	private int col;
	private int value;
	
	public Cell(int r, int c){
		row = r;
		col = c;
		value = 0;
	}

	public void setValue(int i){
		value = i;
	}

	public int getValue(){
		return value;
	}

	public int getRow(){
		return row;
	}

	public int getCol(){
		return col;
	}

}