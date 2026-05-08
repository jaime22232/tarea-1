import java.util.Random;

public class ejercicio_4{
    public static void main(String[] args) {
        final int TOTAL_ESTUDIANTES = 15;
        int[] notas = new int[TOTAL_ESTUDIANTES];
        Random random = new Random();

        for (int i = 0; i < TOTAL_ESTUDIANTES; i++) {
            notas[i] = random.nextInt(21);
        }

        int notaMasAlta = notas[0];
        int notaMasBaja = notas[0];
        int aprobados = 0;
        int desaprobados = 0;

        System.out.println(" Listado de notas del salón ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
            
            if (notas[i] > notaMasAlta) notaMasAlta = notas[i];
            if (notas[i] < notaMasBaja) notaMasBaja = notas[i];
            
            if (notas[i] >= 11) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }
        System.out.println("");
        System.out.println("Nota más alta: " + notaMasAlta);
        System.out.println("Nota más baja: " + notaMasBaja);
        System.out.println("Estudiantes aprobados: " + aprobados);
        System.out.println("Estudiantes desaprobados: " + desaprobados);
    }
}