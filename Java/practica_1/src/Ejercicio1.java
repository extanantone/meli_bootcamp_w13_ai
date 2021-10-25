public class Ejercicio1 {
 public static void main(String[] args) {
  String cities[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
  int temperatures[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
  int min = 0;
  int max = 0;
  for (int i = 0; i < temperatures.length; i++) {
   if (temperatures[max][1] < temperatures[i][1]) max = i;
   if (temperatures[min][0] > temperatures[i][0]) min = i;
  }
  System.out.println("La temperatura maxima la tuvo " + cities[max] + " con " + temperatures[max][1] + " grados");
  System.out.println("La temperatura minima la tuvo " + cities[min] + " con " + temperatures[min][0] + " grados");
 }
}

