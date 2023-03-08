package task2;

class PrintNumber extends Thread
{
    StoreNumber data;
    public PrintNumber(StoreNumber data)  {
        this.data=data;
    }
    
    public void run(){
        while(true ){
        	data.get();
        	System.out.println("PRINTER : "+data.value );
        }
    }
}
