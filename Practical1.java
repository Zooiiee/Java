class Account {
    // Data Members - instance variables
    int acNo;
    String acName;
    double acBal;

    // Constructor - three arguments
    Account(int acNo, String acName, double acBal) {
        // 'this' keyword is used when instance variable and local variable have the same name
        this.acNo = acNo;
        this.acName = acName;
        this.acBal = acBal;
    }

    // Define getters and setters
    int getAcNo() {
        return this.acNo;
    }

    void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    String getAcName() {
        return this.acName;
    }

    void setAcName(String acName) {
        this.acName = acName;
    }

    double getAcBal() {
        return this.acBal;
    }

    void setAcBal(double acBal) {
        this.acBal = acBal;
    }

    // Utility methods

    // TO DEPOSIT
    void deposit(double amount) {
        this.acBal += amount;
    }

    // TO WITHDRAW
    boolean withdraw(double amount) {
        if (this.acBal - amount >= 0) {
            this.acBal -= amount;
            return true;
        } else {
            return false;
        }
    }

    // TO TRANSFER
    boolean transfer(Account target, double amount) {
        if (this.withdraw(amount)) {
            target.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
}

class P1Account {
    public static void main(String[] args) {
        Account a1 = new Account(101, "PQR", 3000);
        Account a2 = new Account(102, "ABC", 2000);

        System.out.println("***Account Information***");
        print(a1);

        a1.deposit(3000);
        System.out.println("Balance After Deposit: " + a1.getAcBal());

        if (a1.withdraw(3000)) {
            System.out.println("Successful Withdrawal");
        } else {
            System.out.println("Unsuccessful Withdrawal: Insufficient Funds");
        }

        System.out.println("Balance After Withdrawal: " + a1.getAcBal());

        if (a1.transfer(a2, 1000)) {
            System.out.println("Successful Transfer");
        } else {
            System.out.println("Unsuccessful Transaction: Insufficient Funds");
        }

        System.out.println("Balance After Transfer: " + a1.getAcBal());
        print(a2);
    }

    static void print(Account a) {
        System.out.println("\nAccount Number: " + a.getAcNo());
        System.out.println("Account Name: " + a.getAcName());
        System.out.println("Account Balance: " + a.getAcBal());
    }
}







//Employee Inheritance


class Employee {
    int eid;
    String ename;
    double salary;

    // Constructor
    Employee(int eid, String ename) {
        this.eid = eid;
        this.ename = ename;
    }

    // Getters
    int getEid() {
        return this.eid;
    }

    String getEname() {
        return this.ename;
    }

    double getSalary() {
        return this.salary;
    }

    // Utility methods
    void calSalary() {
        // To be overridden by subclasses
    }
}

class DailyWagesEmp extends Employee {
    double noOfDays;
    double dailyWages;

    // Constructor
    DailyWagesEmp(int eid, String ename, double noOfDays, double dailyWages) {
        super(eid, ename);
        this.noOfDays = noOfDays;
        this.dailyWages = dailyWages;
    }

    // Override calSalary
    @Override
    void calSalary() {
        salary = noOfDays * dailyWages;
    }
}

class PermanentEmp extends Employee {
    double basicSal;

    // Static Data Members
    static double DA = 164; // Dearness Allowance (percentage)
    static double HRA = 30; // House Rent Allowance (percentage)
    static double TA = 1600; // Travel Allowance (fixed amount)
    static double PF = 12.5; // Provident Fund (percentage)

    // Constructor
    PermanentEmp(int eid, String ename, double basicSal) {
        super(eid, ename);
        this.basicSal = basicSal;
    }

    // Override calSalary
    @Override
    void calSalary() {
        salary = basicSal + (basicSal * DA / 100) + (basicSal * HRA / 100) + TA - (basicSal * PF / 100);
    }
}

class P3EmployeeInheritance {
    public static void main(String[] args) {
        // Creating employees
        Employee d1 = new DailyWagesEmp(101, "Ayaan", 12, 200);
        d1.calSalary();
        print(d1);

        Employee p1 = new PermanentEmp(110, "Asish", 89000);
        p1.calSalary();
        print(p1);

        // Generalized implementation with an array of employees
        Employee[] emp = new Employee[3];
        emp[0] = new DailyWagesEmp(101, "Ayaan", 12, 200);
        emp[1] = new PermanentEmp(110, "Asish", 89000);
        emp[2] = new DailyWagesEmp(102, "Jayshree", 12, 500);

        for (Employee e : emp) {
            e.calSalary();
            print(e);
        }
    }

    // Static method to print employee details and salary
    static void print(Employee e) {
        System.out.println("\nEmployee Id: " + e.getEid());
        System.out.println("Employee Name: " + e.getEname());
        System.out.println("Employee Salary: " + e.getSalary());
    }
}


//array utility


import java.util.*;

class ArrayUtility
{
	int[] data;

	//Constructor
	ArrayUtility(int size)
	{
		//instantiate array
		data = new int[size];
	}

	//set data
	void setData(int[] data1)
	{	
		this.data = data1;
	}

	//Utility methods
	//Find Maximum
	int findMax()
    	{
        	int max = data[0];
        	for (int i = 1; i < data.length; i++)
        	{
            		if (data[i] > max)
            		{
                		max = data[i];
            		}
        	}
        	return max;
    	}

	//Find Minimun
	int findMin()
    	{
        	int min = data[0];
        	for (int i = 1; i < data.length; i++)
        	{
            		if (data[i] < min)
            		{
                		min = data[i];
            		}
        	}
        	return min;
    	}

	//Find Average/Mean
	double findAvg()
    	{
        	int sum =0;
        	for (int i: data) //implicit
        	{
            		sum += i;
        	}
        	return sum/data.length;
    	}

	//Find Standard Deviaton
	double findStandardDev()
    	{
		double sd=0;
        	double mean = findAvg();
        	for (int d: data) //implicit
        	{
            		sd += Math.pow(d-mean,2);
        	}
        	return Math.sqrt(sd/data.length);
    	}

}

class P4ArrayImpl
{
	public static void main(String[] args)
	{
		
		ArrayUtility a1 = new ArrayUtility(10);
		int data[]={10,23,45,68,12,23,56,76,23,79};
		a1.setData(data);
		System.out.println("The Maximum Element is: "+a1.findMax());
		System.out.println("The Minimum Element is: "+a1.findMin());
		System.out.println("The Average of the Array is: "+a1.findAvg());
		System.out.println("The Standard Deviation of the Array is: "+a1.findStandardDev());

	}

}
