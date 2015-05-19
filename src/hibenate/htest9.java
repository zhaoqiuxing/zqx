package hibenate;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

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

public class htest9 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			Work w =new Work() {
				
				@Override
				public void execute(Connection arg0) throws SQLException {
					// TODO Auto-generated method stub
					PreparedStatement  p=(PreparedStatement) arg0.prepareStatement("update zqxtable set age=? where id=2");
					p.setInt(1, 22);
					p.executeUpdate();
				}
			};
			s.doWork(w);
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
