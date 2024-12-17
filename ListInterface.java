//javap java.util.List
//javap java.util.Set

//1) Create an ArrayList to perform various operations on it. 


import java.util.*;

class ArrayListDemo
{
	public static void main(String[] args)
	{
		//Creating an ArrayList
		ArrayList<Integer> marks = new ArrayList<>();
	
		//1. Add elements
		marks.add(45);
		marks.add(50);
		marks.add(34);
		marks.add(41);
		marks.add(39);
		System.out.println("Marks ArrayList : " + marks);
		
		//2. Get elements
		System.out.println("\nFirst Element in the ArrayList : " + marks.get(0));

		//3. Set elements
		marks.set(1,30);
		System.out.println("\nUpdated ArrayList : " + marks);

		//4.Remove elements
		System.out.println("\nElement Removed : " + marks.remove(4));
		
		//5. Iterating an ArrayList
		System.out.println("\nIterating the Array: ");
		for(int x : marks)
		{
			System.out.println(x);
		}
		
		//6. Size of the Array
		System.out.println("\nThe Size of the Array : " + marks.size());

		//7. isEmpty
		System.out.println("\nThe Array is Empty: " + marks.isEmpty());

	}
	
}







//2) Create an employee class. Sort employee objects on salary.


import java.util.*;

class Employee implements Comparator<Employee>
{

	int eid;
	String ename;
	double sal;

	Employee()
	{

	}

	Employee(int eid, String ename, double sal)
	{
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
	}

	//getters
	int getEid()
	{
		return eid;
	}
	
	String getEname()
	{
		return ename;
	}

	double getSal()
	{
		return sal;
	}

	//override toString method
	public String toString()
	{
		return "Employee Id : "+eid+ "	Employee Name : "+ename+"	Salary : "+sal +"\n";
	}

	//override compare Method
	public int compare(Employee e1, Employee e2)
	{
		return Double.compare(e1.getSal(),e2.getSal());
	}
}

class EmployeeSort
{
	public static void main(String[] args)
	{
		List<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.add(5);
		l1.add(8);
		l1.add(12);
		System.out.println("Before Sorting : "+l1);
		Collections.sort(l1);
		System.out.println("After Sorting : "+l1);

		List<Employee> emp= new ArrayList<>();
		emp.add(new Employee(1,"Priya",3000));
		emp.add(new Employee(2,"Iffah",3500));
		emp.add(new Employee(3,"Zoie",3900));
		emp.add(new Employee(4,"Anita",3400));
		emp.add(new Employee(5,"Srushti",2500));
		System.out.println("\nBefore Sorting : ");
		System.out.println(emp);
		Collections.sort(emp, new Employee());
		System.out.println("\nAfter Sorting : ");
		System.out.println(emp);

	}
}




//3) Create LinkedList and perform various operations on it.


import java.util.*;

class LinkedListDemo
{
	public static void main(String[] args)	
	{
		//Creating an Linkedlist
		LinkedList<Integer> list1 = new LinkedList<>();
		
		//1. Add elements
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		System.out.println("LinkedList : " + list1);

		//2. Adding Elements at Specific Positions
		list1.add(0,5);

		//3.Get elements
		System.out.println("\nFourth Element in the LinkedList : " + list1.get(4));

		//4. Set elements
		list1.set(1,8);
		System.out.println("\nUpdated LinkedList : " + list1);

		//5.Remove elements
		System.out.println("\nElement Removed : " + list1.remove(0));
		
		//6.Peek
		System.out.println("\nFirst Element in the LinkedList: " + list1.peek());
		System.out.println("LinkedList : " + list1);

		//7.Poll
		System.out.println("\nRetrieving and Removing the First Element in the LinkedList: " + list1.poll());
		System.out.println("LinkedList : " + list1);
		
		//8.Pop
		System.out.println("\nRemoving First Element in the LinkedList: " + list1.pop());
		System.out.println("LinkedList : " + list1);
			
		//9.PeekLast
		System.out.println("\nLast Element in the LinkedList: " + list1.peekLast());
		System.out.println("LinkedList : " + list1);

		//10.PollLast
		System.out.println("\nRetrieving and Removing the Last Element in the LinkedList: " + list1.pollLast());
		System.out.println("LinkedList : " + list1);

	}
}




//4) Create HashSet and Perform Set operations


import java.util.*;

class HashSetDemo
{
	public static void main(String[] args)	
	{
	
		//Creating HashSets
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();

		//1. Add elements	
		//set1
		set1.add(2);
		set1.add(5);
		set1.add(8);
		set1.add(10);
		set1.add(12);
		//set2
		set2.add(1);
		set2.add(4);
		set2.add(5);
		set2.add(11);

		System.out.println("Set 1 : "+set1);
		System.out.println("Set 2 : "+set2);

	
		//2. Set Operations

		//a) Union
		set1.addAll(set2);
		System.out.println("\nUnion : " + set1);

		//d) Difference
		set1.removeAll(set2);
		System.out.println("\nSet1 - Set2 : " + set1);

		set1.add(5);

		//c) Intersection
		set1.retainAll(set2);
		System.out.println("\nIntersection: " + set1);
	}
}
