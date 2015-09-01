package action;

import java.sql.Date;
import java.util.List;

import service.UserService;
import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;

import dao.Imp.UserDaoImp;

public class UserAction extends ActionSupport 
{
	//ҵ���߼����
	private UserService userService;
	//��װ��ѯ�����
	private List<UserBean> data;
	//���·�װ�û���Ϣ����
	private int userid;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String address;
	private String postaddress;
	private String email;
	private String phone;
	private Date tagtime;
	//���·�װ���ǰ�˷�����Ϣ����
	private String msg;
	private boolean success;
	private int  total;
	private String query;
	//���·�װ��ҳ����
	private int page;
	private int limit;
	//������Ե�getter��setter����
	public void setUserService(UserService userService) 
	{
		this.userService = userService;
	}

	public void setData(List<UserBean> data) 
	{
		this.data = data;
	}
	public List<UserBean> getData()
	{
		return this.data;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getSex()
	{
		return this.sex;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setPostaddress(String postaddress) 
	{
		this.postaddress = postaddress;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public void setTagtime(Date tagtime) 
	{
		this.tagtime = tagtime;
	}

	public void setMsg(String msg) 
	{
		this.msg = msg;
	}
	public String getMsg()
	{
		return this.msg;
	}

	public void setSuccess(boolean success) 
	{
		this.success = success;
	}
	public boolean getSuccess()
	{
		return this.success;
	}


	public void setTotal(int total) 
	{
		this.total = total;
	}
	public int getTotal()
	{
		return this.total;
	}
	
	public void setPage(int page) 
	{
		this.page = page;
	}

	public void setLimit(int limit)
	{
		this.limit = limit;
	}

    public void setQuery(String query)
    {
    	this.query=query;
    }
    
	//��ѯ�û������Ϣ�������û���/�绰����
	public String findUserByNameOPhone() throws Exception
	{
		data=userService.findByNamePhone(name, phone, page, limit);
		this.total=data.size();
		this.success=true;
		this.msg="��ѯ���";
		return SUCCESS;
	}
	
	//����û���Ϣ
	public String addUser() throws Exception
	{
		userService.addUser(username, password, name
				, sex, address, postaddress
				, phone, email, tagtime);
		this.success=true;
		this.msg="�������";
		return SUCCESS;
	}
	
	//�޸��û���Ϣ
	public String updateUser() throws Exception
	{
		userService.updateUser(userid, username, password
				, name, sex, address
				, postaddress, phone, email
				, tagtime);
		this.success=true;
		this.msg="�޸ĳɹ�";
		return SUCCESS;
	}
	
}
