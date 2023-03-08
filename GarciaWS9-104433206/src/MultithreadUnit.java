
public class MultithreadUnit  extends Thread{
	static int matrixSize;
	static int matrixSizey;
	static int totalTime;
	
	int[][] matrix1; 
	int[][] matrix2; 
	int numbThreads;
	int ThreadId;
	static int[][] resultMatrix;

	public MultithreadUnit(int[][] a, int[][] b, int size, int sizey, int Id) {
		this.numbThreads = numbThreads;
		this.ThreadId = Id;
		this.matrixSizey = sizey;
		this.matrixSize = size;
		matrix1 = new int[matrixSizey][matrixSize];
		matrix2 = new int[matrixSizey][matrixSize];
		resultMatrix = new int[matrixSize][matrixSize];
	}



	@Override
	public void run() {
		System.out.println("start of MultithreadUnit"+ ThreadId);
		parallelAddMatrix(matrix1,  matrix2, ThreadId );
	}
	public static int[][] parallelAddMatrix(int[][] a, int[][] b, int k){
		long timeStart  = System.nanoTime();
		
		try {
			for(int i = 0; i< matrixSizey; i++) {
				Thread.sleep(1);
				for(int e = 0; e<matrixSize;e++) {
					resultMatrix[i][e] = a[i][e]  + b[i][e] ;	
				}
			}
			long duration = (System.nanoTime() - timeStart)/1000000;
			totalTime = (int) duration; 
			System.out.println("Time adding the matrix: " + duration + " miliseconds. Id#: "+ k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultMatrix;
		
	}
	

}
