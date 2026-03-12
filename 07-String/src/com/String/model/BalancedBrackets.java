package com.String.model;

import java.util.Stack;

public class BalancedBrackets {

    public boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {

            if (c == '(' || c == '[' || c == '{')
                stack.push(c);

            else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}