package day03;

public class DataDto {
	
	
	private String data1;
	private int data2;
	
	public DataDto() {
		// TODO Auto-generated constructor stub
	}

	public DataDto(String data1, int data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public int getData2() {
		return data2;
	}

	public void setData2(int data2) {
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "DataDto [data1=" + data1 + ", data2=" + data2 + "]";
	}
	

	
}
