package project;

import java.util.Scanner;

public class Calculator {

    public void calculator(){
        float num1, num2, ans;
        char op;
        String s[] = new String[2];
        ClientStub cs = new ClientStub();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        num1 = in.nextFloat();
        System.out.print("Enter the second number: ");
        num2 = in.nextFloat();
        System.out.print("Enter the symbol of the operation you need to perform: ");
        op = in.next().charAt(0);
        RegistrySearch rs = new RegistrySearch();
        s=rs.getServer(op);
        switch (op) {
            case '+':
                ans = cs.add(num1, num2);
                System.out.println("Your calculation is being performed...");
                System.out.println("Answer = " + ans);
                break;
            case '-':
                ans = cs.sub(num1, num2);
                System.out.println("Your calculation is being performed..."); 
                System.out.println("Answer = " + ans);
                break;
            case '*':
                ans = cs.mul(num1, num2);
                System.out.println("Your calculation is being performed..."); 
                System.out.println("Answer = " + ans);
                break;
            case '/':
                if (num2 != 0) {
                    ans = cs.div(num1, num2);
                    System.out.println("Your calculation is being performed..."); 
                    System.out.println("Answer = " + ans);
                } else {
                    System.out.println("Error: You are going to divide by zero. Please enter valid numbers");
                }
                break;
        }
    }
}
