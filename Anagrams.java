/*
Consider a "word" as any sequence of capital letters A-Z (not limited to just "dictionary words"). For any word with at least two different letters, there are other words composed of the same letters but in a different order (for instance, STATIONARILY/ANTIROYALIST, which happen to both be dictionary words; for our purposes "AAIILNORSTTY" is also a "word" composed of the same letters as these two).

We can then assign a number to every word, based on where it falls in an alphabetically sorted list of all words made up of the same group of letters. One way to do this would be to generate the entire list of words and find the desired one, but this would be slow if the word is long.

Given a word, return its number. Your function should be able to accept any word 25 letters or less in length (possibly with some letters repeated), and take no more than 500 milliseconds to run. To compare, when the solution code runs the 27 test cases in JS, it takes 101ms.
*/
import java.math.BigInteger;
import java.util.*;

public class Anagrams {
  public BigInteger listPosition(String word) {
    Map<Character, Integer> map = new HashMap<Character, Integer> ();
    BigInteger factorial = new BigInteger("1");
    BigInteger result = new BigInteger("1");
    BigInteger count = new BigInteger("0");
    for(int i = word.length() - 1; i >= 0; --i) {
      count = count.add(new BigInteger("1"));
      factorial = factorial.multiply(count);
      if(map.get(word.charAt(i)) == null) {
        map.put(word.charAt(i),0);
      }
      map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
      factorial = factorial.divideAndRemainder(new BigInteger(String.valueOf(map.get(word.charAt(i)))))[0];
      for(Character c : map.keySet()) {
        if (c < word.charAt(i)) {
          result = result.add(factorial.divideAndRemainder(count)[0].multiply(new BigInteger(String.valueOf(map.get(c)))));
        }
      }    
    
    }
    return result;
  }
}
