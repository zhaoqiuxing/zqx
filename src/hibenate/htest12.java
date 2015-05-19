package hibenate;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import named.intercetr;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.PreparedStatement;

import entity.zqx;
import entity.zqx1;

public class htest12 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
		Query q= s.createQuery("from zqx as c");
		List<zqx> l=q.list();
		for(zqx z :l){
			System.out.println(z.getName());
			 Set<zqx1> zq1=z.getSet();
			 for (zqx1 zqx1 : zq1) {
				System.out.println(zqx1.getName());
			}
		}
			tx.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		if (s.isOpen()) {
			s.close();
			basetest.sf.close();
			System.out.println("session¹Ø±Õ");
		}
	}

}
