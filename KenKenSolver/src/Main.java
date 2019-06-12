import java.io.File;

public class Main{
	public static void main(String[] args) {

		File board = new File("test boards/board5.txt");
		KenKenMaster ken = new KenKenMaster();
		ken.parseBoard(board);
		ken.print();
		if(ken.solve(ken.getBoard())){
			ken.print();
		}
	
	}


}
