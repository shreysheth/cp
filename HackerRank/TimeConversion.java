package HackerRank;
import java.util.*;
/**
 * TimeConversion
 */
public class TimeConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String meridiem = input.substring(8);
        String[] initTime = input.substring(0, 8).split(":");
        String time = "";
        if (meridiem.toLowerCase().equals("am")) {
            if (Integer.parseInt(initTime[0]) == 12) {
                initTime[0] = "00";
                for (String item : initTime) {
                    time += item + ":";
                }
                System.out.println(time.substring(0, 8));
                return;
            } else {
                for (String item : initTime) {
                    time += item + ":";
                }
                System.out.println(time.substring(0, 8));
                return;
            }
        } else {
            int x = 0;
            if (Integer.parseInt(initTime[0]) == 12) {
                x = Integer.parseInt(initTime[0]);
            } else {
                x = Integer.parseInt(initTime[0]) + 12;
            }
            initTime[0] = Integer.toString(x);
            for (String item : initTime) {
                time += item + ":";
            }
            System.out.println(time.substring(0, 8));
            return;
        }
    }
}
