import static java.lang.Math.*;
public class Mathlaba {
    public static void main(String[] args) {
        short[] z = new short[(16-6)/2+1];
        for (int i = 6; i <= 16; i+=2) {
            z[(i-6)/2] = (short)i;
        }
        double[] x = new double[16];
        for (int i = 0; i < x.length; i++) {
            x[i] = random() * abs(14 - (-5)) + (-5);
        }
        double[][] z1 = new double[6][16];
        for (int i = 0; i < z1.length; i++) {
            for (int j = 0; j < z1[i].length; j++) {
                z1[i][j]=schetForZ(x[j],z[i]);
            }
        }
        vyvod(z1);
    }
    public static double schetForZ(double x, short z) {
        return switch ((int)z){
            case 10->
                    pow(pow(tan(x),3*(log(abs(x))-1)),PI*(asin(1/pow(E,abs(x)))+1));
            case 8,14,16->
                    pow(sin(asin((x+4)/19))/1/2,pow(exp(1),sin(x)));
            default ->
                    pow(exp(1),cos(pow(PI*(log(x-1)),3)));
        };
    }
    public static void vyvod(double[][] z1) {
        for (int i = 0; i < z1.length; i++) {
            for (int j = 0; j < z1[i].length; j++) {
                System.out.printf("%15.5f\t",z1[i][j]);
            }
            System.out.println();
        }
    }
}
