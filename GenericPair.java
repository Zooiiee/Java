/*
Design a generic pair class that holds two values of different types override 2 string method to display both values in readable format
*/


class Pair<T,U>
{
	T key;
	U value;

	//constructor
	Pair(T key , U value)
	{
		this.key = key;
		this.value = value;
	}

	//setters and getters
	void setKey(T key)
	{
		this.key = key;
	}

	void setValue(U value)
	{
		this.value = value;
	}

	T getKey()
	{
		return key;
	}

	U getValue()
	{
		return value;
	}

   	public String toString() 
	{
		return "Key : "+key +" - Value : " + value;
	}

}
class GenericPair
{	
	public static void main(String[] args)
	{
		Pair<Integer, String> p1 = new Pair<Integer, String>(101,"BOOK");
		Pair<Integer, String> p2 = new Pair<Integer, String>(102,"JAVA");		
		System.out.println(p1);
		System.out.println(p2);
		
	}

}


/*

//Design a generic class to represent a box which can contain a single element of any data type.

class Box<T>
{
	//data member
	T item;
	
	//setters & getters
	void setItem(T item)
	{
		this.item=item;
	}

	T getItem()
	{
		return this.item;
	}
}

class BoxImpl
{
	public static void main(String[] args)
	{
		Box<Integer> b1 = new Box<>();
		b1.setItem(10);
		System.out.println("Integer Item : "+b1.getItem());

		Box<String> b2 = new Box<>();
		b2.setItem("Book");
		System.out.println("String Item : "+b2.getItem());

		Box<Float> b3 = new Box<>();
		b3.setItem(3.14f);
		System.out.println("Float Item : "+b3.getItem());

		Box<Double> b4 = new Box<>();
		b4.setItem(33.33);
		System.out.println("Double Item : "+b4.getItem());

	}
}


*/
