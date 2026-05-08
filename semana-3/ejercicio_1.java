import java.util.Random;
public class ejercicio_1 {
    
    public static void main(String[] args)
    {   
        Random random = new Random();
        int[] tempe = new int[7];
        int promedio = 0;
        
        for (int i = 0; i < tempe.length; i++) {
            
            tempe[i] = random.nextInt(10, 36);
            promedio += tempe[i];
            System.out.println("Día " + (i+1) + ":" + tempe[i] + "C" );
            
        }
        System.out.println("Temperatura promedio : " + (promedio/7));
            
    }
    
}
