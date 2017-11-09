import java.util.*;
import static java.lang.System.*;
public class One{
  public static void main(String...args){
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//traditional for loop
    int x=0;
    for(x=0;x<list.size();x++)
      out.print(list.get(x));
    out.println();
//while loop
    x=0;
    while(x<list.size()){
      out.print(list.get(x));
      x++;
    }
    out.println();
//do while loop
    x=0;
    do{
      out.print(list.get(x));
      x++;
    }while(x<list.size());
    out.println();
//for each loop
    for(int n:list)
      out.print(n);
    out.println();
//lambda version...new with Java 8
    list.forEach(n->out.print(n));
    out.println();
//new Java 8 double colon print statement...very cool!
    list.forEach(out::print);
    out.println();
  }
}