package action;

import java.sql.Date;
import java.util.List;

import service.CommodityService;
import bean.CommodityBean;

import com.opensymphony.xwork2.ActionSupport;

import domain.Commodity;

public class CommodityAction extends ActionSupport 
{
	//���õ�ҵ���߼�����ӿ�
	private CommodityService commodityService;
	//�������������data
	private List<CommodityBean> data;
	//��ѯ����
	private int commodityid;
	private String commodityname; 
	private String manufacture;
	private int typeid;
	private String commoditydesc;
	private int commodityamount;
	private Double commodityprice;
	private Double fcprice;
	private Date tagtime;
	//��ҳ����
	private int page;
	private int limit;
	private int total;
	//��ʾ��Ϣ�Ĳ���
	private boolean success;
	private String msg;
	
	//�������Ե�geter/seter����
	public void setCommodityService(CommodityService commodityService) 
	{
		this.commodityService = commodityService;
	}

	public List<CommodityBean> getData() 
	{
		return data;
	}

	public void setData(List<CommodityBean> data)
	{
		this.data = data;
	}
	
	public void setCommodityid(int id)
	{
		this.commodityid=id;
	}

	public void setCommodityname(String commodityname) 
	{
		this.commodityname = commodityname;
	}

	public void setManufacture(String manufacture) 
	{
		this.manufacture = manufacture;
	}

	public void setTypeid(int typeid) 
	{
		this.typeid = typeid;
	}

	public void setCommoditydesc(String commoditydesc) 
	{
		this.commoditydesc = commoditydesc;
	}

	public void setCommodityamount(int commodityamount)
	{
		this.commodityamount = commodityamount;
	}

	public void setCommodityprice(Double commodityprice) 
	{
		this.commodityprice = commodityprice;
	}

	public void setFcprice(Double fcprice) 
	{
		this.fcprice = fcprice;
	}

	public void setTagtime(Date tagtime) 
	{
		this.tagtime = tagtime;
	}

	public void setPage(int page) {
		
		this.page = page;
	}

	public void setLimit(int limit) 
	{
		this.limit = limit;
	}

	public int getTotal() 
	{
		return total;
	}

	public void setTotal(int total) 
	{
		this.total = total;
	}

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

	//ʵ�ָ���name��typeid���������̵Ĳ�ѯ����
	public String findByNameOTypeOManu() throws Exception
	{
		data=commodityService.findByNameTypeManu(commodityname, typeid, manufacture, page, limit);
		this.total=data.size();
		if(this.total>0)
		{
			this.success=true;
			this.msg="��ѯ���";
			return SUCCESS;
		}else
		{
			this.success=false;
			this.msg="��ѯ���û����Ҫ������";
			return ERROR;
		}
	}
	
	//ʵ����Ӳ�Ʒ��Ϣ�ķ���
	public String addCommodity() throws Exception
	{
		commodityService.addCommodity(commodityname, commoditydesc, manufacture, 
				commodityamount, typeid, commodityprice, fcprice, tagtime);
		this.success=true;
		this.msg="��ӳɹ�";
		return SUCCESS;
	}
	
	//ʵ���޸Ĳ�Ʒ��Ϣ�ķ���
	public String updateCommodity() throws Exception
	{
		commodityService.updateCommodity(commodityid, typeid, commodityname, manufacture
				, commoditydesc, commodityamount, commodityprice, fcprice, tagtime);
		this.success=true;
		this.msg="�޸ĳɹ�";
		return SUCCESS;
	}
	
	//ʵ��ɾ����Ʒ��Ϣ�ķ���
	public String deleteCommodity() throws Exception
	{
		commodityService.deleteCommodity(commodityid);
		this.success=true;
		this.msg="ɾ���ɹ�";
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		return SUCCESS;
	}

	
}
