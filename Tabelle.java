class Tabella{
	private int colonne, lastcolonne;
	private int righe, lastrighe;
	private int[][] tabella;
	private int[][] lastTabella;

	public Tabella(int colonne, int righe){
		this.colonne = colonne;
		this.righe = righe;
		lastrighe = righe;
		lastcolonne = colonne;
	}
	public void addRiga(){
		righe++;
	}
	public void addRiga(int n){
		righe += n;
	}
	public void addColonna(){
		colonne++;
	}
	public void addColonna(int n){
		colonne += n;
	}
	public void build(){
		tabella = new int[colonne][righe];
		if (lastcolonne != colonne || lastrighe != righe){
			for(int x = 0; x < lastcolonne; x++){
				for(int y = 0; y< lastrighe; y++)
					tabella[x][y] = lastTabella[x][y];
			}
		}
		lastTabella = tabella;
	}
	public void insert(int c, int r, int i){
		tabella[c][r] = i;
	}
	public int maxColonna(int c){
		int maxColonna = 0;
		//scorre le righe tenendo fissa la colonna per trovare il numero con piu cifre
		for(int i = 0; i < righe; i++){
			int lung = Util.contaCifre(tabella[c][i]);
			if(lung > maxColonna)
				maxColonna = lung;
		}
		return maxColonna;
	}

	public void draw(){
		StringBuilder sb = new StringBuilder();
		int lunghezzaTab = 0;
		for(int i = 0; i < colonne; i++){
			lunghezzaTab += maxColonna(i) + 1;
		}
		for(int indiceRighe=0; indiceRighe < righe; indiceRighe++){
			for(int i = 0; i <= lunghezzaTab; i++) //stampa la prima linea orizz di ogni riga
				System.out.print("-");
			System.out.println();
			sb.append("|"); 
			for(int indiceColonne = 0; indiceColonne < colonne; indiceColonne++){
				int spazi = maxColonna(indiceColonne) - Util.contaCifre(tabella[indiceColonne][indiceRighe]);
				for(int i = 0; i < spazi; i++)
				sb.append(" ");
				sb.append(tabella[indiceColonne][indiceRighe]);
				sb.append("|");
			}
			System.out.println(sb.toString());
			sb.delete(0,lunghezzaTab+1);
		}
		for(int i = 0; i <= lunghezzaTab; i++)
			System.out.print("-");
		System.out.println();
	}
