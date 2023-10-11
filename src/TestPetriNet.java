public class TestPetriNet{
   public static void main(String args[]) {
      PetriNet petrinet = new PetriNet();

      petrinet.addPlace(1);
      petrinet.addPlace(3);

      petrinet.addPlace(0);
      petrinet.addPlace(1);
      petrinet.addTransition();
      petrinet.addArc("p0", "t0", 1);
      // petrinet.addZeroArc("p0", "t0");
      petrinet.addArc("p1", "t0", 2);
      petrinet.addArc("t0", "p2", 3);
      petrinet.addArc("t0", "p3", 1);

      petrinet.doTransition("t0");
      petrinet.doTransition("t0");

      // petrinet.removePlace("p3");
      // petrinet.removeTransition("t0");
      // petrinet.removeArc("a1");

      System.out.println("------");
   }
}

