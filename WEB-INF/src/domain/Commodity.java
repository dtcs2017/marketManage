package domain;

/**
 * Commodity���ǳ־û�����Ʒʵ����
 */
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="COMMODITY",schema="SCOTT")
public class Commodity implements Serializable {
	
	//��Ӧ����
	@Id
	@GeneratedValue(generator="commodityPkGenerator")
	@GenericGenerator(name="commodityPkGenerator",strategy="increment")
	@Column(name="COMMODITYID")
	private Integer commodityid;
	
	//�������Ʒʵ���������Ʒ����ʵ��
	@ManyToOne(targetEntity=domain.CommodityClass.class)
	//ָ������У�������Ϊ��
	@JoinColumn(name="COMMODITYCLASS_REF",nullable=false)
	private CommodityClass type;
	@Column(name="COMMODITYNAME",nullable=false)
	private String commodityname;
	@Column(name="MANUFACTURER",nullable=false)
	private String manufacture;
	@Column
	private String commoditydesc;
	@Column(name="COMMODITYPRICE",nullable=false)
	private Double commodityprice;
	@Column
	private Double fcprice;
	@Column(name="COMMODITYAMOUNT",nullable=false)
	private Integer commodityamount;
	@Column
	private Integer commodityleavenum;
	@Column(nullable=false)
	private Date tagtime;
	@Column(name="IMAGE")
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private Blob image;
	
	public Integer getCommodityid() 
	{
		return commodityid;
	}
	public void setCommodityid(Integer commodityid) 
	{
		this.commodityid = commodityid;
	}
	public CommodityClass getType() 
	{
		return type;
	}
	public void setType(CommodityClass type)
	{
		this.type = type;
	}
	public String getCommodityname()
	{
		return commodityname;
	}
	public void setCommodityname(String commodityname)
	{
		this.commodityname = commodityname;
	}
	public String getManufacture() 
	{
		return manufacture;
	}
	public void setManufacture(String manufacture) 
	{
		this.manufacture = manufacture;
	}
	public String getCommoditydesc() 
	{
		return commoditydesc;
	}
	public void setCommoditydesc(String commoditydesc)
	{
		this.commoditydesc = commoditydesc;
	}
	public Double getCommodityprice() 
	{
		return commodityprice;
	}
	public void setCommodityprice(Double commodityprice) 
	{
		this.commodityprice = commodityprice;
	}
	public Double getFcprice()
	{
		return fcprice;
	}
	public void setFcprice(Double fcprice) 
	{
		this.fcprice = fcprice;
	}
	public Integer getCommodityamount() 
	{
		return commodityamount;
	}
	public void setCommodityamount(Integer commodityamount)
	{
		this.commodityamount = commodityamount;
	}
	public Integer getCommodityleavenum() 
	{
		return commodityleavenum;
	}
	public void setCommodityleavenum(Integer commodityleavenum)
	{
		this.commodityleavenum = commodityleavenum;
	}
	public Date getTagtime() 
	{
		return tagtime;
	}
	public void setTagtime(Date regtime) 
	{
		this.tagtime = regtime;
	}
	public Blob getImage() 
	{
		return image;
	}
	public void setImage(Blob image) 
	{
		this.image = image;
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commodityname == null) ? 0 : commodityname.hashCode());
		result = prime * result
				+ ((commodityprice == null) ? 0 : commodityprice.hashCode());
		result = prime * result
				+ ((manufacture == null) ? 0 : manufacture.hashCode());
		result = prime * result + ((tagtime == null) ? 0 : tagtime.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Commodity)) {
			return false;
		}
		Commodity other = (Commodity) obj;
		if (commodityname == null) {
			if (other.commodityname != null) {
				return false;
			}
		} else if (!commodityname.equals(other.commodityname)) {
			return false;
		}
		if (commodityprice == null) {
			if (other.commodityprice != null) {
				return false;
			}
		} else if (!commodityprice.equals(other.commodityprice)) {
			return false;
		}
		if (manufacture == null) {
			if (other.manufacture != null) {
				return false;
			}
		} else if (!manufacture.equals(other.manufacture)) {
			return false;
		}
		if (tagtime == null) {
			if (other.tagtime != null) {
				return false;
			}
		} else if (!tagtime.equals(other.tagtime)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}
}
