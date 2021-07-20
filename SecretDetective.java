import java.util.LinkedList;

public class SecretDetective {

  public String recoverSecret(char[][] triplets) {
    LinkedList<Character> result = new LinkedList<>();
    String stringResult = "";
    for (int i = 0; i < triplets.length; i++) {
      Character firstLetter = triplets[i][0];
      Character secondLetter = triplets[i][1];
      Character thirdLetter = triplets[i][2];
      if (!result.contains(firstLetter)) {
        result.add(0, firstLetter);
      }
      if (!result.contains(secondLetter)) {
        result.add(result.indexOf(firstLetter) + 1, secondLetter);
      }
      if (result.indexOf(firstLetter) > result.indexOf(secondLetter) && result.contains(secondLetter)) {
        result.remove(result.indexOf(secondLetter));
        result.add(result.indexOf(firstLetter) + 1, secondLetter);
      }
      if (!result.contains(thirdLetter)) {
        result.add(result.indexOf(secondLetter) + 1, thirdLetter);
      }
      if (result.indexOf(secondLetter) > result.indexOf(thirdLetter) && result.contains(thirdLetter)) {
        result.remove(result.indexOf(thirdLetter));
        result.add(result.indexOf(secondLetter) + 1, thirdLetter);
      }
    }
    for (int i = 0; i < result.size(); i++) {
      stringResult = stringResult.concat(result.get(i).toString());
    }
    return stringResult;
  }
}
