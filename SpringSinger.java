//Write a Program to Demonstrate dependency injection and bean scopes in a Spring application. -singleton prototype

//Singer.java

package edu.met.p1;

public class Singer
{
	int sid;
	String Sname;
	
	//Default Constructor
	public Singer()
	{
		
	}
	//Parameterized Constructor
	public Singer(int sid, String sname) {
		super();
		this.sid = sid;
		Sname = sname;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}
	
	@Override
	public String toString() {
		return "Singer [sid=" + sid + ", Sname=" + Sname + "]";
	}

}


//appctx.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans 
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans  
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
    <bean id="singer" class="edu.met.p1.Singer" scope="prototype">
    	<constructor-arg value="101"></constructor-arg>
    	<constructor-arg value="Om"></constructor-arg>
    </bean>
</beans>

//SingerImpl.java

package edu.met.p1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingerImpl {
	static ApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("appctx.xml");
		// Fetch two separate instances of the Singer bean
        Singer s1 = (Singer) ctx.getBean("singer");
        System.out.println("Initial State of s1: " + s1);

        Singer s2 = (Singer) ctx.getBean("singer");
        System.out.println("Initial State of s2: " + s2);

        // Modify the second bean's properties
        s2.setSid(102);
        s2.setSname("Neha");

        // Print both beans again
        System.out.println("\nAfter modifying s2:");
        System.out.println("s1: " + s1); // Should remain unchanged
        System.out.println("s2: " + s2); // Reflects the updated values


	}
}
