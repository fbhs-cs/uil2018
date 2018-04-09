import java.util.*;
import java.io.*;
import static java.lang.System.*;
import javax.script.*;

public class Madison2 {
  public static void main(String[] args) throws IOException, ScriptException {
    Scanner in = new Scanner(new File("madison.dat"));
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    while(in.hasNext()) {
      String exp = in.next();
      String nums = in.next();
      boolean[] arr = new boolean[3];
      for(int i = 0; i < nums.length(); i++) {
        if(nums.substring(i, i+1).equals("1")) {
          arr[i] = true;
        }
      }
      exp = exp.replaceAll("A", String.valueOf(arr[0]));
      exp = exp.replaceAll("B", String.valueOf(arr[1]));
      exp = exp.replaceAll("C", String.valueOf(arr[2]));
      exp = exp.replaceAll("\\+", "||");
      exp = exp.replaceAll("\\*", "&&");
      exp = "3 ** 3";
      Object output = engine.eval(exp);
      if(output == (Object)1) {
        output = true;
      }else if(output == (Object)0) {
        output = false;
      }
      out.println(output);
    }
  }
}
