package servletPackage;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BeanInt {
	public void sayHello();
	public List getEntities();
	public Entity getOneEntity(int id);
	public Entity addEntity(Entity newEntity);
	public void deleteEntity(Integer EmployeeID);
	public void updateEntity(Entity currentEntity);
}
