//Imprimir múltiplos de 4 hasta el 40
public class dowhile5 {
    public static void main(String[] args) {
        int i = 4;
        do {
            if (i%4 == 0) {
                System.out.println(i);
            }
            i++;
            
        } while (i <= 40);
    }
}