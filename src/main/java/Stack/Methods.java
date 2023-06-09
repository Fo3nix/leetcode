package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Methods {
    // VALID PARENTHESES
    // https://leetcode.com/problems/valid-parentheses/submissions/967180915/
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            switch(c){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if(stack.size()==0) return false;
                    if(stack.pop()!=c) return false;
            }
        }

        return stack.size()==0;
    }

    // Min Stack
    // https://leetcode.com/problems/min-stack/submissions/967205598/
    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<Integer>();
            minStack = new ArrayDeque<Integer>();
        }

        public void push(int val) {
            stack.push(val);
            if(minStack.peek()== null || minStack.peek() >= val) minStack.push(val);
        }

        public void pop() {
            if(minStack.peek()-stack.poll()==0) minStack.poll();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // Evaluate Reverse Polish Notation
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/967215883/
    int pos;
    String[] token;
    public int evalRPN(String[] tokens) {
        pos=tokens.length-1;
        token=tokens;
        return eval();
    }
    public int eval(){
        String st=token[pos--];
        switch(st){
            case "+": return eval()+eval();
            case "-": int x1=eval();
                int y1=eval();
                return y1-x1;
            case "*": return eval()*eval();
            case "/": int x=eval();
                int y=eval();
                return y/x;
            default: return Integer.parseInt(st);
        }
    }


}
