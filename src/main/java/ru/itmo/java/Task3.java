package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if ((inputArray == null) || (inputArray.length == 0) ) return new int[]{};
        if (inputArray.length > 1) {
            int last = inputArray[inputArray.length - 1];
            for (int i = 1;  i < inputArray.length; i++) {
                inputArray[inputArray.length - i] = inputArray[inputArray.length - i - 1];
            }
            inputArray[0] = last;
        }
        return inputArray;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if ( (inputArray == null) || (inputArray.length == 0) ) return 0;
        if (inputArray.length == 1) return inputArray[0];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max1){
                max1 = inputArray[i];
            } else if (inputArray[i] > max2){
                max2 = inputArray[i];
            }
        }
        return max1 * max2;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if ( (input == null) || (input.length() == 0) ) return 0;
        int res = 0;
        for (int i = 0; i < input.length(); i++){
            if ( (input.charAt(i) == 'a') || (input.charAt(i) == 'A') || (input.charAt(i) == 'b') || (input.charAt(i) == 'B') ){
                res++;
            }
        }
        res = res * 100 / input.length();
        return res;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) return false;
        for (int i = 0; i < input.length() / 2; i++) {
            if ( input.charAt(i) != input.charAt( input.length() - 1 - i) ){
                return false;
            }
        }
        return true;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if( (input == null) || (input.length() == 0) ) return "";
        String res = "";
        res += input.charAt(0);
        int intres = 1;
        for (int i = 1; i < input.length(); i++){
            if (input.charAt(i - 1) != input.charAt(i)){
                res += intres;
                intres = 1;
                res += input.charAt(i);
            } else intres++;
        }
        return res + intres;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if ( (two == null) || (one == null) || (one.length() == 0) || (two.length() == 0) || (one.length() != two.length()) ) return false;
        boolean[] res = new boolean[two.length()];
        for (int i = 0; i < one.length(); i++){
            for (int j = 0; j < two.length(); j++){
                if ( (one.charAt(i) == two.charAt(j)) && !res[j] ){
                    res[j] = true;
                    break;
                }
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[0] &= res[i];
        }
        return res[0];
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if ( (s == null) || (s.length() == 0) ) return false;
        int[] arrch = new int['z' + 'Z' + 1];
        for (int i = 0; i < s.length(); i++){
            arrch[s.charAt(i)]++;
            if (arrch[s.charAt(i)] > 1){
                return false;
            }
        }
        return true;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if ( (m == null) || (m.length == 0) || (m[0].length == 0) ) return new int[][]{ {}, {} };
        int[][] res = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                res[j][i] = m[i][j];
            }
        }
        return res;
//        throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if ( (inputStrings == null) || (inputStrings.length == 0) ) return "";
        if (separator == null) separator = ' ';
        String res = "" + inputStrings[0];
        for (int i = 1; i < inputStrings.length; i++){
            res += separator + inputStrings[i];
        }
        return res;
//        return null; // TODO solve
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if ( (inputStrings == null) || (prefix == null)) return 0;
        int res = 0;
        for (int i = 0; i < inputStrings.length; i++){
            if (inputStrings[i].startsWith(prefix)){
                res++;
            }
        }
        return res;
//        return 0; // TODO solve
    }
}
