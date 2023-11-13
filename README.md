# Project: Petri net

A Petri net is made up of places (represented by circles), which contain
tokens, and transitions (represented by squares). Arcs (carrying a
weight) link places to transitions (arcs leaving squares) and
transitions to places (arcs entering squares).

In our project, there are various classes and interfaces for
implementing the Petri net, including the classes Place, Arc, ZeroArc,
EmptyArc, Transition, PetriNet, and the interfaces IArc, IPetriNet.

## Interface IPetriNet, class PetriNet
PetriNet class contains the main functions for Petri Net simulation and implemented the interface IPerinet.
+ **public PetriNet()**
The constructor for creating a PetriNet.  
It initializes a HashMap of places, a HashMap of transitions and a HashMap of arcs. There are also index for place, transition, and arc with a view to naming their id.
+ **public void addPlace(int n)**
Add a place to the Petri Net with an initial number of tokens.
Parameters:
n: an integer representing the initial number of tokens in the place. If n is negative, an error message is printed.
+ **public void removePlace(String id)**
Remove a place from the Petri Net by its unique identifier.
Parameters:
id: a string representing the unique identifier of the place to be removed.
+ **public void addPlaceTokens(String id, int n)**
Add tokens to a selected place.
Parameters:
id: the unique identifier of the place to add tokens to.
n: an integer representing the number of tokens to add. If n is negative or the selected place is null, an error message is printed.
+ **public void removePlaceTokens(String id, int n)**
Remove tokens from a selected place.
Parameters:
id: the unique identifier of the place to remove tokens from.
n: an integer representing the number of tokens to remove. If n is negative or the selected place is null, an error message is printed.
+ **public void setPlaceNTokens(String id, int n)**
Set the number of tokens in a selected place.
Parameters:
id: the unique identifier of the place.
n: an integer representing the new number of tokens. If n is negative or the selected place is null, an error message is printed.
+ **public int getNTokens(String id)**
Get the number of tokens in a selected place.
Parameters:
id: the unique identifier of the place.
Returns:
An integer representing the number of tokens in the selected place. If the selected place is null, an error message is printed.
Managing Transitions
+ **public void addTransition()**
Add a transition to the Petri Net.
+ **public void removeTransition(String id)**
Remove a transition from the Petri Net by its unique identifier.
Parameters:
id: a string representing the unique identifier of the transition to be removed.
public void fireTransition(String id)
Fire a selected transition, representing an event or state change in the Petri Net.
Parameters:
id: the unique identifier of the transition to fire. If the selected transition is null, an error message is printed.
Managing Arcs
+ **public void addArc(String sourceId, String targetId, int weight)**
Add a regular arc by specifying the source and target objects and the arc's weight.
Parameters:
sourceId: the unique identifier of the source object (either a place or a transition).
targetId: the unique identifier of the target object (either a place or a transition).
weight: an integer representing the weight of the arc. If the weight is not positive, an error message is printed. If the source or target object doesn't exist or if an arc in the same direction already exists, an error message is printed.
+ **public void setArcWeight(String id, int weight)**
Set the weight of a selected regular arc.
Parameters:
id: the unique identifier of the arc.
weight: an integer representing the new weight to set for the arc. If the weight is not positive or if the selected object is not an instance of the Arc class, an error message is printed.
+ **public void addEmptyArc(String sourceId, String targetId)**
Add an empty arc connecting a source and target object.
Parameters:
sourceId: the unique identifier of the source object (either a place or a transition).
targetId: the unique identifier of the target object (either a place or a transition). If the source or target object doesn't exist, an error message is printed.
+ **public void addZeroArc(String sourceId, String targetId)**
Add a zero arc connecting a source and target object.
Parameters:
sourceId: the unique identifier of the source object (either a place or a transition).
targetId: the unique identifier of the target object (either a place or a transition). If the source or target object doesn't exist, an error message is printed.
+ **public void removeIArc(String id)**
Remove a selected arc, empty arc, or zero arc by its unique identifier.
Parameters:
id: the unique identifier of the arc to be removed. If the selected arc is null, an error message is printed.

+ removePlace(): remove place out of Petri net if its
id is equivalent to one of those in the key set.
+ setPlaceTokens(): set
the number of tokens in the place according to its id. If the added
tokens number is negative, throw exception.
+ addTransitoin(): add a transition to the Map with their id defined by the index.
+ removeTransition(): remove transition out of Petri net if its id is
equivalent to one of those in the key set. 
+ fireTransition(): if there is
no transition, throw exception. If Petri net can be fired, print out
that transition is fired; else print out transition cannot fire.
+ addArc(): first, check whether this arc is incoming or outgoing type.
Then check this arc will link which place to which transition. Based on
its characteristics, it will be added to either outgoing arc list or
incoming arc list. Finally, update the HashMap of Arc. If any condition
is not satisfied, throw exception.
+ setArcWeight(): set arc weight if
weight is superior to 1, else throw exception.
+ addZeroArc()/
addEmptyArc(): add an zero arc/ empty arc to the list if it links a
place to a transition, else throw exception.
+ removeArc(): remove arc
out of Petri net if its id is equivalent to one of those in the key
set.
+ changeArcType(): first, get the arc that needs changing and check
if it exists in the Petri net and it is an incoming arc. Based on the
id, we will remove the original arc and create a new arc with its new
type and the same id.
+ display(): shows the result after firing the
Petri net on the console
+ draw() method for visualization using
Swing\'s JFrame tool, illustrating Petri net simulation with real
places, transitions and arcs.

## PetriNetFigure class: 
It contains functions to draw arcs, places,
transitions and simulate 2D Petri Net on JFrame.

## class Place
It includes the nTokens attribute, as well as methods for
obtaining, setting, adding and decreasing the number of tokens in the
place. 
+ **public Place(String id, int nTokens)**  
Constructor for creating a new place.  
Parameters:  
id: a string representing the unique identifier for the place.  
nTokens: an integer representing the initial number of tokens in the place. Must be non-negative. If provided with a negative value, it will be set to 0.
+ **public int getNTokens()**  
Get the number of tokens currently in the place.  
Returns:  
An integer representing the number of tokens in the place.  
+ **public void setNTokens(int n)**  
Set the number of tokens in the place.  
Parameters:  
n: an integer representing the number of tokens. Must be non-negative. If provided with a negative value, an error message will be printed, and the number of tokens will not be updated.  
+ **public void removeTokens(int n)**  
Remove a specified number of tokens from the place.  
Parameters:  
n: an integer representing the number of tokens to be removed. Must be non-negative. If provided with a negative value, an error message will be printed, and the number of tokens will not be updated.  
+ **public void addTokens(int n)**  
Add a specified number of tokens to the place.  
Parameters:  
n: an integer representing the number of tokens to be added. Must be non-negative. If provided with a negative value, an error message will be printed, and the number of tokens will not be updated.  

## Interface IArc, class Arc, class ZeroArc, class EmptyArc
IArc interface provides abstract methods to be implemented in Arc, ZeroArc and EmptyArc classes.  
The Arc class includes weight, direction, place and transition as attributes.  
But in the ZeroArc and EmptyArc classes, they only have a fixed direction from place to transition and have a fixed weight.
+ **public int getWeight()**  
Get the weight of the arc. For EmptyArc, weight = nTokens of the connected place; for ZeroArc, weight = 0.  
Returns:  
An integer representing the weight of the arc.  
+ **public void setWeight(int w)**  
Set the weight of the arc. For EmptyArc and ZeroArc, do nothing.  
Parameters:  
w: an integer representing the new weight to be set for the arc.  
+ **public String getDirection()**  
Get the direction of the arc. For EmptyArc and ZeroArc, direction is p2t.  
Returns:  
A string representing the direction of the arc.  
+ **public boolean isFirable()**  
Check if the arc is firable.  
For Arc, it's firable when the number of tokens in the source place is equal or greater than the weight of the arc entering transition;  
For EmptyArc, it's firable when the number of tokens in the source place is equal or greater than 1.  
For ZeroArc, it's firable when the number of tokens in the source place is 0;  
Returns:  
true if the arc is firable; otherwise, false.  

## class Transition
It includes inArcs and outArcs attributes of type List \< IArc \> as well as the fire() method for firing the transition. 
+ **public Transition(String id)**  
Constructor for creating a new transition.  
Parameters:  
id: a string representing the unique identifier for the transition.  
+ public void addInArc(IArc a)  
Add an incoming arc (IArc) to the transition.  
Parameters:  
a: an incoming arc that connects a place to the transition.  
+ **public void addOutArc(IArc a)**  
Add an outgoing arc (IArc) to the transition.  
Parameters:  
a: an outgoing arc that connects the transition to a place.  
+ **public void removeArc(IArc a)**  
Remove an arc (IArc) from the transition's list of incoming and outgoing arcs.  
Parameters:  
a: the arc to be removed.  
+ **public boolean fire()**
Checks if the Petri net can be fired. If it can be fired, remove tokens from source places and add tokens to destination
places.  
Returns: true if all the incoming arcs are firable, and the transition is fired; otherwise, false.



## Example
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/e78a91eb-7b7f-4a7d-aa80-bb53036fdc14)

1. Add places and a transition
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/5e7848b7-b21a-4cea-b2eb-12a43d23013b)

2. Add arcs
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/1ffd5a4f-f9ce-49c1-80f6-7f730603b19a)
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/daf62357-5442-46f5-ae66-1e96223781c7)

3. Fire the transition, the first time can fire, the second time can't
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/0ad2be24-da34-4698-a1f3-0e7aa9e60b0d)
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/a9f6571a-ae50-4359-b2cb-cbdda636e43e)

5. Modify the Petrinet, and fire the transition
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/cdb3c9ad-ec47-4856-8e48-5599ad980b3a)
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/c07bbdf2-04af-4d8e-a081-d0c5aa51ece8)
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/bdd8d4ce-9a12-4b27-816d-c4c339655dad)
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/fee44768-a4b1-4c59-82c5-74f1de1a2435)

6. Remove the place (and the related arcs)  
   Remove the arc (and modify the related transitions)  
   Remove the transition (and the related arcs)
![image](https://github.com/yuyan-z/fil-rouge/assets/64955334/b1778143-2ea8-445c-9ca9-fc920de0095f)














