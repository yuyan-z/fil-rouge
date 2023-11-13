# Project: Petri net

A Petri net is made up of places (represented by circles), which contain
tokens, and transitions (represented by squares). Arcs (carrying a
weight) link places to transitions (arcs leaving squares) and
transitions to places (arcs entering squares).

In our project, there are various classes and interfaces for
implementing the Petri net, including the classes Place, Arc, ZeroArc,
EmptyArc, Transition, PetriNet, and the interfaces IArc, IPetriNet.

## class Place
It includes the nTokens attribute, as well as methods for
obtaining, setting, adding and decreasing the number of tokens in the
place. + removeTokens(): will remove out the desired number of tokens in
the place. + addTokens(): will add the desired number of tokens into the
place.

## class Arc, ZeroArc and EmptyArc
The Arc class includes weight, direction, place and transition
attributes. But in the ZeroArc and EmptyArc classes, they only have a fixed direction from
place to transition and have a fixed weight. 
+ isFirable() in Arc class:
return true when the number of tokens in the source place is greater
than the weight of the arc entering transition.
+ isFirable() in ZeroArc class: return true when the number of tokens in the source place is 0.
+ isFirable() in EmptyArc class: return true when the number of tokens in
the source place is equal or greater than 1s.

## class Transition
It includes inArcs and outArcs attributes of type List
\< IArc \> as well as the fire() method for firing the transition. +
addInArc(): add an arc conneting from a place to a transition to the
list. + addOutArc(): add an arc conneting from a transition to a place
to the list. + fire(): checks if the Petri net can be fired. If it can
be fired, remove tokens from source places and add tokens to destination
places.

## class PetriNet
It contains the main functions of the Petri net. + The
constructor instantiate a HashMap of places, a HashMap of transitions
and a HashMap of arcs. There are also index for place, transition, and
arc with a view to naming their id. + addPlace(): add a place to the Map
with their id defined by the index, if the value of tokens is negative,
throw exception. + removePlace(): remove place out of Petri net if its
id is equivalent to one of those in the key set. + setPlaceTokens(): set
the number of tokens in the place according to its id. If the added
tokens number is negative, throw exception. + addTransitoin(): add a
transition to the Map with their id defined by the index. +
removeTransition(): remove transition out of Petri net if its id is
equivalent to one of those in the key set. + doTransition(): if there is
no transition, throw exception. If Petri net can be fired, print out
that transition is fired; else print out transition cannot fire. +
addArc(): first, check whether this arc is incoming or outgoing type.
Then check this arc will link which place to which transition. Based on
its characteristics, it will be added to either outgoing arc list or
incoming arc list. Finally, update the HashMap of Arc. If any condition
is not satisfied, throw exception. + setArcWeight(): set arc weight if
weight is superior to 1, else throw exception. + addZeroArc()/
addEmptyArc(): add an zero arc/ empty arc to the list if it links a
place to a transition, else throw exception. + removeArc(): remove arc
out of Petri net if its id is equivalent to one of those in the key
set. + changeArcType(): first, get the arc that needs changing and check
if it exists in the Petri net and it is an incoming arc. Based on the
id, we will remove the original arc and create a new arc with its new
type and the same id. + display(): shows the result after firing the
Petri net on the console + draw() method for visualization using
Swing\'s JFrame tool, illustrating Petri net simulation with real
places, transitions and arcs.

## PetriNetFigure class: 
It contains functions to draw arcs, places,
transitions and simulate 2D Petri Net on JFrame.

## IArc interface
It provides abstract methods to be implemented in Arc,
ZeroArc and EmptyArc classes.

## IPetri interface
It provides methods for to be implemented in PetriNet
class.

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














