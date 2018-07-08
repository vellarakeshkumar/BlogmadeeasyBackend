package com.BlogmadeeasyBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.BlogmadeeasyBackend.dao.UserDao;
import com.BlogmadeeasyBackend.dao.UserDaoImpl;
import com.BlogmadeeasyBackend.model.User;

@EnableTransactionManagement
public class DBBackendConfig {
	
	
//Logger logger =LoggerFactory.getLogger(DataBaseConfiguration.class);
	
	@Bean(name = "dataSource")
		public DataSource getDataSource() {
		logger.info("Data Source Configuration ");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("rakesh");
		dataSource.setPassword("pass");
		logger.info("Data Base Connected ");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		logger.info("========Hibernate Properties=========== ");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql","true");
		logger.info("========Hibernate Properties  has been set=========== ");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		logger.info("========Hibernate Session Factory=========== ");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(User.class);

	
		logger.info("========Hibernate SessionFactory Object created=========== ");
		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
 	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		logger.info("========Hibernate Transaction =========== ");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		logger.info("========Hibernate Transaction object created=========== ");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name = "UserDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
	    return new UserDaoImpl(sessionFactory);
	}
}