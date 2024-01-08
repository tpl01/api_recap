package pojos;

import java.io.Serializable;

public class TagsPojo implements Serializable {
	private int id;
	private String name;

	public TagsPojo() {
	}

	public TagsPojo(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"TagsPojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}