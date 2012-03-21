package uml.drawer;

import java.util.ArrayList;

public class Method {

	private String returnType;
	private String name;
	private ArrayList<String> parameters;
	
	public Method(String returnType, String name, ArrayList<String> parameters) {
		this.returnType = returnType;
		this.name = name;
		this.parameters = parameters;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
	
	
	
	
}
