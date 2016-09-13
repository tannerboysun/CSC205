import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ElementQuiz{



	
	public static void main(String[] args) throws IOException{
		
		/* Variable Declarations */
		Scanner ans = new Scanner(System.in);
		boolean error = false;
		int symPos = 3;
		int namePos = 3;
		int loadDataColCount = 0;

		System.out.println("---------------------------------------");
		System.out.println("Welcome to the Chemistry Learning Tool!");
		System.out.println("---------------------------------------");

		do {
			System.out.println("Options: \n S - Get Tested on Symbols \n N - Get Tested on Names\n");
			
			/* Local Variable Initialization */
			System.out.print("S/N | ");
			String response = ans.nextLine();
			char option = response.toUpperCase().charAt(0);


			switch(option){
			
				case 'S':
					symPos = 1;
					namePos = 0;
					error = false;
					break;

				case 'N':
					symPos = 0;
					namePos = 1;
					error = false;
					break;

				default:
				
				System.out.println("\n----------------------------------");
				System.out.println("Please choose an applicable option");
				System.out.println("----------------------------------\n");
				error = true;

			}
		} while(error);
		
		final int symPosFin = symPos;
		final int namePosFin = namePos;

		Scanner loadFile = new Scanner(new File("elementdb.csv"));
		System.out.println("\n---------------------------");
		System.out.println("Loading Data . . .");
		System.out.println("---------------------------\n");

		/* Load file to determine size of Array */
		while (loadFile.hasNext()){
			loadFile.nextLine();
			loadDataColCount++;

		}

		String[][] chemData = new String[3][loadDataColCount];

		/* reload file scanner */

		loadFile = new Scanner(new File("elementdb.csv"));

		

		for (int i = 0; i < loadDataColCount; i++) {
			
			String currentLoad = loadFile.nextLine();
			String[] split_load = currentLoad.split(",");

			for (int cur = 0; cur < 3; cur ++) {
				switch (cur){
					case 0:
						if (namePos == 0) {
							chemData[namePos][i] = split_load[1];
						}

						if (symPos == 0) {
							chemData[symPos][i] = split_load[0];
						}

						break;
					case 1:
						if (namePos == 1) {
							chemData[namePos][i] = split_load[1];
						}

						if (symPos == 1) {
							chemData[symPos][i] = split_load[0];
						}

						break;
					case 2:
						chemData[2][i] = "false";
					        break;
				}		
				

			}

		}

		System.out.println("COMPLETE");


	}

}
