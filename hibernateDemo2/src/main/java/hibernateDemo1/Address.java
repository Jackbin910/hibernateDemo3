package hibernateDemo1;

import java.util.Date;

/**
 * ID 作为持久化标识符 用封装类,基本类型有默认值，会有问题 持久化类手动添加无参数的构造器（有操作是反射进行的） 属性通常提供get,set方法
 * 持久化类不能final类
 * 
 * @author asu
 *
 */
public class Address {
	private Integer id;
	private String descs;
	private int code;

	public Address() {
	}

	public Address(String descs, int code) {
		super();
		this.descs = descs;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", descs=" + descs + ", code=" + code + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
