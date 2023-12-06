package Springboot_CRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee_Table")

public class EntityClass
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String name;
	private String city;
	
	public Long getEmpId() 
	{
		return empId;
	}
	
	public void setEmpId(Long empId)
	{
		this.empId = empId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city) 
	{
		this.city = city;
	}

	@Override
	public String toString() 
	{
		return "EntityClass [empId=" + empId + ", name=" + name + ", city=" + city + "]";
	}
}
