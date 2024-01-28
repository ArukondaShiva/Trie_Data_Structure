# Trie

## What is a Trie?

A Trie, also known as a prefix tree, is a tree-based data structure used for efficiently storing and retrieving strings or sequences of characters. Each node in the trie represents a common prefix shared by a group of strings, with the root node representing an empty string. Tries are commonly used in applications such as autocomplete systems, spell checkers, and prefix-based searching due to their fast retrieval and space-efficient storage characteristics.

## Key Features

- **Efficient Retrieval**: Tries provide fast retrieval of strings, making them suitable for tasks like prefix-based searching.
- **Space-Efficient Storage**: They optimize memory usage by sharing common prefixes among strings.
- **Dynamic Insertion and Deletion**: Tries allow for dynamic addition and removal of strings without significant overhead.

## Applications

### Autocomplete Systems

Tries are widely used in autocomplete systems to predict and suggest completions for partially typed queries based on previously entered search terms.

### Orthographic Correctors

Orthographic correctors utilize Trie data structures to provide spelling suggestions and identify errors in text by referencing dictionaries, offering quick and accurate lookups.


## Time Complexity?

| Data Structure     | Structure                               | Time Complexity                    | Suitable For                                |
|--------------------|-----------------------------------------|------------------------------------|---------------------------------------------|
| Binary Trees       | Each node has at most two children      | O(log<sub>2</sub> n)               | Numerical or ordered data                   |
| Quaternary Trees   | Each node has at most four children     | O(log<sub>4</sub> n)               | Numerical or ordered data                   |
| Trie (Prefix Tree) | Tree-like structure with character nodes| O(N * avgL), where 'N' is the number of strings we want to insert in Trie and 'avgL' is the average length of 'N' strings            | String-related operations like autocomplete |


 
 
