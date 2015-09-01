package action;

import java.io.BufferedReader;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.AdminService;
import bean.AdminBean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import domain.Admin;

public class AdminAction extends ActionSupport
{
	//��װҵ���߼����
	private AdminService adminService;
	private List<AdminBean> data;
	//����������õ������Կͻ��˵�json�ַ���
	private String params;
	//���洫��������������������ڰ����Ʋ�ѯ
	private int adminid;
	private String username;
	private String password;
	private String sex;
	private Date hireday;
	//��װ�������ݵ�����
	private boolean success;
	private String msg;
	public List<AdminBean> getData()
	{
		return data;
	}
	public boolean isSuccess()
	{
		return success;
	}
	public String getMsg() 
	{
		return msg;
	}
	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}
	
	public String getParams() 
	{
		return params;
	}
	public void setParams(String params) 
	{
		this.params = params;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String name) 
	{
		this.username = name;
	}
	
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getSex() 
	{
		return sex;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}
	public Date getHireday() 
	{
		return hireday;
	}
	public void setHireday(Date hireday) 
	{
		this.hireday = hireday;
	}
	public void setAdminid(int adminid)
	{
		this.adminid=adminid;
	}
	public int getAdminid()
	{
		return this.adminid;
	}
	
		//���������������Ϊjson��ʽ��gerJsonString()Ϊ��ȡjson�ַ�������
		private String getJsonString()
		{
			HttpServletRequest request=ServletActionContext.getRequest();
			StringBuffer jsonString=new StringBuffer();
			char[] ch=new char[2048];
			int length=-1;
			try
			{
				BufferedReader br=request.getReader();
				while((length=br.read(ch))!= -1)
				{
					jsonString.append(new String(ch, 0, length));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return jsonString.toString();
		}
	//��¼��֤�ķ���
	public String login() throws Exception
	{
		boolean out=adminService.isAdmin(username, password);
		if(out)
		{
			this.success=true;
			this.msg="���ѳɹ���¼";
			return Action.SUCCESS;
		}else
		{
			this.success=false;
			this.msg="�û��������벻ƥ��";
			return Action.SUCCESS;
		}
	}
	
	//ע��ķ���
	public  String addAdmin() throws Exception
	{
		adminService.addAdmin(username, sex, hireday, password);
		this.success=true;
		this.msg="��ӳɹ�";
		return SUCCESS;
	}
	
	//�����Ʋ���Ա����Ϣ
	public  String findadminByName() throws Exception
	{
		data=adminService.findByName(username);
		this.success=true;
		this.msg="��ӳɹ�";
		return SUCCESS;
	}
	
	//�������е�Ա����Ϣ
	public  String findAlladmin() throws Exception
	{
		data=adminService.findallAdmin();
		this.success=true;
		this.msg="��ӳɹ�";
		return SUCCESS;
	}
	
	//����Ա����Ϣ
	public String updateAdmin() throws Exception
	{
		adminService.updateAdmin(adminid, username, sex, hireday, password);
		this.success=true;
		this.msg="���³ɹ�";
		return SUCCESS;
	}
	
	//ɾ��Ա����Ϣ
	public String deleteAdmin() throws Exception
		{
			adminService.deleteAdmin(adminid);
			this.success=true;
			this.msg="ɾ���ɹ�";
			return SUCCESS;
		}
}
