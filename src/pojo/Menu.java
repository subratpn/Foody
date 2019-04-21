package pojo;

public class Menu {

	Integer id;
	String name;
	Double price;
	String image;
	Integer rest_id;
	
	public Integer getRest_id() {
		return rest_id;
	}

	public void setRest_id(Integer rest_id) {
		this.rest_id = rest_id;
	}

	public String toString() {
		return name+" "+price;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
