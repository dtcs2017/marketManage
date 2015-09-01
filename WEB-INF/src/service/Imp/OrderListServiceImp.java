package service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

import bean.OrderFormBean;
import bean.OrderListBean;
import service.OrderListService;
import dao.Imp.CommodityDaoImp;
import dao.Imp.OrderFormDaoImp;
import dao.Imp.OrderListDaoImp;
import domain.Commodity;
import domain.OrderForm;
import domain.OrderList;
import domain.User;

public class OrderListServiceImp implements OrderListService
{
	private OrderListDaoImp orderlistdaoimp;
	private OrderFormDaoImp orderformdapimp;
	private CommodityDaoImp commoditydaoimp;
	public OrderListDaoImp getOrderlistdaoimp() 
	{
		return orderlistdaoimp;
	}
	public void setOrderlistdaoimp(OrderListDaoImp orderlistdaoimp) 
	{
		this.orderlistdaoimp = orderlistdaoimp;
	}
	public OrderFormDaoImp getOrderformdapimp()
	{
		return orderformdapimp;
	}
	public void setOrderformdapimp(OrderFormDaoImp orderformdapimp) 
	{
		this.orderformdapimp = orderformdapimp;
	}
	public CommodityDaoImp getCommoditydaoimp() 
	{
		return commoditydaoimp;
	}
	public void setCommoditydaoimp(CommodityDaoImp commoditydaoimp) 
	{
		this.commoditydaoimp = commoditydaoimp;
	}
	
	//ͨ��������id��ѯ����������Ϣ������
	public List<OrderListBean> findByFormid(int orderformid) throws Exception 
	{
		List<OrderListBean> list=new ArrayList<OrderListBean>();
		List<OrderList> result=new ArrayList<OrderList>();
		result=orderlistdaoimp.findListByformid(orderformid);
		if(result.size()>0)
		{
			for (OrderList u : result) 
			{
				list.add(new OrderListBean(u.getOrderlistid(), u.getCommodity().getCommodityname()
						, u.getCommodity().getCommodityid(), u.getOrderformid().getOrderformid()
						, u.getAmount()));
			}
		}else
		{
			throw new Exception("û�в�ѯ������");
		};
		return list;
	}
	
	/**
	 * ���Ӷ������飬
	 * 1.�˷���ʵ�ֵ�ͬʱҪͬ���ĸ���orderfrom���ܼ۸��֧�����
	 * 2.�˷���ʵ�ֵ�ͬʱҪͬ������commodity��ʣ������
	 */
	public void addOrderList(int orderformid, int commodityid, int amount) 
	{
		
		Commodity comm=commoditydaoimp.findById(commodityid);
		comm.setCommodityleavenum(comm.getCommodityleavenum()-amount);
		
		OrderForm of=orderformdapimp.findByid(orderformid);
		double totalprice=of.getTotalprice()+comm.getCommodityprice()*amount;
		of.setTotalprice(totalprice);
		
		OrderList list=new OrderList();
		list.setAmount(amount);
		list.setCommodity(comm);
		list.setOrderformid(of);
		

		orderlistdaoimp.addList(list);
		commoditydaoimp.update(comm);
		orderformdapimp.update(of);
	}
	
	public void updateList(int orderlistid, int orderformid, int commodityid,
			int amount)
	{
		Commodity comm=commoditydaoimp.findById(commodityid);
		comm.setCommodityleavenum(comm.getCommodityleavenum()-amount);
		commoditydaoimp.update(comm);
		 
		OrderForm of=orderformdapimp.findByid(orderformid);
		of.setTotalprice(comm.getCommodityprice()*amount);
		
		OrderList list=new OrderList();
		list.setAmount(amount);
		list.setCommodity(comm);
		list.setOrderformid(of);
		orderlistdaoimp.updateList(list);
		
	}
	@Override
	public void deleteList(int orderlistid) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
