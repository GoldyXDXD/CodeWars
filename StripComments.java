public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
    boolean flag = false;
    int pastSymbolIndex = -1;
    for (int i = 0; i < text.length(); i++) {
      
      String symbol = String.valueOf(text.charAt(i));
      
      if (isCommentSymbol(symbol, commentSymbols) == true && flag == false) {
        flag = true;
        pastSymbolIndex = i;
      } 
      else if (isCommentSymbol(symbol, commentSymbols) && flag == true) {
        
        text = text.substring(0, pastSymbolIndex) + text.substring(i + 1);
        flag = false;
      } 
      else if (flag == true && symbol == "\n") {
        text = text.substring(0, pastSymbolIndex) + text.substring(i);
        flag = false;
      }
      else if(flag == true && i == text.length() - 1) {
        text = text.substring(0, pastSymbolIndex);
      }
    }
    return text.trim();
	}
	
  public static boolean isCommentSymbol(String symbol, String[] commentSymbols) {
    for (String s: commentSymbols) {
      if (s.equals(symbol)) {
        return true;
      }
    }
    return false;
  }
  
}
