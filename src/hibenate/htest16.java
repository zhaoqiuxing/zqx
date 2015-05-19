package hibenate;

import java.util.Iterator;
import java.util.List;
import named.intercetr;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.zz;

public class htest16 {
	private static Logger log = Logger.getLogger(htest16.class);
	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		// EventListenerRegistry registry = ((SessionFactoryImpl)
		// sessionFactory).getServiceRegistry().getService(
		// EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			// zqx z=new zqx();
			// z.setName("zqx");
			// List<zqx> c
			// =s.createCriteria(zz.class).add(Example.create(z)).list();
			// List<zqx> c = s.createCriteria(zqx.class)
			// .add(Restrictions.eq("name", "zqx2")).setReadOnly(true)
			// .addOrder(Order.asc("age")).setFirstResult(0).setMaxResults(2).list();
			// zqx z=new zqx();
			// z.setName("zqx");
			// List<zqx>
			// c=s.createQuery("from zqx where name=:name").setParameter("z","zqx").setFirstResult(0).setMaxResults(2).list();
			// List<zqx>
			// c1=s.createQuery("from zqx where lower(name)=:name").setReadOnly(true).setProperties(z).setFetchSize(3).setComment("zqx×¢ÊÍ").setFirstResult(0).setMaxResults(2).list();
			// List<zqx> c=s.getNamedQuery("zqxh1").setInteger("zqx", 1).list();
			// List<zqx> c=s.getNamedQuery("zqxsql").list();
			List c = s
					.createQuery(
							"select new entity.zz(zz.name, s.id) from zqx as zz  join zz.set as s where zz.id=:id").setInteger("id", new Integer(1))
					.list();

			Iterator i = c.iterator();
			while (i.hasNext()) {
				zz zz = (zz) i.next();
				System.out.println(+zz.getId() + zz.getName());
			}
			/*
			 * for (zqx zqx : c) { System.out.println(zqx.getName()); }
			 */
			int e=4/0;
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			log.error("£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤", e);
		} finally {
			if (s.isOpen()) {
				s.close();
				basetest.sf.close();
				log.info("session¹Ø±Õ");
			}
		}
	}

}
