package com.spring.gouwrmand.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		currentSession.save(fi);

	}

	@Override
	public void deleteFoodItem(FoodItem fi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFoodItem(FoodItem fi) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getFoodCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodItem> getFoodByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
