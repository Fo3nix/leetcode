package Stack;

import java.util.*;

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

    // generateParenthesis
    // https://leetcode.com/problems/generate-parentheses/submissions/968863362/

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generateParenthesis(n, 0, 0, res, new char[n*2], 0);

        return res;
    }

    public void generateParenthesis(int total, int opened, int closed, List<String> res, char[] chars, int index){
        if(index==total*2){
            res.add(new String(chars));
            return;
        }
        if(opened<total) {chars[index]='('; generateParenthesis(total, opened+1, closed, res, chars, index+1);}
        if(closed<opened) {chars[index++]=')';generateParenthesis(total, opened, closed+1, res, chars, index);}
    }


    // Daily Temperatures
    // https://leetcode.com/problems/daily-temperatures/submissions/968894053/
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        int max = temperatures[n-1];
        int curr = 0;
        int days = 1;
        for(int i = n - 1; i >=0; i--){
            curr = temperatures[i];
            if(curr >= max){
                max = curr;
                continue;
            }
            days = 1;
            while(temperatures[i + days] <= curr){
                days += res[i + days];
            }
            res[i] = days;
        }
        return res;
    }





}
