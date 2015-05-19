package entity;

public class zz {
	public zz(){
		
	}
	public zz(String name ,Long id){
		this.name=name;
		this.id=id;
	}
private Long id;
private String name;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
