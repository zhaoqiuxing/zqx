package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class zqx  implements Serializable {

	private static final long serialVersionUID = 7881945592591710454L;
	private int iaa11;
	private Long id;
	private String testformult;
	private Set set =new HashSet();
	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
	public String getTestformult() {
		return testformult;
	}

	public void setTestformult(String testformult) {
		this.testformult = testformult;
	}

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
