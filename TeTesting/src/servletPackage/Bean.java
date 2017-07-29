package servletPackage;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Stateless
public class Bean implements BeanInt {
	
	private final static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	@Override
	public void sayHello() {
		System.out.println("Hello this is a bean test");
	}
	
	
	@Override
	public List getEntities() {
		Session session = factory.openSession();
		List entityList = null;
		try {
			session.beginTransaction();
			entityList = session.createQuery("FROM Entity").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return entityList;
	}
	
	@Override
	public Entity addEntity(Entity newEntity) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.persist(newEntity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newEntity;
	}
	
	@Override
	public void deleteEntity(Integer EmployeeID) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Entity oneEntity = session.get(Entity.class, EmployeeID);
			session.delete(oneEntity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Override
	public Entity getOneEntity(int id) {
		Session session = factory.openSession();
		Entity oneEntity = null;
		try {
			session.beginTransaction();
			oneEntity = session.get(Entity.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return oneEntity;
	}
	
	@Override
	public void updateEntity(Entity currentEntity) {
			Session session = factory.openSession();
			try {
				session.beginTransaction();
				session.update(currentEntity);
				session.getTransaction().commit();
			} catch (HibernateException e) {
				if (session.getTransaction() != null)
					session.getTransaction().rollback();
				e.printStackTrace();
			} finally {
				session.close();
		}
	}

}
