//Sumar números del 1 al 20
public class dowhile2 {
    public static void main(String[] args) {
        int i = 1;
        int suma = 0;
        do {
            suma = suma + i;
            i++;
        } while (i <= 20);
        System.out.println("Suma: " + suma);
    }
}