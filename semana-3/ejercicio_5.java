import java.util.Random;
public class ejercicio_5 {
    public static void main(String[] args){
        Random rn = new Random();
        int[][] sillas = new int[5][5];
        int dispo = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sillas[i][j] = rn.nextInt(0, 2);
                System.out.print(sillas[i][j]+ " ");
                if (sillas[i][j]==0) {
                    dispo++;
                }
            }
            System.out.println("");
        }
        System.out.println("Sillas disponibles : " + dispo);
    }
    
}

   