# Dedekind-Numbers
Java Algorithm to Compute Dedekind's Numbers

Algorithm Step 1: Generate Subsets of an n-set

Algorithm Step 2: Create a graph, wherein each subset points towards all subsets that are (comparable or non-comparable?) to it

Algorithm Step 3: Recursively create chains, whilst progressively checking if they are antichains using step 2

Algorithm Step 4: Loop through chains of lengths 1 to nC[n/2]

Algorithm Step 5: Continuously sum all resulting antichains, and thus all antichains created by subsets of the n-set

Algorithm Step 6: Add 1 to step 5, and that is the n-th Dedekind Number


# Class Descriptions
Dedekind.java includes an instance of Antichains.java. It allows many different ways of calculating the Dedekind Numbers with varying ways of visualizing results. The only complexity of this class is calculating our domain based on input from the user. Alongside this it must loop through each possible value in our domain as a length of an antichain which it sends to Antichains.java.

---

Antichains.java includes a brute-force algorithm of calculating antichains for a given Dedekind Number n from Dedekind.java. There includes two different constructors, one for Dedekind.java, and one for multi-threading.

This class uses multi-threading to greatly expedite the process of calculating large numbers of antichains. In turn, it takes massive CPU usage.

The way it does this is by utilizing information from an instance of Subsets.java to recursively combine subsets of an n-set. Whilst recursively formulating antichains, it subsequently checks if the current chain maintains non-comparability. This greatly cuts down on the run time of calculating ALL combinations of subsets and checking if each one is an antichain. This is done through a map of subsets, in which each subset points towards all subsets that are comparable to it. This means one must simply check if a subset points to another to check if you are maintaining an antichain.

Alongside this, when choosing the next part of the chain, the algorithm chooses solely from a list of all subsets which are non-comparable to the most recent addition. This way, you can significantly decrease the number of candidates of recursion.

Antichains.java must also take a specified length of the antichain you wish to formulate. Once received, it loops through each possible starting subset and subsequently forms the antichain.

---

Subsets.java utilizes a trick in which each subset of the \(n\)-set represents some string of bits, in which a 1 represents that variable is included, and a 0 represents a variable not included. Thus to create all subsets, you must simply convert all integers from 1 to \(2^{n-1}\) into binary.

In doing so, it creates an instance of Subset.java an adds it to an ArrayList. This information is stored as a feild, and can be accessed by Antichain.java.

The final feature of Subsets.java is that it allows Antichains.java to check the comparability between two subsets by accessing information in Subset.java.

---

Subset.java holds a decimal (which can be converted into binary) representation of its subset. A trick utilizing the binary form of the subset can be used to find all comparable sets to it. This consists of keeping an array of all 0s present in the binary representation, and recursively turning them to 1s and storing the newly formed subset.

The algorithms speed is heavily dependant upon how fast it can create antichains, which is dependant on how fast it can check if a chain is non-comparable. All of which is dependant on the efficacy of Subset.java.
