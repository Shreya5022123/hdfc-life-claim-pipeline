package com.hdfclife.stack;

public class PostfixEvaluator {

    public static int evaluate(String expression, ClaimStack stack) {

        String[] tokens = expression.split(" ");

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {

                int right = stack.pop();
                int left = stack.pop();

                int result;

                switch (token) {
                    case "+":
                        result = left + right;
                        break;

                    case "-":
                        result = left - right;
                        break;

                    case "*":
                        result = left * right;
                        break;

                    case "/":
                        result = left / right;
                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Invalid operator: " + token
                        );
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}