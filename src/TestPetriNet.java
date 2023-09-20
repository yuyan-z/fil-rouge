public class TestPetriNet{
   
   public static boolean isPositiveInt(int n){
      boolean res = false;
      if (n > 0) {
         res = true;
      }
      return res;
   }
   
   public static void main(String args[]){
      PetriNet petrinet = new PetriNet();

      petrinet.addPlace(1);
      petrinet.addPlace(3);
      petrinet.addPlace(0);
      petrinet.addPlace(1);
      petrinet.addTransition();
      petrinet.addArc("p0", "t0", 1);
      petrinet.addArc("p1", "t0", 2);
      petrinet.addArc("t0", "p2", 3);
      petrinet.addArc("t0", "p3", 1);

      petrinet.doTransition("t0");
      
      System.out.println("------");
   }
}

