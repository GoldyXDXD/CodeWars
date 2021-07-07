/* Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.
*/
public class CountIPAddresses {
		String[] startNumbers = start.split("\\.");
    String[] endNumbers = end.split("\\.");
    long startSum = 0;
    long endSum = 0;
    for (int i = 0; i < 4; i++) {
      startSum +=  Long.parseLong(startNumbers[i], 10) * (long) Math.pow(256, 3-i);
      endSum += Long.parseLong(endNumbers[i], 10) * (long) Math.pow(256, 3-i);
    }
    return endSum - startSum;
	}
}
