import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;
import java.util.Scanner;

/**
 * Created by hp on 05.01.2017.
 */
public class Main {
    private static int year = 2017;
    public static void main(String[] args) {
        int i;
        i = searchMonth();
        createTable(i);

    }
    private static int searchMonth(){
        Scanner scn = new Scanner(System.in);
        System.out.println("введіть номер місяця");
        int i = scn.nextInt();
        if((i > 0) && (i < 13)){
            return i;
        }else {
            return MonthDay.now().getMonthValue();
        }

    }
    static String text;
    private static void createTable(int i){
        text = "";
        System.out.println(Month.of(i));
        int kDat = Month.of(i).maxLength();
        for (int k = 1; k < 8; k++) {
            System.out.print(DayOfWeek.of(k).name().charAt(0) + "  ");

        }
        System.out.println();
            int prob;
                prob = MonthDay.of(i, 1).atYear(year).getDayOfWeek().getValue();
                prob = prob*3 - 3;
        for (int k = 0; k < prob; k++) {
            text = text + " ";
        }
            text = text + "1  ";
        if (MonthDay.of(i, 1).atYear(year).getDayOfWeek().getValue() == 7) {
            text = text + '\n';
        }
        for (int j = 2; j < kDat+1; j++) {
            if (MonthDay.of(i, j).atYear(year).getDayOfWeek().getValue() < 7) {
                if(MonthDay.of(i, j).getDayOfMonth() > 9){
                    if (MonthDay.of(i, j).atYear(year).getDayOfWeek().getValue() == 6){
                        text = text + (char) 27 + "[31m"+ MonthDay.of(i, j).getDayOfMonth() + " " + (char)27 + "[0m";
                    }else{
                        text = text + MonthDay.of(i, j).getDayOfMonth() + " ";

                    }
                }else {
                    if (MonthDay.of(i, j).atYear(year).getDayOfWeek().getValue() == 6){
                        text = text + (char) 27 + "[31m"+ MonthDay.of(i, j).getDayOfMonth() + "  " + (char)27 + "[0m";
                    }else {
                        text = text + MonthDay.of(i, j).getDayOfMonth() + "  ";
                    }
                }
            } else {
                text = text + (char) 27 + "[31m"+ MonthDay.of(i, j).getDayOfMonth() + " " + (char)27 + "[0m";
                text = text + '\n';
            }
        }
        System.out.println(text);

    }
}
