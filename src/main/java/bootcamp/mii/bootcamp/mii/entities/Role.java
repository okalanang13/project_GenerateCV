package bootcamp.mii.bootcamp.mii.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long role_id;
	
	@Column
	private String role;
	
	public String getAuthority() {
		return role;
	}

	public void setAuthority(String authority) {
		this.role = role;
	}
}