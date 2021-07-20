public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
        String res = "";
        int[] period = new int[] {31536000, 86400, 3600, 60, 1};
        String[] periodNames = new String[] {"year", "day", "hour", "minute", "second"};
        
        if (seconds == 0) return "now";
        
        for (int i = 0; i < 5; i++) {
          if (seconds >= period[i]) {
            int q = seconds / period[i];
            seconds = seconds % period[i];
            res += (res.equals("") ? "" : (seconds == 0 ? " and " : ", "))
                   + q + " " + periodNames[i] + (q > 1 ? "s" : "");              
          }
        }
        return res;
    }
}
