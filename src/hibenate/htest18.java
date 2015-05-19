package hibenate;

import java.util.List;

import named.intercetr;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import entity.zqx;

public class htest18 {
	private static Logger log = Logger.getLogger(htest18.class);
	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		// EventListenerRegistry registry = ((SessionFactoryImpl)
		// sessionFactory).getServiceRegistry().getService(
		// EventListenerRegistry.class)
		System.out.println("session��");
		Transaction tx = s.beginTransaction();
		Session s1 =null;
		Transaction tx1 =null;
		try {
			Query q= s.createQuery("from zqx").setCacheable(true);
			List<zqx> l=q.list();
			for (zqx zqx : l) {
				System.out.println(zqx.getName());
			}
			tx.commit();
			s.close();
			s1= basetest.sf.withOptions().interceptor(new intercetr())
					.openSession();
			System.out.println("session��");
			 tx1 = s1.beginTransaction();
			Query q1= s1.createQuery("from zqx").setCacheable(true);
			List<zqx> l1=q1.list();
			for (zqx zqx : l1) {
				System.out.println(zqx.getName());
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			 // ����Statistics���󣬲�ͨ��SessionFactory������ͳ����Ϣ
			  Statistics st =  basetest.sf.getStatistics();
			  // ��ӡȫ��ͳ����Ϣ
			  System.out.println("@@@@"+st.getSecondLevelCacheStatistics("entity.zqx").getEntries());
			  // ��ӡ����������Ϣ
			  System.out.println("@@@@"+st);
			tx1.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			tx1.rollback();
			log.error("��������������������������������������������������������������������������������������", e);
		} finally {
			if (s.isOpen()) {
				s.close();
				s1.close();
				basetest.sf.close();
				log.info("session�ر�");
			}
			if (s1.isOpen()) {
				s1.close();
				basetest.sf.close();
				log.info("session1�ر�");
			}
		}
	}
}
