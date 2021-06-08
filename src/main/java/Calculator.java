import java.util.Map;

import static java.lang.Integer.parseInt;

public class Calculator {
    private String[] order;

    public void input(String input) {
        if(isValidateOrders(input)) {
            this.order = input.split(" ");;
        }
    }

    public boolean isValidateOrders(String input) {
        String[] eachOrder = input.split(" ");

        // null이 아니고
        if(input == null) {
            throw new IllegalArgumentException("계산식은 null일 수 없습니다.");
        }

        // 처음은 숫자가 오고
        char firstChar = eachOrder[0].charAt(0);
        if(!Character.isDigit(firstChar)) {
            throw new IllegalArgumentException("계산식의 처음은 숫자로 시작해야 합니다.");
        }

        // 식의 길이는 3 이상의 수가 된다.
        int length = eachOrder.length;
        if(length < 3) {
            throw new IllegalArgumentException("계산식은 1개 이상의 연산이 있어여 합니다.");
        }

        // 식의 길이는 홀수가 된다.
        if(length % 2 == 0) {
            throw new IllegalArgumentException("계산식의 숫자 및 기호의 갯 수가 부정확합니다.");
        }

        // 숫자로 끝나야함
        char lastChar = eachOrder[eachOrder.length-1].charAt(0);
        if(!Character.isDigit(lastChar)) {
            throw new IllegalArgumentException("계산식의 마지막은 숫자로 끝나야 합니다.");
        }

        return true;
    }

    private int unitCalculate(String orderedOperator, int firstNumber, int secondNumber) {
        ArithmeticOperator arithmeticOperator = null;
        if("+".equals(orderedOperator)) {
            arithmeticOperator = (int a, int b) -> a + b;
        }
        if("-".equals(orderedOperator)) {
            arithmeticOperator = (int a, int b) -> a - b;
        }
        if("%".equals(orderedOperator)) {
            arithmeticOperator = (int a, int b) -> a % b;
        }
        if("*".equals(orderedOperator)) {
            arithmeticOperator = (int a, int b) -> a * b;
        }
        return arithmeticOperator.operate(firstNumber, secondNumber);
    }

    /**
     * 저장된 명령을 계산하는 역할
     * */
    public int interpretOrders() {
        String[] totalOrders = getOrder();
        int result = Integer.parseInt(totalOrders[0]);

        for(int i = 1; i < getOrder().length - 2; i+=2) {
            result += unitCalculate(totalOrders[i], result, Integer.parseInt(totalOrders[i+1]));
        }

        return result;
    }

    public String[] getOrder() {
        return this.order;
    }
}
