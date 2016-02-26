package edu.javacourse.spring;

import edu.javacourse.spring.spel.StringUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SimpleExample {

    public static void main(String[] args) throws NoSuchMethodException {
        SpELDemo();
    }

    private static void SpELDemo() throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("reverseString", StringUtils.class.getDeclaredMethod("reverseString", new Class[]{String.class}));
        String helloWorldReversed = parser.parseExpression("#reverseString('hello')").getValue(context, String.class);
        System.out.println(helloWorldReversed);
    }
}
