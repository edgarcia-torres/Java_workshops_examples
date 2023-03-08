
public class Results {
	
	private double result;
	private String type; 
	private String status;  
	private double age;

	public Results() { //create default values 
		this.result = 0;
		this.type = "";
		this.status = "indefined";
	}
	public Results(double r, String m, String s, double a) {
		this.result = r;
		this.type = m;
		this.status = s;
		this.age = a;
	}
	//right click > source > generate getters and setters 
	
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
