package hibenate;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
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

public class htest17 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		// EventListenerRegistry registry = ((SessionFactoryImpl)
		// sessionFactory).getServiceRegistry().getService(
		// EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			Query q= s.createQuery("from zqx1 as c ");
			List<zqx1> l=q.list();
			Iterator<zqx1> iz=l.iterator();
			zqx1 z1=iz.next();
			System.out.println(z1.getName());
			zqx1 z2=iz.next();
			zqx zz=(zqx) z1.getZqxid();
			zqx zzz=(zqx) z1.getZqxid();
			System.out.println(zz.getAge());
			System.out.println(zzz.getAge());
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
