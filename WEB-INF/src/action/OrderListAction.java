package action;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;

import service.OrderListService;
import bean.OrderListBean;

import com.opensymphony.xwork2.ActionSupport;

public class OrderListAction extends ActionSupport
{
	//ҵ���߼����
	private OrderListService orderlistservice;
	//��װbean
	List<OrderListBean> data;
	//��װjson��ʽ�Ĳ���
	private String params;
	//��װ��Ӧ״̬�Ĳ���
	private boolean success;
	private String msg;
	
	
	public boolean isSuccess() 
	{
		return success;
	}
	public void setSuccess(boolean success)
	{
		this.success = success;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public void setOrderlistservice(OrderListService orderlistservice)
	{
		this.orderlistservice = orderlistservice;
	}
	public List<OrderListBean> getData() 
	{
		return data;
	}
	public void setData(List<OrderListBean> data)
	{
		this.data = data;
	}
	public String getParams()
	{
		return params;
	}
	public void setParams(String params) 
	{
		this.params = params;
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
		
		//��������������Ϣ�ķ���
	public String addOrderList() throws Exception
		{
			//��ȡjson����
			params=getJsonString();
			JSONArray jsonArray=null;
			try
			{
				jsonArray=JSONArray.fromObject(params);
				for(int i=0;i<jsonArray.size();i++)
				{
					JSONObject jsonobject=jsonArray.getJSONObject(i);
					int commodityid=jsonobject.getInt("commodityid");
					int orderformid=jsonobject.getInt("orderformid");
					int amount=jsonobject.getInt("amount");
					orderlistservice.addOrderList(orderformid, commodityid, amount);
				}
			}catch(JSONException e)
			{
				e.printStackTrace();
			}
			
			
			this.success=true;
			this.msg="�����ɹ�";
			return SUCCESS;
		}
}
