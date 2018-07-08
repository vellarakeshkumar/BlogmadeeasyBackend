package com.BlogmadeeasyBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.BlogmadeeasyBackend.dao.UserDao;
import com.BlogmadeeasyBackend.model.User;

public class UserDaoTest {
	
	@ComponentScan(basePackages ={ "com.BlogmadeeasyBackend" })
	public class UserDAOTest {


		@Autowired
		private static User user;

		@Autowired
		private static UserDao userDao;
		

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DataBaseConfiguration.class);
		context.scan("org.collaborative.*");
		context.refresh();
		user = (User) context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");
	}


	@Test
	public void createUser()
	{
		user.setFirstName("rakesh");
		user.setLastName("siva");
		user.setEmail("siva@gmail.com");
		user.setPassword("pass");
		user.setEnabled(true);
		
		boolean flag=userDao.saveUser(user);
		assertEquals("createUserTestCase", true, flag);

	}


	@Test
	@Ignore
	public void fetchAllUser()
	{
		  /* List<BlogUserDetail> users = userDAO.userList();
	       Assert.assertEquals(blogUserDetail.getEmail(), users.get(0).getEmail());
		*/
			int noofuser=userDao.userList().size();
			assertEquals("getAllUserTestCase", noofuser);
		
		

		

	}

	}

}
