package com.BlogmadeeasyBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BlogmadeeasyBackend.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
 
    public UserDaoImpl() {
         
    }
     
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    
    @Transactional
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    
    @Transactional
    public void delete(int id) {
        User userToDelete = new User();
        userToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    
    @Transactional
    public User get(int id) {
        String hql = "from User where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }
}