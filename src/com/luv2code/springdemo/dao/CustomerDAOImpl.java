package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
//need to inject seesion factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
Session currentSession= sessionFactory.getCurrentSession();		
		//create a query
Query<Customer> theQuery=currentSession.createQuery	("from Customer order by firstName", Customer.class);	
		//execute query and get result list
		List<Customer> customers=theQuery.getResultList();
		//return the results
		System.out.println();
		return customers;
		
		
	
	}

	@Override
	public void saveCustomer(Customer cu) {
		// TODO Auto-generated method stub
		Session sess= sessionFactory.getCurrentSession();
		sess.saveOrUpdate(cu);
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Customer c=s.get(Customer.class,theId);
		return c;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Customer c=s.get(Customer.class,theId);
		s.delete(c);
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Query<Customer> theQ=null;
		if(theSearchName!=null && theSearchName.length()>0) {
			theQ = s.createQuery("from Customer where lower(firstName) like:name or"
					+ " lower(lastName) like:name", Customer.class);
			theQ.setParameter("name", "%"+ theSearchName.toLowerCase() +"%");		
		}
		
		else{		
			theQ=s.createQuery("from Customer", Customer.class);
		}
		List<Customer> customers=theQ.getResultList();
		return customers;
	}

}
