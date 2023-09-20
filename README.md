## Explanation


In order to facilitate the manipulation of a specified palce, transition or arc, we want to add a unique identifier as an attribute for each object, and a function to set the identifier.
Therefore, we create the class PetriElem and let the class Place, Transition, Arc inherit it.



class PetriNet
As a Petri Net consists of several places, transitions and arcs, we create 3 lists as attributs to store them separately.
In order to allow users to add or remove the places, transitions and arcs in the Petri Net, we create a series of functions
