package Java.Intermediate;

import java.util.*;

public class StacksPushPop {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		printStack(stack);
		stack.push("bottom"); // push puts items to the top of the stack
		printStack(stack);
		stack.push("seond");
		printStack(stack);
		stack.push("third");
		printStack(stack);
		
		stack.pop(); // the topmost item gets removed
		printStack(stack);
		stack.pop();
		printStack(stack);
		stack.pop();
		printStack(stack);
	}
	
	private static void printStack(Stack<String> stack){
		
		if (stack.isEmpty())
		{
			System.out.println("You have nothing in your stack");
		}
		else
		{
			System.out.printf("%s TOP\n", stack);
		}
	}

}
