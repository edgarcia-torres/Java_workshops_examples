package task2;

class StoreNumber
{
    int value;
    boolean state=false;
    
    public synchronized  void set(int v)    {
        while(state) {
        	try {
        		wait();
        		}catch(Exception e){};
        }
        this.value =v;
        state=true;
        notify();
    }
    
    public synchronized  void get()
    {
         
        while(!state) {
        	 try {wait();}catch(Exception e){}
        }
        state=false;
        notify();
             
    }
}