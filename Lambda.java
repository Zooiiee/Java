//Calculator Interfaces without Lambda Expression
interface Calculator
{
	int add(int a, int b);
	int sub(int a, int b);
	int mul(int a, int b);
	int div(int a, int b);

}

class CalculatorImpl implements Calculator
{
	public int add(int a, int b)
	{
		return a+b;
	}
	public int sub(int a, int b)
	{
		return a-b;
	}
	public int mul(int a, int b)
	{
		return a*b;
	}
	public int div(int a, int b)
	{
		return a/b;
	}

}

class CalcDemo
{
	public static void main(String[] args)
	{
		Calculator c1 = new CalculatorImpl();
		System.out.println("Addition : "+c1.add(10,20));
		System.out.println("Subtraction : "+c1.sub(10,20));
		System.out.println("Multiplication : "+c1.mul(10,20));
		System.out.println("Division : "+c1.div(20,10));

	}

}


//Calculator Interfaces with Lambda Expression

//Lambda Implementation
interface Calculator1
{
	int op(int a, int b);
}

class Lambda
{
	public static void main(String[] args)
	{
		//Instantiate
		Calculator1 c1 = (int x, int y) -> x+y;
		Calculator1 c2 = (int x, int y) -> { return x-y; };
		Calculator1 c3 = (int x, int y) -> x*y;
		Calculator1 c4 = (int x, int y) ->  { return x/y; };
		
		//Call
		System.out.println("Addition : "+ c1.op(10,20));
		System.out.println("Subtraction : "+ c2.op(10,20));
		System.out.println("Multiplication : "+ c3.op(10,20));
		System.out.println("Division : "+ c4.op(30,5));
	}

}
