# Dedekind-Numbers
Java Algorithm to Compute Dedekind's Numbers

Algorithm Step 1: Generate Subsets of an n-set

Algorithm Step 2: Create a graph, wherein each subset points towards all subsets that are (comparable or non-comparable?) to it

Algorithm Step 3: Recursively create chains, whilst progressively checking if they are antichains using step 2

Algorithm Step 4: Loop through chains of lengths 1 to nC[n/2]

Algorithm Step 5: Continuously sum all resulting antichains, and thus all antichains created by subsets of the n-set

Algorithm Step 6: Add 1 to step 5, and that is the n-th Dedekind Number
