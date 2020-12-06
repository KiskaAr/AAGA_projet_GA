package aaga;

public class Main {

	public static void main(String[] args) {
		
		for (int i=100; i<1000000; i+=1000) {
			int h = 0;
			
			for (int j=0; j<5; j++) {
				ABR t = new ABR(i);
				h += t.height(t.racine);
			}
			
			System.out.println(i + "\t" + (double)h/10);
		}

	}

}
