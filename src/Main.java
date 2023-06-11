import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) {
        String plusSymbol = "+";
        String subtractingSymbol = "-";
        String multiplicationSymbol = "*";
        String dividingSymbol = "/";
        String result= "";
        boolean roamChecking = false;
        boolean roamCheckingFirstNumb = false;
        boolean roamCheckingSecondNumb = false;
        if (input.length() <= 3) {
            throw new IllegalArgumentException("строка не является математической операцией");
        }
        int posFirstSymbol = input.indexOf(" ");
        int posSecondSymbol = input.indexOf(" ", posFirstSymbol + 1);
        String firstNumber = input.substring(0, posFirstSymbol);
        String mathSymbol = input.substring(posFirstSymbol + 1, posSecondSymbol);
        int posFourthSymbol = input.indexOf(" ", posSecondSymbol + 1);
        if (posFourthSymbol > 0) {
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String secondNumber = input.substring(posSecondSymbol + 1, input.length());
        try {
            Integer checkIntFirst = Integer.parseInt(firstNumber);
        } catch (Exception ex) {
            firstNumber = checkNumb(firstNumber);
            roamChecking = true;
            roamCheckingFirstNumb = true;
        }
        try {
            Integer checkIntFirst = Integer.parseInt(secondNumber);
        } catch (Exception ex) {
                secondNumber = checkNumb(secondNumber);
                roamChecking = true;
                roamCheckingSecondNumb = true;
        }
        try { Integer checkIntFirst = Integer.parseInt(firstNumber);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Ведено не целое число, введите целное число от 1 до 10");
        }
        try { Integer checkIntFirst = Integer.parseInt(secondNumber);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Ведено не целое число, введите целное число от 1 до 10");
        }
        if (!roamCheckingFirstNumb && roamCheckingSecondNumb || roamCheckingFirstNumb && !roamCheckingSecondNumb) {
            throw new IllegalArgumentException("Неверный формат, возможно только арифмические действия типа: римское число и римское число или арабское число и арабское число");
        }
        errorMassage(firstNumber, secondNumber);

        if (mathSymbol.equals(plusSymbol)) {
            result = plus(firstNumber, secondNumber);
        } else if (mathSymbol.equals(subtractingSymbol)) {
            result = subtracting(firstNumber, secondNumber);
        } else if (mathSymbol.equals(multiplicationSymbol)) {
            result = multiplication(firstNumber, secondNumber);
        } else if (mathSymbol.equals(dividingSymbol)) {
            result = dividing(firstNumber, secondNumber);
        } else {
            throw new IllegalArgumentException("Неправильно введён математический символ, допустимы символы '+' '-' '*' '/'");
        }
        if (roamChecking == true) {
            if (checkMoreZero(result) == 0) {
                throw new IllegalArgumentException(" в римской системе нет отрицательных чисел");
            }
            return convertNumToRoman(result);
        } else {
            return result;
        }
    }

    static String plus(String firstNumber, String secondNumber) {
        Integer calculating = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        return  calculating.toString();
    }

    static String subtracting(String firstNumber, String secondNumber) {
        Integer calculating = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
        return  calculating.toString();
    }

    static String multiplication(String firstNumber, String secondNumber) {
        Integer calculating = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
        return  calculating.toString();
    }

    static String dividing(String firstNumber, String secondNumber) {
        Integer calculating = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
        return  calculating.toString();
    }

    static void errorMassage(String firstNumber, String secondNumber) {
        Integer firstNumberInt = Integer.parseInt(firstNumber);
        Integer secondNumberInt = Integer.parseInt(secondNumber);
            if (firstNumberInt >= 11 || secondNumberInt >= 11) {
                throw new IllegalArgumentException("Введёные числа больше 10, введите числа от 0 до 10 включительно");
            }
    }

     static String convertNumToRoman (String numb) {
        Integer numberInt = Integer.parseInt(numb);
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String finalNumb = roman[numberInt];
        return finalNumb;
    }

    static String romanToNumber(String numb) {
        String resultNumbArabic = "";
        try {
            if (numb.equals("I")) {
                resultNumbArabic = "1";
            } else if (numb.equals("II")) {
                resultNumbArabic = "2";
            } else if (numb.equals("III")) {
                resultNumbArabic = "3";
            } else if (numb.equals("IV")) {
                resultNumbArabic = "4";
            } else if (numb.equals("V")) {
                resultNumbArabic = "5";
            } else if (numb.equals("VI")) {
                resultNumbArabic = "6";
            } else if (numb.equals("VII")) {
                resultNumbArabic = "7";
            } else if (numb.equals("VIII")) {
                resultNumbArabic = "8";
            } else if (numb.equals("IX")) {
                resultNumbArabic = "9";
            } else if (numb.equals("X")) {
                resultNumbArabic = "10";
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException("Неверный формат данных");
        }
        return resultNumbArabic;
    }

    static String checkNumb(String numb) {
        String convertNumb = numb;
        try {
            Integer checkNumInt = Integer.parseInt(numb);
            if (checkNumInt == 1 || checkNumInt == 2 || checkNumInt == 3 || checkNumInt == 4 || checkNumInt == 5
                    || checkNumInt == 6 || checkNumInt == 7 || checkNumInt == 8 || checkNumInt == 9 || checkNumInt == 10) {
                return convertNumb;
            }
        } catch (Exception ex) {
            convertNumb = romanToNumber(numb);
        }
        return convertNumb;
    }

    static int checkMoreZero (String numb) {
        Integer checkMoreInt = Integer.parseInt(numb);
        int checkZero = 0;
        int result = 0;
        if (checkMoreInt < checkZero) {
            result = 0;
        } else if(checkMoreInt > checkZero) {
            result = 1;
        }
        return result;
    }
}