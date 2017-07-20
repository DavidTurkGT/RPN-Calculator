/**
 * Created by David Turk on 7/20/17.
 */
public class ReversePolishCalc {
    // You'll need a variable here to keep track of the top of the stack
    int pointer;
    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {
//        System.out.println("----------------------------");

        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[tokens.length];
        pointer = 0;

        // 3. write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
//            System.out.println("The current stack: ");
//            for(String s : stack) System.out.print(s + ", ");
//            System.out.println("The pointer is at " + pointer);
            try{
                double num = Double.parseDouble(tokens[i]);
                push(num);
            } catch(NumberFormatException e) {
                //An operator was parsed
                double num2 = pop();
                double num1 = pop();
                String op = tokens[i];
                switch(op){
                    case "+":
//                        System.out.println("Adding " + num1 + " and " + num2);
                        push(num1 + num2);
                        break;
                    case "-":
//                        System.out.println("Subtracting " + num1 + " and " + num2);
                        push(num1 - num2);
                        break;
                    case "*":
//                        System.out.println("Multiplying " + num1 + " and " + num2);
                        push( num1 * num2);
                        break;
                    case "/":
//                        System.out.println("Dividing " + num1 + " and " + num2);
                        push(num1 / num2);
                        break;
                }
            }
        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        stack[pointer++] = number;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        push(d+"");
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        return Double.parseDouble(stack[--pointer]);
    }
}
