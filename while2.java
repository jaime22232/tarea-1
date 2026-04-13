//Sumar números del 1 al 50
public class while2 {
    public static void main(String[] args) {
        int i = 1;
        int suma = 0;
        while (i <= 50) {
            suma = suma + i;
            i++;
        }
        System.out.println("Suma: " + suma);
    }
}