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

public class CopyOfhtest15 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		// EventListenerRegistry registry = ((SessionFactoryImpl)
		// sessionFactory).getServiceRegistry().getService(
		// EventListenerRegistry.class)
		System.out.println("session��");
		Transaction tx = s.beginTransaction();
		try {
			zqx1 z1=(zqx1) s.get(zqx1.class, new Long(2));
			zqx z=z1.getZqxid();
			System.out.println(z.getName());
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		if (s.isOpen()) {
			s.close();
			basetest.sf.close();
			System.out.println("session�ر�");
		}
	}

}
