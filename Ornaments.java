public class Ornaments
{
 public static void main(String[] args)
 {
   long ans = 0;
   for(long i = 1; i <= 1000000 ; i++)
     ans += i*(i+1)/2;
   
   System.out.println(ans);
 }
}