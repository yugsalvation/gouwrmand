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
	@Transactional
	public void deleteFoodItem(int fi) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="update FoodItem set food_status=0 where food_id="+fi;
		Query thequery=currentSession.createQuery(query);
		int result=thequery.executeUpdate();

	}

	@Override
	@Transactional
	public void updateFoodItem(FoodItem fi) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		double d=fi.getFood_discount();
		fi.setFood_discount(d/100);
		String query="update FoodItem f set f.food_type=\'"+fi.getFood_type()+"\',f.food_name=\'"+fi.getFood_name()+"\',f.food_price="+fi.getFood_price()+",f.food_discount="+fi.getFood_discount()+",f.food_description=\'"+fi.getFood_description()+"\' where f.food_id="+fi.getFood_id();

	
		Query thequery=currentSession.createQuery(query);
		
		int result=thequery.executeUpdate();
		//currentSession.close();

	}

	@Override
	@Transactional
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
		String query="from FoodItem f where food_type=\'"+category+"\' and food_status=1";
		Query <FoodItem> theQuery=currentSession.createQuery(query,FoodItem.class);
		List<FoodItem>l=theQuery.getResultList();
		return l;
	}

	@Override
	@Transactional
	public FoodItem getFoodItem(int fid) {
		Session currentSession=entityManager.unwrap(Session.class);
		String query="from FoodItem f where f.food_id=\'"+fid+"\'";
		Query <FoodItem> theQuery=currentSession.createQuery(query,FoodItem.class);
		FoodItem f=theQuery.getSingleResult();
		
		return f;
	}

}
