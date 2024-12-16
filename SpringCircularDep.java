//Circular Dependency


//ClassA.java

package edu.met.p1;

public class ClassA {

		ClassB b;
		public ClassA(ClassB b)
		{
			this.b=b;
		}
}


//ClassB.java

package edu.met.p1;

public class ClassB {
	ClassA a;
	public ClassB(ClassA a)
	{
		this.a=a;
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
    <bean id="beanA" class="edu.met.p1.ClassA">
    	<constructor-arg name="b" ref="beanB"></constructor-arg>
    </bean>
    
    <bean id="beanB" class="edu.met.p1.ClassB">
    	<constructor-arg name="a" ref="beanA"></constructor-arg>
    </bean>
</beans>


//CircularTest.java

package edu.met.p1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CircularTest {
	static ApplicationContext ctx;
	public static void main(String[] args) 
	{	
		ctx = new ClassPathXmlApplicationContext("AppCtx.xml");
		ClassA a1 = (ClassA)ctx.getBean("beanA");
		ClassB b1 = (ClassB)ctx.getBean("beanB");
	}
}

//OUTPUT : Circular Dependency Error




//Circular Dependency Resolution


//ClassC.java

package edu.met.p1;

public class ClassC {
	ClassD d;
	public ClassC()
	{
		System.out.println("Constructor C");
	}
	public void setD(ClassD d)
	{
		this.d=d;
		System.out.println("Inside Class C");
	}
}



//ClassD.java

package edu.met.p1;

public class ClassD {
	ClassC c;
	public ClassD()
	{
		System.out.println("Constructor D");
	}
	public void setC(ClassC c)
	{
		this.c=c;
		System.out.println("Inside Class D");
	}
}



//AppCtx.xml

<beans 
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans  
               http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
    <bean id="beanA" class="edu.met.p1.ClassA" lazy-init="true">
    	<constructor-arg name="b" ref="beanB"></constructor-arg>
    </bean>
    
    <bean id="beanB" class="edu.met.p1.ClassB" lazy-init="true">
    	<constructor-arg name="a" ref="beanA"></constructor-arg>
    </bean>
    
    <bean id="beanC" class="edu.met.p1.ClassC">
    	<property name="d" ref="beanD"></property>
    </bean>
    
    <bean id="beanD" class="edu.met.p1.ClassD">
    	<property name="c" ref="beanC"></property>
    </bean>
</beans>


//CircularTest.java

package edu.met.p1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularTest {
	static ApplicationContext ctx;
	public static void main(String[] args) 
	{	
		ctx = new ClassPathXmlApplicationContext("AppCtx.xml");
		//ClassA a1 = (ClassA)ctx.getBean("beanA");
		//ClassB b1 = (ClassB)ctx.getBean("beanB");
		
		ClassC c1 = (ClassC)ctx.getBean("beanC");
		ClassD d1 = (ClassD)ctx.getBean("beanD");
	}
}
