package com.sharedPrimarkey.mapping.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sharedPrimarkey.mapping.entity.AccountEntity;
import com.sharedPrimarkey.mapping.entity.EmployeeEntity;




public class UserDAO {
	public static void main(String[] args) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		AccountEntity accountEntity = new AccountEntity();
		employeeEntity.setFname("Ankur");
		employeeEntity.setLname("Patel");
		employeeEntity.setEmail("ankurptl3@gmail.com");

		accountEntity.setAcc_Number(120330131);

		employeeEntity.setAccount(accountEntity);
		Configuration configuration = new Configuration();
		configuration.configure("resources/db.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "from EmployeeEntity";
		try {

				/*session.save(employeeEntity);
				transaction.commit();*/

			
  Query query = session.createQuery(sql); 
			  List<EmployeeEntity> list = query.list();
			  for (EmployeeEntity userEntity2 : list)
			  { 
				  System.out.println(userEntity2); 
             System.out.println(userEntity2.getAccount().getAcc_Number()); 
			  }
			 
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}

	}
}
