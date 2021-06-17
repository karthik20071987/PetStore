package models;

import java.util.List;


public class PetData {
	private Integer id;
    private CategoryData category;
    private String name;
    private List<String> photoUrls;
    private List<TagData> tags;
	private String status;
    
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public CategoryData getCategory() {
		return category;
	}

	public void setCategory(CategoryData category) {
		this.category = category;
	}
	
	public void addPhotoURLs(String photourl) {
		photoUrls.add(photourl);
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	
    public List<TagData> getTags() {
		return tags;
	}

	public void setTags(List<TagData> tags) {
		this.tags = tags;
	}
    

}
