package hibenate;

import java.util.List;

import named.intercetr;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import entity.zqx;
import entity.zqx1;

public class htest19 {
	private static Logger log = Logger.getLogger(htest19.class);
	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		// EventListenerRegistry registry = ((SessionFactoryImpl)
		// sessionFactory).getServiceRegistry().getService(
		// EventListenerRegistry.class)
		System.out.println("session打开");
		Transaction tx = s.beginTransaction();
		Session s1 =null;
		Transaction tx1 =null;
		try {
			Query q= s.createQuery("from zqx1 z").setCacheable(true).setCacheRegion("zqx1");
			List<zqx1> l=q.list();
			for (zqx1 zqx : l) {
				System.out.println(zqx.getName());
			}
			tx.commit();
			s.close();
			s1= basetest.sf.withOptions().interceptor(new intercetr())
					.openSession();
			System.out.println("session打开");
			 tx1 = s1.beginTransaction();
			Query q1= s1.createQuery(" from zqx1 z").setCacheable(true).setCacheRegion("zqx1");
			List<zqx1> l1=q1.list();
			for (zqx1 zqx : l1) {
				System.out.println(zqx.getName());
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			 // 创建Statistics对象，并通过SessionFactory对象获得统计信息
			  Statistics st =  basetest.sf.getStatistics();
			  // 打印全部统计信息
			  System.out.println("@@@@##"+st.getSecondLevelCacheStatistics("zqx1"));
			  // 打印二级缓存信息
			  System.out.println("@@@@"+st);
			tx1.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			tx1.rollback();
			log.error("￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥", e);
		} finally {
			if (s.isOpen()) {
				s.close();
				s1.close();
				basetest.sf.close();
				log.info("session关闭");
			}
			if (s1.isOpen()) {
				s1.close();
				basetest.sf.close();
				log.info("session1关闭");
			}
		}
	}
}
