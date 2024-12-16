//AOP STEPS - AspectJ project , springlib add library


//BankAccount.java

package edu.met.p1;

public class BankAccount {
	int acno;
	String acname;
	double acbal;
	
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public double getAcbal() {
		return acbal;
	}
	public void setAcbal(double acbal) {
		this.acbal = acbal;
	}
	//default Constructor
	public BankAccount() 
	{
		
	}
	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", acname=" + acname + ", acbal=" + acbal + "]";
	}
	//deposit
	public void deposit(double amt)
	{
		System.out.println("Amount Deposited");
		this.acbal+=amt;
	}
	//withdraw
	public void withdraw(double amt)
	{
		if(this.acbal-amt >= 0)
		{
			System.out.println("Amount Withdrawn");
			this.acbal-=amt;
		}
		else
		{
			throw new RuntimeException();
		}	
	}
	
}




//BankAspect.java 

package edu.met.p1;
import org.aspectj.lang.annotation.*;
@Aspect
public class BankAspect {
	//define a join Point
	@Pointcut("execution(* edu.met.p1.BankAccount.set*(..))")
	public void getPC() {}
	@Before("getPC()")
	public void beforeMethod()
	{
		System.out.println("Set is Getting Called : Before");
	}
	@After("getPC()")
	public void afterMethod()
	{
		System.out.println("Set is Getting Called : After");
	}
	//join point for withdraw
	@Pointcut("execution(* edu.met.p1.BankAccount.withdraw*(..))")
	public void getW() {}
	//advice for successful withdrawl
	@AfterReturning("getW()")
	public void afterRet()
	{
		System.out.println("Withdrawal Successful!!!");
	}
	@AfterThrowing("getW()")
	public void afterEx()
	{
		System.out.println("Withdrawal Unsuccessful!!!");
	}

}




//AppCtx.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:aop="http://www.springframework.org/schema/aop"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/aop
 http://www.springframework.org/schema/aop/spring-aop.xsd">
<aop:aspectj-autoproxy /> 
	<bean id="acBean" class="edu.met.p1.BankAccount">
		<property name="acno" value="101"></property>
		<property name="acname" value="Zoya"></property>
		<property name="acbal" value="2000"></property>
	</bean>
</beans>



//BankMain.java

package edu.met.p1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankMain {
	static ApplicationContext ctx;
	public static void main(String[] args) {
		ctx= new ClassPathXmlApplicationContext("AppCtx.xml");
		BankAccount b1 = (BankAccount)ctx.getBean("acBean");
		System.out.println(b1);
b1.withdraw(3000);
		System.out.println("\nAfter :"+b1);
	}

}
