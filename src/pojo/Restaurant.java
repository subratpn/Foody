package pojo;

public class Restaurant {

	
	Integer id;
	String name;
	String location;
	Long contact;
	String image;
	
	
	

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




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public Long getContact() {
		return contact;
	}




	public void setContact(Long contact) {
		this.contact = contact;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public String toString() {
		return name+" "+location;
	}
	
	
	
}
