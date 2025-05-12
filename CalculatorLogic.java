public class CalculatorLogic {

    public static String calculate(String command) {
        command = command.toLowerCase();

        String[] words = command.split(" ");

        try {
            int result = 0;

            if (command.contains("add") || command.contains("plus")) {
                int a = Integer.parseInt(words[1]);
                int b = Integer.parseInt(words[3]);
                result = a + b;
            } else if (command.contains("subtract") || command.contains("minus")) {
                int a = Integer.parseInt(words[1]);
                int b = Integer.parseInt(words[3]);
                result = a - b;
            } else if (command.contains("multiply") || command.contains("times")) {
                int a = Integer.parseInt(words[1]);
                int b = Integer.parseInt(words[3]);
                result = a * b;
            } else if (command.contains("divide") || command.contains("by")) {
                int a = Integer.parseInt(words[1]);
                int b = Integer.parseInt(words[3]);
                result = a / b;
            } else {
                return "Sorry, I didn't understand.";
            }

            return "The result is " + result;
        } catch (Exception e) {
            return "Error in parsing numbers.";
        }
    }
}
