

public class TestPetrinet{
   
   public static boolean is_positive_int(int n){
      boolean res = false;
      if (n > 0) {
         res = true;
      }
      return res;
   }
   
   public static void main(String args[]){
      boolean res = is_positive_int(-3);
      System.out.printf("%b", res);

      // Petrinet petrinet = new Petrinet();

      // petrinet.add_place("p1", 1);
      // Place place = new Place(0);
      // int n = place.get_n_tokens();
      // System.out.printf("%d", n);
   }


}

