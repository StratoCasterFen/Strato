package by.academy.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import by.academy.dao.exception.DaoException;
import by.academy.pojos.User;


public interface GenericHDao <T> {

    /** Создает новую запись, соответствующую объекту object */
	public T persist(T object)  throws DaoException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(Integer key) throws DaoException;

    /** Сохраняет состояние объекта  в базе данных  */
    public T update(T object) throws DaoException;

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object) throws DaoException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List getAll() throws DaoException;	
    
    /**	Возвращет EntityManager **/
    public EntityManager getEntityManager();
    
    /**	Устанавливает EntityManager **/
    public void setEntityManager(EntityManager entityManager);

}