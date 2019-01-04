import java.util.Scanner;
import java.lang.Math;

public class Main {
        public static void main(String[] args) {

            double standardRotation = 0.00198511385;

            System.out.println("");
            System.out.println("INFORMACJA WPROWADZAJĄCA DLA NIKODEMA. Program powie Ci o ile twoja nowa opona będzie Cię okłamywać. Dla opony o symbolach: 205/55 r16:");
            System.out.println("205 - oznacza szerokość");
            System.out.println("55 - oznacza wysokość opony w % do szerokości");
            System.out.println("r16 - to rozmiar opony w calach");
            System.out.println("Pierwsza zmiana w github");

            Scanner odczyt = new Scanner(System.in);
            String[][] daneOpony = {{"szerokosc [mm]", "wysokosc [%]", "rozmiar [cale]"}, {"1", "1", "1"}};
            int[][] tolerancja = {{150, 25, 14}, {320, 75, 20}};

            for (int i = 0; i < 3; i++) {
                while (!(Integer.parseInt(daneOpony[1][i]) >= tolerancja[0][i] && Integer.parseInt(daneOpony[1][i]) <= tolerancja[1][i])) {
                    try {
                        System.out.println("Podaj " + daneOpony[0][i] + " wymarzonej oponki: ");
                        daneOpony[1][i] = odczyt.next();

                        if ((Integer.parseInt(daneOpony[1][i]) < tolerancja[0][i] || Integer.parseInt(daneOpony[1][i]) > tolerancja[1][i])) {
                            System.out.println("Spróbuj ponownie: Twoja liczba nie mieści się w zakładanym zakresie od " + tolerancja[0][i] + " do " + tolerancja[1][i]);
                        }

                    } catch (NumberFormatException n) {
                        System.out.println("MUSISZ PODAĆ LICZBĘ DYWANIKU!");
                        daneOpony[1][i] = 1 + "1";
                    }
                }
            }
            double newRotation = Math.PI * ((Integer.parseInt(daneOpony[1][2]) * 25.4) + ((Integer.parseInt(daneOpony[1][0]) * Integer.parseInt(daneOpony[1][1]) / 100) * 2)) / 1000000;
            double newQuantityRotationPer100km = 100 / newRotation;
            double wskazaniePredkosciomierza = newQuantityRotationPer100km * standardRotation;

            System.out.println("Gdy będziesz jechał z prędkością 100km/h, twój prędkościomierz pokaże: " + (int) wskazaniePredkosciomierza + "km/h");
        }
}

