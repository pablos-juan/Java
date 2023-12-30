package test.java.com.aprendizaje;

import java.util.ArrayList;
import java.util.Arrays;

public class Katas {

    public static String invertirString(String str) {
        /**
         * invertir una cadena de texto
         *  String solution = "";
         *  for(int i=str.length()-1; i>=0; i--){
         *  solution += str.charAt(i);
         *  }
         *  return solution;
        */
        return new StringBuilder(str).reverse().toString();
        //pasar al stringBuilder el String, reverse lo invierte y toString devuelve el String
    }

    public static int solutions(int[] n){
        //elevar al cuadrado cada elemento del arreglo
        return Arrays.stream(n).map(x -> x * x).sum();
        //stream para convetir arreglo en un flujo, asi se pueden hacer operaciones de secuencia
        //.map toma cada elemento del arreglo y eleva al cuadrado
        //.sum suma todos los elementos despues de ser mapeados al cuadrado
    }

    public static int max(int[] list) {
        //encontrar el numero maximo en el arreglo
        // int mayor = list[0];
        // for (int i=1; i<list.length; i++){
        //     if (list[i] > mayor) mayor = list[i];
        // }
        // return mayor;
        return Arrays.stream(list).min().getAsInt();
        //.min encuentra el valor minimo dentro del arreglo
        //.getAsInt devulve el numero como un entero, sino devulve una excepcion
    }

    public static int min(int[] list) {
        //encontrar el numero menor del arreglo
        // int menor = list[0];
        // for (int i=1; i<list.length; i++){
        //     if (list[i] < menor) menor = list[i];
        // }
        // return menor;
        return Arrays.stream(list).max().getAsInt();
        //.max encuentra el valor minimo dentro del arreglo
    }

    public static String mayuculas(String str){
        //convertir un String a mayusculas
        //return str.toUpperCase();
        return str == null ? null: str.toUpperCase();
        //operador terciario. condicion ? expresiónSiVerdadero : expresiónSiFalso
    }

    public static int stringToNumber(String str){
        //convertir una cadena de texto en un numero
        //return Integer.parseInt(str);
        return str == null ? -1: Integer.parseInt(str);
        //solo funciona si el texto solo contiene numeros
    }

    public static boolean comparacionNum(final int num1, final int num2){
        //si uno de los numeros es par y el otro es impar return true
        return num1%2 != num2%2;
    }

    public static String updateLight(String current) {
        return switch(current){
            case "green" -> current = "yellow";
            case "yellow" -> current = "red";
            case "red" -> current = "green";
            default -> null;
        };
    }

    public static String findNeedle(String[] haystack) {
        //encontrar la posicion de needle en el arreglo haystack
        // for (int i=0; i<haystack.length; i++){
        //     if (haystack[i] == "needle"){
        //         return "found the needle at position " + i;
        //     }
        // }
        // return null;
        return "found the needle at position " + Arrays.asList(haystack).indexOf("needle");
        //Arrays.asList convierte el arreglo en una lista con los elementos del arreglo
        //.indexOf devuelve el índice de la primera posicion que contenga el elemento "needle"
    }

    public static int opposite(int number){
        //dado un numero encontrar el opuesto -> 12 = -12, -3 = 3
        return number * -1;
    }

    public static int[] reverse(int n){
        int[] numbers = new int[n];
        for (int i=0; i<numbers.length; i++){
            numbers[i] = n--;
        }
        return numbers;
    }

    public static boolean feast(String beast, String dish){
        String compare = new StringBuilder(beast).delete(1, beast.length()).toString();
        String dh = new StringBuilder(dish).delete(1, dish.length()).toString();
        return dh.equals(compare);
    }

    public static boolean check(Object[] a, Object x) {
        return Arrays.asList(a).contains(x);
    }

    public static String getMiddle(String word) {
        //devolver la letra del medio, si la longitud es par devulve las dos letras del medio
        // int middle;
        // if (word.length() % 2 == 0){
        //     middle = word.length() / 2;
        //     return word.substring(middle-1, middle+1);
        // }
        // middle = (word.length()) / 2;
        // return word.substring(middle, middle+1);
        // if (word.length() > 2)
        // return getMiddle(word.substring(1,word.length()-1));
        // return word;
        return word.length() > 2 ? getMiddle(word.substring(1, word.length()-1)) : word;
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        return Arrays.stream(arrayOfSheeps)
                .filter(x -> x != null && x)
                .toArray()
                .length;
    }

    public static boolean solution(String str, String ending){
        //comprobar si str termina con los caracteres ending
        return str.endsWith(ending);
    }



    public static String bmi(double weight, double height){
        double masa = weight / (height * height);
        if (masa <= 18.5){
            return "Bajo peso";
        } else if (masa <= 25) {
            return "Normal";
        } else if (masa <= 30) {
            return "Sobrepeso";
        } else{
            return "Obeso";
        }
    }

    public static int countPassengers(ArrayList<int[]> stops){
        //Los elementos de cada par representan la cantidad de personas que suben al autobús
        //(el primer elemento) y la cantidad de personas que se bajan del autobús (el segundo
        //elemento) en una parada de autobús.
        //Su tarea es devolver la cantidad de personas que todavía están en el autobús después
        //de la última parada (después de la última matriz).
        return stops.stream().mapToInt(x -> x[0] - x[1]).sum();
    }

    public static void prueba(){
        String[] nombres = {"Pablo", "Samuel", "Adriana", "Yojan", "Helen"};
        Arrays.stream(nombres)
                .filter(s -> s.length() > 5)
                .forEach(System.out::println);
    }

    public static long findNextSquare(long sq){
        //encontrar el cuadrado perfecto siguiente al pasado por parametro
        //si el parametro no es un cuadrado perfecto. Asuma que el parametro no es negativo
        //double cuadrado = Math.sqrt(sq);
        //return cuadrado == (int) cuadrado ? (long) ((cuadrado + 1) * (cuadrado + 1)): -1;
        int square = (int) Math.sqrt(sq);
        return (Math.sqrt(sq)) % 1 == 0 ? (square + 1) * (square + 1): -1;
    }

    public static String removeExclamationMarks(String s){
        //quitar de la cadena todos los signos de exclamacion
        return s.replaceAll("!", "");
    }

    public static boolean isSquare(int n){
        //true si el numero es un cuadrado perfecto, de lo contrario false
        //double square =  Math.sqrt(n);
        //return square == (int) square ? true: false;
        return Math.sqrt(n) % 1 == 0;
    }

    public static int rentalCarCost(int d){
        int result = 40 * d;
        if (d >= 7) {
            return result - 50;
        } else if (d >= 3) {
            return result - 20;
        }
        return result;
    }

    public static int quarterOf(int month){
        if (month <= 3) {
            return 1;
        } else if (month <= 6) {
            return 2;
        } else if (month <= 9) {
            return 3;
        } else if (month <= 12) {
            return 4;
        } else return -1;
    }

    public static int[] countBy(int x, int n){
        //cree una funcion que agregue a un arreglo un numero x que aumenta con tasa de x + x
        //la longitud del arreglo esta dada por n
        return java.util.stream.IntStream.iterate(x, i -> i + x).limit(n).toArray();
    }

    public static void main(String[] args) {
        //System.out.println(findNextSquare(12));
        int[] nums = countBy(2, 5);
        for (int num: nums){
            System.out.println(num);
        }
    }

}