package entity;

/**
 * @Author: wangwu
 * @Date: Created in 11:02 2020-08-28
 * @Description:
 */
public class Student {
	private String name;

	private Long id;
	private boolean flag;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
