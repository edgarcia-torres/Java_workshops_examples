package task2;

public class counterApp {
	
	public static void main(String[] args) {
		StoreNumber store = new StoreNumber();
		
		PrintNumber printer = new PrintNumber(store);
        Counter     counter=new Counter(store);
        Thread t = new Thread(counter,"Counter");
        t.start();   
        printer.start();
	}
}
