import java.util.*;

class MyStack<T>
{
	//instance var to store data
	ArrayList<T> data;
	//size of stack
	int size;
	//pointer
	int tos =-1;
	
	MyStack(int size)
	{
		this.size = size;
		data=new ArrayList<>(size);
	}

	void push(T el)
	{
		tos++;
		if(tos<size)
		{
			//push
			data.add(tos,el);
			System.out.println("Pushed : "+el);


		}
		else
		{
			//overflow
			System.out.println("Overflow!");
		}
	}

	T pop()
	{
		tos--;
		if(tos>=0)
		{
			//pop
			return data.remove(tos);
		}
		else
		{
			//underflow
			System.out.println("Underflow!");
			return null;
		}

	}
}

class GenericStack
{
	public static void main(String[] args)
	{
		MyStack<Integer> s1 = new MyStack<>(3);
		//push
		for(int i=0; i<=3; i++)
		{
			s1.push(i*10+10);
		}
	
		//pop
		for(int i=0; i<=3; i++)
		{
			System.out.println("Popped : "+s1.pop());
		}

		
	}
}
