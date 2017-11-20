class Util{
	public static int contaCifre(int x){
		if(x == 0) return 1;
		int c = 0;
		while(x > 0){
			c++;
			x /= 10;
		}
		return c;
	}
}
