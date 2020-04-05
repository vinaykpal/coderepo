package maps_questions;

public class Lucid1 {

}
/*
#
# |-----------------|
# |  1  |  2  |  3  |
# |     | ABC | DEF |
# |-----|-----|-----|
# |  4  |  5  |  6  |
# | GHI | JKL | MNO |
# |-----|-----|-----|
# |  7  |  8  |  9  |
# |PQRS | TUV | WXYZ|
# |-----|-----|-----|
# |     |  0  |     |
# |     | " " |     |
# |-----------------|
#
# input -> "44.33.555.555.666.0.9.666.777.555.444"
# output -> "HELLO WORLD"
*/

class Numpad {
/*
  Map<Integer, List<Character>> padMap;
  
  Numpad() {
    padMap = new HashMap<Integer, List<Character>> {0, " "}, 
                                                  {1, ""}, {2, "ABC"}, {3, "DEF"};
  }
  
  // "44444.444" -> "HI"
  public String translateNum(String in) {
    String tmpString;
    String res;
      for (int i= 0; i < in.length; i++) {
          if (in.charAt(i) != '.') {
              tmpString.append(in.charAt(i));
          } else {
            res.append = processsubStrNubmer(tmpString);
          }
        
      }  
  }

  // str = "0000"
  private String processSubStrName(String str) {
    
    List<Character> ch;
    if(padMap.Contains(str.charAt(0))) {
        ch = padMap.get(str.charAt(0));
    }
    
    return ch.get(str.length % ch.length);
  }
  */
}

