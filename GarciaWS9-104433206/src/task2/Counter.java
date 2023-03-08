package task2;

class Counter implements Runnable
{
    StoreNumber store;
   
    public Counter(StoreNumber store)   {
        this.store=store;
    }
    public synchronized  int operate(int c) {
		c++;
		store.set(c);
		try {
			Thread.sleep(1200);
		} catch(Exception e ) {
			System.out.println("ERror sleep");
		};

    	return c;
    }

    public void run()    {
    	int c = 0 ;	 	
    	while(true) {	
    		c=operate(c);
    	}
    }
}
