package hibenate;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import named.intercetr;

import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.PreparedStatement;

import entity.zqx;
import entity.zqx1;

public class htest13 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session打开");
		Transaction tx = s.beginTransaction();
		try {
			zqx z=(zqx) s.load(zqx.class, new Long(1));
			if(!Hibernate.isInitialized(z)){
				System.out.println("初始化");
				Hibernate.initialize(z);
			}
	s.close();
	System.out.println(z.getAge());
			tx.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		if (s.isOpen()) {
			s.close();
			basetest.sf.close();
			System.out.println("session关闭");
		}
	}

}
