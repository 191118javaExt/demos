# Collections

- Collection (singular) is an interface that has many useful sub-interfaces and implementations, aka data structures
  - Collectively referred to as Collections API

![Collection Heirarchy](/java/Notes/images/collections.jpg?raw=true "Collection Heirarchy")

## List

- Retains order of insertion
- Useful methods:
  - `add`
  - `remove`
  - `get`
  - `size`
  - `iterator`
  - `listIterator`

## Set

- Does **not** retain order of insertion
- Only contains **unique** elements
  - Elements are checked with the `equals` method to determine repeats
- Useful methods:
  - `add`
  - `remove`
  - `contains`
  - `size`
  - `iterator`

## Map

- **Not** part of the Collection heirarchy, but related
- Contains key-value pairs
- Useful methods:
  - `put`
  - `remove`
  - `get`
  - `keySet`
  - `values`
  - `entrySet`
    - `Entry` is a utility class used for Maps, representing a single key-value pair

## Iterator

- Related interface for the Collections API
- Useful methods:
  - `hasNext`
  - `next`
  - `remove`
- An efficient means of iterating through a collection
  - `next` is **$O(1)$**
- Whoever implements a collection must also provide an implementation for the `Iterator`

## foreach

- AKA `enhanced for loop`
- Converted to use iterators behind the scenes
- Due to this, cannot modify the collection
  - Otherwise throws `ConcurrentModificationException`

## Some implementations

- List: `LinkedList`, `Stack`, `Queue`, `Deque`, `Vector`, `ArrayList`
- Set: `HashSet`, `TreeSet`
- Map: `HashMap`, `TreeMap`
- These are not exhaustive

## `Collections` Class

- A class that does **not** implement `Collection`
- It is a utility class that provides some useful methods that operate on objects in the Collection heirarchy
- Similar to the `Arrays` class that provides utility methods for arrays
- Useful methods:
  - `min`
  - `max`
  - `reverse`
  - `sort`
  - `binarySearch`
