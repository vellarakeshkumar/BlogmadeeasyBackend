package com.BlogmadeeasyBackend.dao;

import java.util.List;

import com.BlogmadeeasyBackend.model.User;

public interface UserDao {
	public List<User> list();
    
    public User get(int id);
     
    public void saveOrUpdate(User user);
     
    public void delete(int id);

}
