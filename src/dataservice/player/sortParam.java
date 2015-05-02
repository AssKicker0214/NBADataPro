package dataservice.player;

public class sortParam {
	public String field;
	public boolean isDesc;
	
	public sortParam(){}
	public sortParam(String f, boolean d){
		field = f;
		isDesc = d;
	}

}
