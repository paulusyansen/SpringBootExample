package org.paingan.boot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserDTO {

	public int id;
	public String username;
	public String password;
	public String firstname;
	public String lastname;

	
	public UserDTO(int id, String username, String password, String firstname, String lastname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
}
