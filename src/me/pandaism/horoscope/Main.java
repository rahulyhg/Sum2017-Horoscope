package me.pandaism.horoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Panda on 5/20/2017.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] possibleSigns = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn","Aquarius", "Pisces"};

        System.out.println("|================================|");
        System.out.println("|======     Horoscopes     ======|");
        System.out.println("|================================|");
        System.out.println("☺ " + possibleSigns[10] + ": Jan 20 - Feb 18");
        System.out.println("☺ " + possibleSigns[11] + ": Feb 19 - Mar 20");
        System.out.println("☺ " + possibleSigns[0] + ": Mar 21 - Apr 19");
        System.out.println("☺ " + possibleSigns[1] + ": Apr 20 - May 20");
        System.out.println("☺ " + possibleSigns[2] + ": May 21 - Jun 20");
        System.out.println("☺ " + possibleSigns[3] + ": Jun 21 - Jul 22");
        System.out.println("☺ " + possibleSigns[4] + ": Jul 23 - Aug 22");
        System.out.println("☺ " + possibleSigns[5] + ": Aug 23 - Sep 22");
        System.out.println("☺ " + possibleSigns[6] + ": Sep 23 - Oct 22");
        System.out.println("☺ " + possibleSigns[7] + ": Oct - Nov 21");
        System.out.println("☺ " + possibleSigns[8] + ": Nov 22 - Dec 21");
        System.out.println("☺ " + possibleSigns[9] + ": Dec 22 - Jan 19");
        System.out.println("Type your sign to get your horoscope: ");

        String sign = scanner.nextLine();
        urlHelper(sign.toLowerCase());

    }

    private static void urlHelper(String sign) {
        int number;
        switch (sign) {
            case "aries":
                number = 1;
                break;
            case "taurus":
                number = 2;
                break;
            case "gemini":
                number = 3;
                break;
            case "cancer":
                number = 4;
                break;
            case "leo":
                number = 5;
                break;
            case "virgo":
                number = 6;
                break;
            case "libra":
                number = 7;
                break;
            case "scorpio":
                number = 8;
                break;
            case "sagittarius":
                number = 9;
                break;
            case "capricorn":
                number = 10;
                break;
            case "aquarius":
                number = 11;
                break;
            case "pisces":
                number = 12;
                break;
            default:
                number = 0;
                break;
        }

        if(number != 0) {
            try {
                URL url = new URL("https://www.astrology.com/horoscope/daily/" + sign + ".html");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) {
                    if(line.contains("<div class=\"page-horoscope-text\" style=\"height:145px;\">")) {
                        line = line.substring(line.indexOf('>') + 1, line.length() - 6);
                        System.out.println(line);
                    }
                }
                reader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Your sign either does not exist or is not in our system. Please launch and try again.");
        }
    }
}
