import org.junit.jupiter.api.Test;

import logic.PetriNet;
import util.PetriException;

import static org.junit.Assert.assertThrows;

public class TestPetriNet {
	/* Add a place with nTokens < 0 */
   @Test
   public void testAddPlace() throws PetriException {
      PetriNet petrinet = new PetriNet();
      assertThrows(PetriException.class, ()->{petrinet.addPlace(-1);});
   }
   
   /* Do a non-existent transition */
   @Test
   public void testDoTransition() throws PetriException {
      PetriNet petrinet = new PetriNet();
      assertThrows(PetriException.class, ()->{petrinet.doTransition("t0");});
   }

   /* Change the type of the selected arc of which the direction isn't p2t */
   @Test
   public void testChangeArcType() throws PetriException {
      PetriNet petrinet = new PetriNet();
      petrinet.addPlace(1);
      petrinet.addTransition();
      petrinet.addArc("p0", "t0", 1);
      assertThrows(PetriException.class, ()->{petrinet.changeArcType("a0", "zeroarc");});
   }

   // @Test(expected = PetriException.class)
   // public void testAddArc() throws PetriException {
   //    PetriNet petrinet = new PetriNet();
   //    petrinet.addPlace(1);
   //    petrinet.addTransition();
   //    // petrinet.addArc("p0", "t0", -1);
   //    // petrinet.addArc("0", "t0", 0);
   //    // petrinet.addZeroArc("p0", "p1");
   //    petrinet.addEmptyArc("t0", "p0");
   // }

   // @Test(expected = PetriException.class)
   // public void testArcWeight() throws PetriException {
   //    PetriNet petrinet = new PetriNet();
   //    petrinet.addPlace(1);
   //    petrinet.addTransition();
   //    petrinet.addEmptyArc("p0", "t0");
   //    petrinet.setArcWeight("a0", 2);
   // }


   public static void main(String args[]) {
      try {
         PetriNet petrinet = new PetriNet();
         
         petrinet.addPlace(1);
         petrinet.addPlace(3);
         petrinet.addPlace(0);
         petrinet.addPlace(1);
         petrinet.addTransition();
         petrinet.display();

         petrinet.addArc("p0", "t0", 1);
         petrinet.addArc("p1", "t0", 2);
         petrinet.addArc("t0", "p2", 3);
         petrinet.addArc("t0", "p3", 1);
         petrinet.display();
         petrinet.draw("Petri Net Simulation 1");

         petrinet.doTransition("t0");
         petrinet.display();
         petrinet.draw("Petri Net Simulation 2");

         petrinet.doTransition("t0");

         petrinet.changeArcType("a0", "ZeroArc");
         petrinet.setPlaceNTokens("p1", 2);
         petrinet.addPlace(4);
         petrinet.addEmptyArc("p4", "t0");
         petrinet.setArcWeight("a2", 1);
         petrinet.display();
         petrinet.draw("Petri Net Simulation 3");
         petrinet.doTransition("t0");
         petrinet.display();
         petrinet.draw("Petri Net Simulation 4");

         petrinet.removePlace("p0");
         petrinet.display();
         petrinet.removeArc("a1");
         petrinet.display();
         petrinet.removeTransition("t0");
         petrinet.display();
         
      } catch (PetriException e) {
         System.out.println(e.getMessage());
      }
   }
}

