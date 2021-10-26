public class Inicio {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "New York"};
        int[][] tempeture = {{-2, 33}, {-3, 32}, {-8, 27}};
        int max = Integer.MIN_VALUE;
        String cityMax = "";
        int min = Integer.MAX_VALUE;
        String cityMin = "";

        for (int i = 0; i < cities.length; i++) {
            if (tempeture[i][1] > max){
                max = tempeture[i][1];
                cityMax = cities[i];
            }
            if (tempeture[i][0] < min){
                min = tempeture[i][0];
                cityMin = cities[i];
            }

        }
        System.out.println("Max: " + cityMax + " " + max);
        System.out.println("Min: " + cityMin + " " + min);
    }
}
