package com.rest.dto;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ezequ on 12/3/2016.
 */
public abstract  class SessionFactoryHandler {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void guardarEnBD(Object object){
        getSession().save(object);
    }
    public void actulizarObjeto(Object object){
        getSession().update(object);
    }


    public void borrarObjeto(Object object){
        getSession().delete(object);
    }

}
