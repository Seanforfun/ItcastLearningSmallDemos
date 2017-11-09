package ca.mcmaster.vo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("provinces")
public class Provinces {
	private String name;
	@XStreamImplicit
	private List<Cities> cities;
	
	public Provinces() {
		super();
	}

	public Provinces(String name, List<Cities> cities) {
		this.name = name;
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cities> getCities() {
		return cities;
	}

	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}
}
