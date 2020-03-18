package com.spring.gouwrmand.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gouwrmand.entity.FoodItem;

@Repository
public class FoodItemDaoImpl implements FoodItemDao {
	@Autowired
	//private SessionFactory sessionFactory;
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addFoodItem(FoodItem fi) {
		//Session currentSession=sessionFactory.getCurrentSession();
		Session currentSession=entityManager.unwrap(Session.class);
		double d=fi.getFood_discount();
		d=d/100;
		fi.setFood_discount(d);
		currentSession.save(fi);
		currentSession.close();

	}

	@Override
	public void deleteFoodItem(FoodItem fi) {
		

	}

	@Override
	public void updateFoodItem(FoodItem fi) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getFoodCategories() {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="select distinct food_type from FoodItem f";
		Query theQuery=currentSession.createQuery(query);
		List<String>l=(List<String>)theQuery.list();
		return l;
	}

	@Override
	@Transactional
	public List<FoodItem> getFoodByCategory(String category) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from FoodItem f where food_type=\'"+category+"\'";
		Query <FoodItem> theQuery=currentSession.createQuery(query,FoodItem.class);
		List<FoodItem>l=theQuery.getResultList();
		return l;
	}

}
