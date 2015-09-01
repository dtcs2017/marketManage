package action;

import java.io.BufferedReader;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.CommodityClassService;
import bean.CommodityClassBean;

import com.opensymphony.xwork2.ActionSupport;



public class CommodityClassAction extends ActionSupport 
{
	//ҵ���߼����
	private CommodityClassService commodityClassService;
	//��װCommodityClassBean
	private List<CommodityClassBean> data=new ArrayList<CommodityClassBean>();
	//����������������
	private boolean success;
	//���������������Ϣ
	private String msg;
	//����ͻ��˴���ĵ�ǰҳ����Ϣ
	private int page;
	//����ͻ��˴����ҳ����ʾ��Ŀ��Ϣ
	private int limit;
	//�����������ѯ������total��Ŀ
	private int total;
	//����������õ������Կͻ��˵�json�ַ���
	private String params;
	//���洫��������������������ڰ����Ʋ�ѯ
	private String name;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setParams(String params)
	{
		this.params=params;
	}
	
	public List<CommodityClassBean> getData() {
		return data;
	}
	public void setData(List<CommodityClassBean> data) {
		this.data = data;
	}
	
	public String getMsg() 
	{
		return msg;
	}
	
	public int getTotal() 
	{
		return total;
	}
	public void setTotal(int total)
	{
		this.total = total;
	}
	
	public void setPage(int page) 
	{
		this.page = page;
	}
	
	public void setLimit(int limit) 
	{
		this.limit = limit;
	}
	
	public boolean getSuccess()
	{
		return this.success;
	}
	
	public void setCommodityClassService(
			CommodityClassService commodityClassService) 
	{
		this.commodityClassService = commodityClassService;
	}
	
	//��ѯ������Ʒ������Ϣ��ҳ��ʾ
	public String allTypes() throws Exception{
		this.total=commodityClassService.findAllTypes().size();
		data=commodityClassService.findAllTypeByPaging(page, limit);
		if(data.size()>0)
		{
			this.success=true;
			this.msg="��ѯ�ɹ�";
		}else
		{
			this.success=false;
			this.msg="��Ǹ��û�в�ѯ������";
		}
		return SUCCESS;
	}
	
	//������Ʒ���Ʋ�ѯ��Ʒ������Ϣ��ҳ��ʾ
	public String allTypesByName() throws Exception
	{
		data=commodityClassService.findTypeByName(name);
		this.total=data.size();
		if(data.size()>0)
		{
			this.success=true;
			this.msg="��ѯ�ɹ�";
		}else
		{
			this.success=false;
			this.msg="��Ǹ��û�в鵽��Ҫ������";
		}
		return SUCCESS;
	}
	
	//������Ʒ��Ϣ
	public String updateType() throws Exception
	{
		
		params=getJsonString();
		JSONObject jsonObject = JSONObject.fromObject(params);
		int typeid=jsonObject.getInt("typeid");
		String typename=jsonObject.getString("typename");
		String typedesc=jsonObject.getString("typedesc");
		commodityClassService.updateType(typeid, typename, typedesc);
		this.success=true;
		this.msg="�޸ĳɹ�";
		return SUCCESS;
	}
	
	//������Ʒ������Ϣ�ķ���
	public String addType() throws Exception
	{
		params=getJsonString();
		JSONObject jsonObject = JSONObject.fromObject(params);
		String typename=jsonObject.getString("typename");
		String typedesc=jsonObject.getString("typedesc");
		commodityClassService.addType(typename,typedesc);
		this.success=true;
		this.msg="�����ɹ�";
		return SUCCESS;
	}
	
	//ɾ����Ʒ��Ϣ
	public String deleteType() throws Exception
	{
		params=getJsonString();
		JSONObject jsonObject = JSONObject.fromObject(params);
		String typename=jsonObject.getString("typename");
		int typeid=jsonObject.getInt("typeid");
		commodityClassService.deleteTypes(typeid, typename);
		this.success=true;
		this.msg="ɾ���ɹ�";
		return SUCCESS;
	}
	public String execute() throws Exception
	{
		this.success=true;
		return SUCCESS;
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
}
