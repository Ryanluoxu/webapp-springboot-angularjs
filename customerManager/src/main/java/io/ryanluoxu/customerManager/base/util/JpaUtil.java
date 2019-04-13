package io.ryanluoxu.customerManager.base.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emFactory;

	static{
		emFactory = Persistence.createEntityManagerFactory("myJPA");
	}

	public static EntityManager createEntityManager(){
		return emFactory.createEntityManager();
	}

	public static void main(String[] args) {
		createEntityManager();
	}

}
