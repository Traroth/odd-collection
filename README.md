Work in progress...

I have some ideas about collections I would like to test. The language will be Java 8, and the exact purpose is unclear. What I mean is: I don't *need* those collections for a given projet, so their usefulness may be debatable. They are just ideas I find interesting and I would like to try to implement.

Here they come:

<h3>BijectiveMap</h3>

An interface inheriting java.util.Map, but working both ways, which means keys are unique, but also are values. 

So I added a bunch of methods to obtain the reversed effect of some of the java.util.Map methods. Consequence of the concept is: putAll method throws a UnsupportedOperationException, because I cannot guarantee all elements of the given Map will be added to the BijectiveMap. Some could be squeezed and it couldn't be guaranteed that if you tried to put a Map with 5 entries, your receiving BijectiveMap would contain 5 more elements as a rsult. It could be implemented, but the result would be too unreliable, so I prefered not to.

<h3>DoubleMap</h3>

An implementation of BijectiveMap using 2 HashMaps, one K, V and another V, K. I think better implementations of BijectiveMap could be found, but for now, I just want something to experiment with.

<h3>MultiDimMap</h3>

An interface for multidimensional map. This one doesn't inherit from java.util.Map, because the interface is too different, but it's strongly inspired by it.

<h3>NestedMap</h3>

An implementation of MultiDimMap. Each Entry of the map can contain another map.
