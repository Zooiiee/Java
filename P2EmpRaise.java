import java.util.ArrayList;

class Employee {
    String fname;
    String lname;
    double monSal;

    // To store all employees
    static ArrayList<Employee> employees = new ArrayList<>();

    Employee(String fname, String lname, double monSal) {
        this.fname = fname;
        this.lname = lname;
        if (monSal < 0) {
            this.monSal = 0.0;
        } else {
            this.monSal = monSal;
        }
        // Add the current employee to the list
        employees.add(this);
    }

    // Getters and setters
    String getFname() {
        return this.fname;
    }

    void setFname(String fname) {
        this.fname = fname;
    }

    String getLname() {
        return this.lname;
    }

    void setLname(String lname) {
        this.lname = lname;
    }

    double getMonSal() {
        return this.monSal;
    }

    void setMonSal(double monSal) {
        if (monSal < 0) {
            this.monSal = 0.0;
        } else {
            this.monSal = monSal;
        }
    }

    // Utility methods

    // Method to calculate Annual Salary
    double annualSal() {
        return 12 * this.monSal;
    }

    // Static method to give all employees a 10% raise
    public static void giveAllRaise() {
        for (Employee emp : employees) {
            emp.monSal += emp.monSal * 0.10;
        }
    }
}

class P2EmpRaise{
    public static void main(String[] args) {
        Employee e1 = new Employee("Asish", "Jadhav", 10000);
        Employee e2 = new Employee("Jayshree", "Jha", 16000);

        System.out.println("*** Employee Details ***");

        // Employee's yearly salary before the raise
        System.out.println("Before raise:");
        print(e1);
        print(e2);

        // Give all employees a 10% raise using the static method
        Employee.giveAllRaise();

        System.out.println("\nAfter 10% raise:");
        print(e1);
        print(e2);
    }

    // Static method to print employee details & Annual Salary
    static void print(Employee e) {
        System.out.println("\nEmployee First Name: " + e.getFname());
        System.out.println("Employee Last Name: " + e.getLname());
        System.out.println("Employee Annual Salary: " + e.annualSal());
    }
}
