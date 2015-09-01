package domain;

/**
 * User�ǳ־û������ǰ̨�û�ʵ�����
 */
import java.io.Serializable;
import java.util.*;
import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USERS",schema="SCOTT")
public class User implements Serializable 
{
	
	//��Ӧ����
	@Id
	@GeneratedValue(generator="userPkGenerator")
	@GenericGenerator(name="userPkGenerator",strategy="increment")
	@Column(name="USERID")
	private Integer userid;
	
	//ע����û���
	@Column(name="USERNAME",length=30,nullable=false)
	private String username;
	
	//ע���û�����Ӧ������
	@Column(name="PASSWORD",length=30,nullable=false)
	private String password;
	
	//�û�������
	@Column(name="NAME",length=30,nullable=false)
	private String name;
	
	//�û����Ա�
	@Column(name="SEX")
	private String sex;
	
	//�û���סַ
	@Column(name="ADDRESS",length=50)
	private String address;
	
	//�û��ĵ绰����
	@Column(name="PHONE",length=30,nullable=false)
	private String phone;
	
	//�û����ʼĵ�ַ
	@Column(name="POSTADDRESS",length=50,nullable=false)
	private String post;
	
	//�û���email��ַ
	@Column(name="EMAIL",length=30)
	private String email;
	
	//�û���ע��ʱ��
	@Column(name="REGTIME")
	private java.sql.Date regtime;
	
	//���ڴ�Ÿ��û��Ķ�������
	//�������Ʒ����ʵ�������������е���Ʒʵ��
	@OneToMany(targetEntity=domain.OrderForm.class)
		//���������
	@JoinColumn(name="USERID")
	private Set<OrderForm> orders=new HashSet<OrderForm>();
	
	
	public Set<OrderForm> getOrders() 
	{
		return orders;
	}
	public void setOrders(Set<OrderForm> orders)
	{
		this.orders = orders;
	}
	public Integer getUserid()
	{
		return userid;
	}
	public void setUserid(Integer userid)
	{
		this.userid = userid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPost()
	{
		return post;
	}
	public void setPost(String post)
	{
		this.post = post;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public java.sql.Date getRegtime()
	{
		return regtime;
	}
	public void setRegtime(java.sql.Date regtime)
	{
		this.regtime = regtime;
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		return true;
	}
	
	
	
}	
