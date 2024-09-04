import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        // Clase Scanner que permite que el usuario escriba en la consola
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones de variables
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Llamado a la función que inicializa el arreglo de letras adivinadas
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            // Llamado a la función que inicializa el arreglo de letras adivinadas
            letrasAdivinadas[i] = '_';
        }

        // Ciclo que se ejecuta mientras el usuario no adivine la palabra secreta

        while (!palabraAdivinada && intentos < intentosMaximos) {
            // Imprimir las letras adivinadas
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)"); // String.valueOf() se usa para convertir un arreglo de caracteres a un string

            System.out.println("Ingresa una letra, por favor: ");

            // Leer la letra ingresada por el usuario, se toma solo el primer caracter
            char letra = scanner.next().charAt(0);

            // Convertir a minúscula la letra ingresada por el usuario por si está en mayúscula
            letra = Character.toLowerCase(letra); // Character.toLowerCase() se usa para convertir un caracter a minúscula

            // Variable que indica si la letra ingresada por el usuario es correcta
            boolean letraCorrecta = false;

            // Ciclo que recorre la palabra secreta para verificar si la letra ingresada por el usuario es correcta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                // Si la letra ingresada por el usuario es igual a la letra en la posición i de la palabra secreta
                if (palabraSecreta.charAt(i) == letra) {
                    // Se actualiza el arreglo de letras adivinadas
                    letrasAdivinadas[i] = letra;
                    // Se indica que la letra ingresada por el usuario es correcta
                    letraCorrecta = true;
                }
            }

            // Si la letra ingresada por el usuario es incorrecta
            if (!letraCorrecta) {
                // Se incrementa el número de intentos
                intentos++;
                // Se imprime el número de intentos restantes
                System.out.println("Intentos restantes: " + (intentosMaximos - intentos));
            }   

            // Si el arreglo de letras adivinadas es igual a la palabra secreta
            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                // Se indica que la palabra fue adivinada
                palabraAdivinada = true;
                // Se imprime un mensaje de felicitaciones
                System.out.println("¡Felicidades! Adivinaste la palabra secreta: " + palabraSecreta);
            }
            
        }

        // Si el usuario no adivina la palabra secreta
        if (!palabraAdivinada) {
            // Se imprime un mensaje indicando que el usuario perdió
            System.out.println("¡Lo siento! Perdiste. La palabra secreta era: " + palabraSecreta);
        }

        // Se cierra el scanner para liberar recursos
        scanner.close();

    }
}
