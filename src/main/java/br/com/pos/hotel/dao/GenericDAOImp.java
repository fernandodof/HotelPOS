/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pos.hotel.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Fernando
 * @param <T>
 */
public class GenericDAOImp<T> implements GenericDAO<T> {

    private EntityManager em;
    private EntityManagerFactory factory;

    public GenericDAOImp() {
        this.em = getEntityManager();
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            factory = Persistence.createEntityManagerFactory("HotelPOS");
            em = factory.createEntityManager();
        }
        return em;
    }

    @Override
    public boolean save(T entity) {
        try {
            this.em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            this.em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            this.em.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(T entity) {
        try {
            this.em.getTransaction().begin();
            em.merge(entity);
            em.flush();
            this.em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public T find(Class<T> classType, T entity) {
        return this.em.find(classType, entity);
    }

    @Override
    public boolean delete(T entity) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(entity);
            this.em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public T getById(Class<T> classTClass, Object id) {
        try {
            return getEntityManager().find(classTClass, id);
        } catch (NoResultException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public T simpleQuery(String query, Map<Integer, Serializable> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object executeNativeQuery(String query) {
        return this.em.createNativeQuery(query).getSingleResult();
    }

    @Override
    public T getSingleResultOfNamedQuery(String namedQuery, Map<String, Object> map) throws NoResultException {
        Query query = this.em.createNamedQuery(namedQuery);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String param = entry.getKey();
            Object value = entry.getValue();
            query.setParameter(param, value);
        }
        return (T) query.getSingleResult();
    }

    @Override
    public T getSingleResultOfNamedQuery(String namedQuery) throws NoResultException {

        Query query = this.em.createNamedQuery(namedQuery);
        if (query.getResultList().isEmpty()) {
            throw new NoResultException();
        } else {
            return (T) query.getResultList().get(0);
        }
    }

    @Override
    public List<T> getListResultOfNamedQuery(String namedQuery) throws NoResultException {
        Query query = this.em.createNamedQuery(namedQuery);
        if (query.getResultList().isEmpty()) {
            throw new NoResultException();
        } else {
            return query.getResultList();
        }
    }

    @Override
    public List<T> getListResultOfNamedQuery(String namedQuery, Map<String, Object> map) throws NoResultException {
        Query query = this.em.createNamedQuery(namedQuery);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String param = entry.getKey();
            Object value = entry.getValue();
            query.setParameter(param, value);
        }
        return query.getResultList();
    }

    @Override
    public List<T> getListResultOfNamedQueryWithLimit(String namedQuery, int min, int max) {
        Query query = this.em.createNamedQuery(namedQuery);
        if (query.getResultList().isEmpty()) {
            throw new NoResultException();
        } else {
            return query.setMaxResults(max).setFirstResult(min).getResultList();
        }
    }

    @Override
    public List<T> getAll(Class<T> classType) {
        List<T> all = null;
        try {
            Query query = em.createQuery("SELECT O FROM " + classType.getSimpleName()+ " O ORDER BY 2 ASC");
            all = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return all;
    }
    
}