public class Calculator {
    private String s;

    public double calculate(String formula) {
        String[] strings = formula.split(" ");

        double result = Integer.parseInt(strings[0]);
        for (int i = 1; i < strings.length - 1; i++) {
            String operate = strings[i++];
            int num = Integer.parseInt(strings[i]);
            result = resultCalculate(result, operate, num);
        }

        return result;
    }

    private double resultCalculate(double result, String operate, int num) {
        if (operate.equals("+")) return result += num;
        if (operate.equals("-")) return result -= num;
        if (operate.equals("/")) return result /= num;
        if (operate.equals("*")) return result *= num;
        System.out.println("연산자를 잘못 입력했습니다.");
        return 0;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
