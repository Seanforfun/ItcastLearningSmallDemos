package ca.mcmaster.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Cities")
public class Cities {
	private String name;

	public Cities() {
	}
	
	public Cities(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
