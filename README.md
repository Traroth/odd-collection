Work in progress...

I have some ideas about collections I would like to test. The language will be Java 8, and the exact purpose is unclear. What I mean is: I don't *need* those collections for a given projet, so their usefulness may be debatable. They are just ideas I find interesting and I would like to try to implement.

Here they come:

<h3>BijectiveMap</h3>

An interface inheriting java.util.Map, but working both ways, which means keys are unique, but also are values. 

So I added a bunch of methods to obtain the reversed effect of some of the java.util.Map methods. Consequence of the concept is: putAll method, which is an optional method, throws a UnsupportedOperationException, because I cannot guarantee all elements of the given Map will be added to the BijectiveMap. Some could be squeezed and it couldn't be guaranteed that if you tried to put a Map with 5 entries, your receiving BijectiveMap would contain 5 more elements as a rsult. It could be implemented, but the result would be too unreliable, so I prefered not to.

<h3>DoubleMap</h3>

An implementation of BijectiveMap using 2 HashMaps, one K, V and another V, K. I think better implementations of BijectiveMap could be found, but for now, I just want something to experiment with.

<h3>MultiDimMap</h3>

An interface for multidimensional map. This one doesn't inherit from java.util.Map, because the interface is too different, but it's strongly inspired by it.

<h3>NestedMap</h3>

An implementation of MultiDimMap. Each Entry of the map can contain another map.

<h3>ChunkyList</h3>

ChunkyList is the most ambitious data structure I will try to implement here (yet?).

As you probably know, there are 2 main implementations of a list:

<ul>
<li>in an array (java.util.ArrayList, for example), which is fast when you read data, but slow when you insert, because you have to shift every element of the array located after the inserted element</li>
<li>as a structure of chained elements (java.util.LinkedList), which is fast when you insert an element, because you just have to change linking of the previous and next elements, but slow when you read, because you have to scan across the list to the element you're looking for</li>
</ul>

ChunkyList is an attempt to obtain combine those approaches in order to get an average between the advantages and the drawbacks.

How? To sum it up, the list is composed of several linked arrays. Each array is wrapped in an object called a chunk, with a maximal size, and the different chunks are linked. So when you insert a new element, only the elements of the chunk where you insert need to be shifted (the overflow will be added to a new chunk). And when you want to access an element, you scan across the chunks until you find the right one, and then you access it like in any array.

Of course, you can choose the size of the chunks of your list on instanciation. So if you choose a size of one, the list will behave roughly like a LinkedList, and if you choose a huge size, the list will behave roughly like an ArrayList.

<b>Odd-collection is distributed under the <a href="https://www.gnu.org/copyleft/lesser.html">LGPL v3</a> licence.</b>
