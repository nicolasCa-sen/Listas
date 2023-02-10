package run;

import logic.StackNode;

import java.util.Scanner;

public class Main {

    String process( String line ){


        return line;
    }
    public static void main(String[] args) {
        StackNode<Character> st = new StackNode<>( (o1,o2)->Character.compare(o1,o2));
        System.out.println("Hello world!");
        Scanner input = new Scanner(System.in);
        Main main = new Main();
        while(input.hasNext()){

            System.out.println(main.process( input.nextLine()));
        }
    }
}