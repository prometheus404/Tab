import java.util.Scanner;

public class Editor{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String comando;
		String[] parole = new String[10];
		
		printWelcome();
		while(true){
		
			System.out.println();
			System.out.print(">>>");
			
			comando = in.nextLine();
			if (comando.equals("quit")){
				System.out.println("Bye Bye");
				break;
			}
			
			parole = comando.split(" ");
			
			switch(parole[0]){
				case("help"):
					printHelp(0);
					break;
				case("ver"):
					printHelp(1);
					break;
				case("mktab"):	
					//TODO: chiamare metodo costruzione tabelle
					//Tabella tab = new Tabella(Integer.parseInt(parole[1]), Integer.parseInt(parole[2]));
					Tabella tab = creaTabella(Integer.parseInt(parole[1]), Integer.parseInt(parole[2]), parole[3]);
					System.out.println("New table named \""+parole[3]+"\" created");
					break;
				case("addCol"):
					tab.addColonna();
					System.out.println("Column added");
					break;
				default:
					System.out.println("Command "+parole[0]+" not found");
			}
		}
	}
	
	public static void printWelcome(){
		System.out.println();
		System.out.println("Benvenuto in Editor Tabelle");
		System.out.println("Esegui comando \"help\" per aiuto");
	}
	public static void printHelp(int n){
		if(n == 0){
			System.out.println();
			System.out.println("/////////////////////////////");
			System.out.println("Comandi:");
			System.out.println("mktab col row: crea una nuova tabella delle dimensioni dichiarate");
			System.out.println("help: apre questa pagina di aiuto");
			System.out.println("quit: termina Editor Tabelle");
		}
		if(n == 1)
			System.out.println("Editor Tabelle v.0.1");
	}
	public static Tabella creaTabella(int col, int row, String nome){
		Tabella tab = new Tabella(col, row);
		return tab;
	}
}