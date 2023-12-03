import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] palabras = {"raton","leon","toro","perro","gato","conejo","vaca","loro","cuy","elefante"};
        String palabraSecreta = seleccionarPalabra(palabras).toLowerCase();
        char[] palabraAdivinada = new char[palabraSecreta.length()];

        // Inicializar palabra adivinada con guiones bajos
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }

        int IR = 7;

        Scanner scanner = new Scanner(System.in);

        while ( IR > 0 && String.valueOf(palabraAdivinada).contains("_")) {
            mostrarTablero(palabraAdivinada, IR);

            System.out.print("Ingresa una letra: ");
            char letraIngresada = scanner.next().toLowerCase().charAt(0);

            if (adivinarLetra(palabraSecreta, palabraAdivinada, letraIngresada)) {
                System.out.println("Letras correctas: " + contarAciertos(palabraSecreta, letraIngresada));
            } else {
                IR--;
                System.out.println("Letra incorrecta. Intentos restantes: " + IR);
            }
        }

        mostrarResultado(palabraSecreta, IR);
    }


    public static String seleccionarPalabra(String[] palabras) {
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    public static void mostrarTablero(char[] palabraAdivinada, int intentosRestantes) {
        System.out.println("Palabra: " + String.valueOf(palabraAdivinada));
        System.out.println("Intentos restantes: " + intentosRestantes);
        System.out.println();
    }

    public static boolean adivinarLetra(String palabraSecreta, char[] palabraAdivinada, char letra) {
        boolean acertado = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acertado = true;
            }
        }
        return acertado;
    }

    public static int contarAciertos(String palabraSecreta, char letra) {
        int aciertos = 0;
        for (char c : palabraSecreta.toCharArray()) {
            if (c == letra) {
                aciertos++;
            }
        }
        return aciertos;
    }


    public static void mostrarResultado(String palabraSecreta, int intentosRestantes) {
        if (String.valueOf(palabraSecreta).equals(String.valueOf(palabraSecreta.toCharArray()))) {
            System.out.println("Felicidades Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("Te has quedado sin intentos. La palabra era: " + palabraSecreta);
        }
    }
}




