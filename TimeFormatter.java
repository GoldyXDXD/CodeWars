import java.util.LinkedList;

public class TimeFormatter {
    private static final int[] PERIODS = {31536000, 86400, 3600, 60, 1};
    private static final String[] periodsString = {"year", "day", "hour", "minute", "second"};
  
    public static String formatDuration(int seconds) {
      String result = "";
      LinkedList<String> almostResult = new LinkedList<>();
      for (int i = 0; i < PERIODS.length; i++) {
        String s = String.join(" ", timeCounter(seconds, PERIODS[i]), periodsString[i]);
        if (s.equals("") || s.equals(" ")){
          almostResult.add(s);
        }
        seconds %= PERIODS[i];
      }
      if (almostResult.size() == 1) {
        return almostResult.getFirst();
      } else if (almostResult.size() == 2) {
        return almostResult.getFirst() + " and " + almostResult.getLast();
      } else {
        result = almostResult.getLast();
        for (int i = 0; i < almostResult.size() - 1; i++) {
          result.concat("and " + almostResult.get(i + 1));
        }
      }
      return "now";
    }
    
    private static String editString(String time) { // я знаю, что имя метода не очень, но я не не имею представления, как его назвать
      if (time.equals("")) {
        return "";
      }
      if (Integer.parseInt(time) > 1) {
        return time.concat("s");
      }
      return time;
    }
  
    private static String timeCounter(int seconds, int period) {
      String time = String.valueOf(seconds / period);
      if (seconds / period == 0) {
        return "";
      }
      return time;
    }
}
