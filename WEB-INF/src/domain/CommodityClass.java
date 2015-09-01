package domain;

/**
 * CommodityClass���ǳ־û�������Ʒ������Ϣʵ����
 * @author Ma
 */
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="COMMODITYCLASS",schema="SCOTT")
public class CommodityClass implements Serializable 
{

	//��Ʒ����ı��
	@Id
	@GeneratedValue(generator="typePkGenerator")
	@GenericGenerator(name="typePkGenerator",strategy="increment")
	@Column(name="COMMODITYCLASSID")
	private Integer typeid;
	
	//��Ʒ��������
	@Column(name="COMMODITYCLASSNAME",length=30,nullable=false)
	private String typename;
	
	//��Ʒ��������
	@Column(name="COMMODITYCLASSDESC",length=50,nullable=true)
	private String typedesc;
	
	//�������Ʒ����ʵ�������������е���Ʒʵ��
	@OneToMany(targetEntity=domain.Commodity.class)
	//���������
	@JoinColumn(name="COMMODITYCLASS")
	private Set<Commodity> commoditys=new HashSet<Commodity>();
	
	public Integer getTypeid()
	{
		return typeid;
	};
	public String getTypename() 
	{
		return typename;
	}
	public void setTypename(String typename) 
	{
		this.typename = typename;
	}
	public String getTypedesc() 
	{
		return typedesc;
	}
	public void setTypedesc(String typedesc) 
	{
		this.typedesc = typedesc;
	}
	public Set<Commodity> getCommoditys() 
	{
		return commoditys;
	}
	public void setCommoditys(Set<Commodity> commoditys) 
	{
		this.commoditys = commoditys;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((typename == null) ? 0 : typename.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CommodityClass)) {
			return false;
		}
		CommodityClass other = (CommodityClass) obj;
		if (typename == null) {
			if (other.typename != null) {
				return false;
			}
		} else if (!typename.equals(other.typename)) {
			return false;
		}
		return true;
	}
	
}
