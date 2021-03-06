package ru.rashgild.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object entity) {
        getSession().persist(entity);
    }

    public void update(Object entity) {
        getSession().clear();
        getSession().update(entity);
    }
}
