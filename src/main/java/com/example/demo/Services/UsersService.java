package com.example.demo.Services;

import com.example.demo.entities.Users;

public interface UsersService {
	public String adduser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);

}
