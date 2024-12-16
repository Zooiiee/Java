//1.Simple Spring Boot application that prints a message.
//add - H2, JDBC API, Postgre SQLDriver, Spring Boot dev tool, spring data JDBC , Spring react web, , spring web, spring web services
//GreetingAppApplication.java

package edu.met.p1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//does auto configuration 
public class GreetingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingAppApplication.class, args);
	}

}


//GreetingController.java

package edu.met.p1;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController 
{
	@GetMapping("/")
	public String WelcomeMessage()
	{
		return "<HTML><BODY><H1>Welcome to MET!!!</H1></HTML></BODY";	//micro webservice
	}
	
	@GetMapping("/user")
	public String WelcomeMessage1()
	{
		return "<HTML><BODY><H1>Hello Zoiee<br></br>Welcome to MET!!!</H1></HTML></BODY";	//micro webservice
	}
}


//2.Product Application using Spring Boot & Database Connectivity


//Product.java

package edu.met.p1;

public class Product 
{
	int pid;
	String pname;
	int price;
	//Setters & Getters
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//Constructors
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, int price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	
}


//ProductRowMapper.java

package edu.met.p1;
import java.sql.*;
import org.springframework.jdbc.core.*;

public class ProductRowMapper implements RowMapper<Product>
{
	@Override
	public Product mapRow(ResultSet arg0, int arg1) throws SQLException 
	{
		Product p1 = new Product();
		p1.setPid(arg0.getInt(1));
		p1.setPname(arg0.getString(2));
		p1.setPrice(arg0.getInt(3));
		return p1;
	}
}


//ProductDao.java

package edu.met.p1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao 
{
	@Autowired
	JdbcTemplate jdbcT;
	
	//Fetch all Rows
	public List<Product> getAll()
	{
		String sql = "Select * from products";
		return jdbcT.query(sql, new ProductRowMapper());
	}

	public List<Product> getById(String id) {
		String sql = "Select * from products WHERE pid ="+Integer.parseInt(id);
		return jdbcT.query(sql, new ProductRowMapper());
	}
	
	public List<Product> deleteById(String id) {
		String sql = "DELETE from products WHERE pid ="+Integer.parseInt(id);
		return jdbcT.query(sql, new ProductRowMapper());
	}

}


//ProductController.java

package edu.met.p1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController 
{
	@Autowired
	ProductDao pd;
	
	@GetMapping("/product")
	public List<Product> getAllProducts()
	{
		return pd.getAll();
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public List<Product> getById(@PathVariable("id")String id)
	{
		return pd.getById(id);
	}

@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public List<Product> deleteById(@PathVariable("id")String id)
	{
		return pd.deleteById(id);
	}
}


//ProductApplication.java

package edu.met.p1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}


//application.properties

spring.application.name=ProductApplication
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password


