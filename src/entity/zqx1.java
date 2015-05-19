package entity;

import java.io.Serializable;

public class zqx1 implements Serializable {

	private static final long serialVersionUID = -4346161615623767960L;
	private Long id;

	private zqx zqxid;
	public zqx getZqxid() {
		return zqxid;
	}

	public void setZqxid(zqx zqxid) {
		this.zqxid = zqxid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
