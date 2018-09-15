package hibernateDemo1;

import java.util.Date;

/**
 * ID 作为持久化标识符
 * 用封装类,基本类型有默认值，会有问题
 * 持久化类手动添加无参数的构造器（有操作是反射进行的）
 * 属性通常提供get,set方法
 * 持久化类不能final类
 * @author asu
 *
 */
public class Person {
	private Integer id;
	private String name;
	private int password;
	private Date birthday;
	private String address;

	public Person(){}

	public Person(String name, int password, Date birthday) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
