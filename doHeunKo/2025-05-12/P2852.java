package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2852 {

    static int n;
    static int team1Score = 0, team2Score = 0;
    static int team1Time = 0, team2Time = 0;
    static int lastLeadTime = 0; 
    static int currentTime = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String team = st.nextToken();
            String timeStr = st.nextToken();
            currentTime = convertToSec(timeStr);

           
            if (team1Score > team2Score) {
                team1Time += (currentTime - lastLeadTime);
            } else if (team2Score > team1Score) {
                team2Time += (currentTime - lastLeadTime);
            }

          
            if (team.equals("1")) team1Score++;
            else team2Score++;

            lastLeadTime = currentTime;
        }

        if (team1Score > team2Score) {
            team1Time += (convertToSec("48:00") - lastLeadTime);
        } else if (team2Score > team1Score) {
            team2Time += (convertToSec("48:00") - lastLeadTime);
        }

      
        System.out.println(formatTime(team1Time));
        System.out.println(formatTime(team2Time));
    }

   
    static int convertToSec(String time) {
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }

  
    static String formatTime(int sec) {
        int min = sec / 60;
        int remainSec = sec % 60;
        return String.format("%02d:%02d", min, remainSec);
    }
}