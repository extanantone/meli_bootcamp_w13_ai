public class Main {

    public static void main(String[] args) {

        final int A = 0;
        final int B = 300;

        double C = 0;

        try{

            C = B / A;

            throw new IllegalArgumentException("No se puede divdir por 0");

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Mensaje Final");
        }

    }
}
