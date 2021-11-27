package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;
@Repository
public class HibernateCityDal implements ICityDal {
	
	@Autowired
	private EntityManager entityManager;

	public HibernateCityDal(EntityManager entityManager) {
		super();
		
		this.entityManager = entityManager;
	}

	@Transactional
	public List<City> getAll() {
		Session session= entityManager.unwrap(Session.class);
		List<City> cities=session.createQuery("from City", City.class).getResultList();
		return cities;
		
	}

	
	public void add(City city) {
		Session session =entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	
	public void update(City city) {
		Session session =entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
		
	}

	
	public void delete(City city) {
		Session session =entityManager.unwrap(Session.class);
		City cityToDelete=session.get(City.class, city.getId());
		session.delete(cityToDelete);
		
		
		
	}

	
	public City getById(int id) {
		Session session =entityManager.unwrap(Session.class);
		City city =session.get(City.class, id);
		return city;
		
	}

}
