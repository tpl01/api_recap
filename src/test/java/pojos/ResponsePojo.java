package pojos;

import java.util.List;
import java.io.Serializable;

public class ResponsePojo implements Serializable {
	private int id;
	private CategoryPojo category;
	private String name;
	private List<String> photoUrls;
	private List<TagsPojo> tags;
	private String status;

	public ResponsePojo() {
	}

	public ResponsePojo(int id, CategoryPojo category, String name, List<String> photoUrls, List<TagsPojo> tags, String status) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(CategoryPojo category){
		this.category = category;
	}

	public CategoryPojo getCategory(){
		return category;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPhotoUrls(List<String> photoUrls){
		this.photoUrls = photoUrls;
	}

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public void setTags(List<TagsPojo> tags){
		this.tags = tags;
	}

	public List<TagsPojo> getTags(){
		return tags;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePojo{" + 
			"id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",name = '" + name + '\'' + 
			",photoUrls = '" + photoUrls + '\'' + 
			",tags = '" + tags + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}