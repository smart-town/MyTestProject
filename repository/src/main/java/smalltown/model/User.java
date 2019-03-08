package smalltown.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private int status;
	private String name ;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return "User[name="+name+",id="+id+",status="+status+"]" ;
	}
}
