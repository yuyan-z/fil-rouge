Projet : Réseaux du Petri

Un réseau de Petri est composé de places (représentées par des cercles) qui peuvent contenir des jetons et de transitions (représentées par des carrés). Des arcs (porteurs d’une valeur) relient les places aux transitions (arcs sortants des places) et les transitions aux places (arcs entrants dans des places).

Dans notre projet, il y a des différents classes et interfaces pour réaliser le réseau de Petri, dont les classes Place, Arc, ZeroArc, EmptyArc, Transition, PetriNet, et les interfaces IArc, IPetriNet.

- la classe Place :  comporte l’attribut nTokens, ainsi que les méthodes pour obtenir, définir, ajouter et diminuer le nombre de jetons dans la place.

- les classes Arc (arcs normaux), ZeroArc (arcs zéro), EmptyArc (arcs videurs) : pour la classe Arec, elle comporte les attributs poids, direction, place et transition. Mais dans les classes ZeroArc et EmptyArc, on n’a besoin des attributs poids et direction parce qu’ils ont seulement une direction de place à transition et n’ont pas de poids.

- la classe Transition : comporte les attributs inArcs et outArcs de type List < IArc > ainsi que la methode fire() pour tirer la transition.

- la classe PetriNet : comporte 3 attributs places, transitions et arcs.

- l’interface IArc : fournit des méthodes abstraites qui vont être implémenté dans les classe Arc, ZeroArc, EmptyArc. La méthode getWeight() renvoie le poids de l’arc. La méthode isFirable() vérifie si un arc reliant une place à une transition peut être tiré.

- l’interface IPetri : fournit des méthodes pour ajouter ou supprimer des places, des transitions et des arcs, la méthode doTransition() pour tirer la transition de l’identifiant spécifié et les méthodes setArcWeight(), changeArcType().

Par ailleurs, pour mieux illustrer comment fonctionner le réseau de Petri, nous avons ajouté des méthodes drawArc() dans l’interface IArc, display() dans l’interface IPetri pour montrer le résultat. Et finalement, la methode draw() pour visualiser en utilisant l’outil JFrame de Swing.

Pour lancer le code, il faut entrer dans la classe TestPetriNet et exécuter le programme. On devrait ajuster des valeurs des paramètres tels que les poids, le nombre de jetons, changer le type d’arc, ou ajouter plus de places, arcs, transitions, etc.

Pour le code de test, nous avons testé les méthodes principales telles que addPlace(), addArc(), doTransition(), changeArcType(), ou setArcWeight() si elles fonctionnent comme l’expectation. Dans le futur, nous allons tester les méthodes restantes pour assurer le couverture du code.



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














