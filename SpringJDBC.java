//Write a Program in Spring JDBC to Insert & Select Records from the Employee Table.

//EmployeeBean.java

package edu.met.p1;

public class EmployeeBean {
	
	int eid;
	String ename;
	int salary;
	
	public EmployeeBean(int eid, String ename, int salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	
	public EmployeeBean() {

	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [Eid=" + eid + ", Ename=" + ename + ", Salary=" + salary + "]";
	}
	
}


//AppCtx.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans 
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans  
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
               
    <bean id="empbean" class="edu.met.p1.EmployeeBean">
    	<constructor-arg value="105"></constructor-arg>
    	<constructor-arg value="Khushi Patel"></constructor-arg>
    	<constructor-arg value="8000"></constructor-arg>
    </bean>
    
    <bean id="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    	<property name="driverClassName" value="org.postgresql.Driver"></property>
    	<property name="url" value="jdbc:postgresql://localhost:5432/postgres"></property>
    	<property name="username" value="postgres"></property>
    	<property name="password" value="password"></property>
    </bean>
    
    <bean id="jdbcT" class="org.springframework.jdbc.core.JdbcTemplate">
    	<property name="dataSource" ref="ds"></property>
    </bean>
    
    <bean id="empD" class="edu.met.p1.EmployeeDao">
		<constructor-arg ref="jdbcT"></constructor-arg>
	</bean>
         
</beans>


//EmployeeDao.java

package edu.met.p1;
import java.sql.*;
import java.util.List;
import org.springframework.jdbc.core.*;

public class EmployeeDao {
	
	JdbcTemplate jdbcT;

	public EmployeeDao(JdbcTemplate jdbcT) {
		super();
		this.jdbcT = jdbcT;
	}
	
	public int saveEmp(EmployeeBean e1)
	{
		String ins = "Insert into employee values("+e1.getEid()+",'"+e1.getEname()+"',"+e1.getSalary()+")";
		return jdbcT.update(ins);
	}	
	
	public List<EmployeeBean> getAll()
	{
		String selQ="Select * from employee";
		return jdbcT.query(selQ, new EmployeeRowMapper());
	}

}


//EmployeeMain.java

package edu.met.p1;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
	static ApplicationContext ctx;
	public static void main(String[] args) 
	{
		ctx = new ClassPathXmlApplicationContext("AppCtx.xml");
		EmployeeBean e1 =(EmployeeBean)ctx.getBean("empbean");
		EmployeeDao ed =(EmployeeDao)ctx.getBean("empD");
		System.out.println(ed.saveEmp(e1)+" Inserted");
		
		List<EmployeeBean> elist = ed.getAll();
		System.out.println("Eid\tEname\t\tSalary");
		for(EmployeeBean e:elist)
		{
			System.out.println(e.getEid()+"\t"+e.getEname()+"\t" + e.getSalary());
		}
	}

}


//EmployeeRowMapper.java

package edu.met.p1;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<EmployeeBean> {

	@Override
	public EmployeeBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		EmployeeBean temp = new EmployeeBean();
		temp.setEid(arg0.getInt(1));
		temp.setEname(arg0.getString(2));
		temp.setSalary(arg0.getInt(3));
		return temp;
	}

}


