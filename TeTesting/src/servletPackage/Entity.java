package servletPackage;

public class Entity {

	private int id;
	private String name;
	private String title;
	private int age;
	private boolean success;

	public Entity() {
	}

	public Entity(String name, String title, int age, boolean success) {
		this.name = name;
		this.title = title;
		this.age = age;
		this.success = success;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
