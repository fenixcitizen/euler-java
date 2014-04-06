/**
 * Created by kapturma@04/04/14.
 */
public class Euler_9 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_9().execute();
    }

    @Override
    protected String run() {
        for (int c = 300; c < 700l; c++) {
            for (int b = 200; b < c; b++) {
                for (int a = 100; a < b; a++) {
                    if ((a+b+c == 1000)&&(a*a+b*b==c*c)){
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(c);

                        return String.valueOf(a*b*c);
                    }
                }
            }
        }
        return null;
    }
}
