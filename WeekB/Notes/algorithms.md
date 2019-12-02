# Algorithms

An algorithm is a set of steps/directions to solve a particular problem.
We often consider algorithms of problems in the industry for common data structures. For example, sorting algorithms. Some methods are faster or slower, or have different pros/cons. Some common search algorithms are bubble sort and quick sort.
Or we often consider how individual methods for specific data structures are implemented, like how ArrayLists dynamically resize.
Additionally we consider problems for specific paradigms, such as problems that can be solved with recursive approaches.

## Big-O Notation

- Notation describing the complexity of an algorithm
  - $O(n^2)$ (quadratic) or $O(1)$ (constant)
- It describes the amount of time it takes for an algorithm to complete based on the input size
- Searching for an element in a randomized array is $O(n)$ (linear), as you would search through the elements one-by-one until you find it
  - As $n$ increases, the time to search increases just as much

        int find(int value, int [] array) {
            for(int i = 0; i < array.length; i++) {
                if(array[i] == value) {
                    return i;
                }
            }

            return -1;
        }

The for loop will above performs 1 additional step when $n$ increases by 1, so we can see that this will be $O(n)$.

    int someMethod(int [] array) {
        int value = 0;
        for(int i = 0; i < array.length; i++) {
            value += array[i];
            for(int j = 0; j < array[i].length; j++) {
                if((i + j) % 2 == 1) {
                    value *= (i + j);
                }
            }
        }

        return value;
    }

Double for loops will perform $n$ additional steps when $n$ increases by 1 so this will be $O(n^2)$.
For loops are not the only construct that has an impact on complexity, but they are the easiest ones to see.

## Sorting

Some very commonly seen algorithms are sorting algorithms. How would you go about sorting a list of numbers in a methodical fashion? `BubbleSort` and `MergeSort` are two such algorithms.

### BubbleSort

BubbleSort is one of the simplest ways of sorting, where you compare 2 numbers, and swap them if needed. You continue checking numbers from left to right until the end.
Then, you repeat this process for each number in the list. This will successfully sort, but the complexity is $O(n^2)$.

### MergeSort

MergeSort goes about the problem by splitting the list in half, sorting each half, and then merging the halves back together again. If you start with 2 already sorted lists, it isn't too hard to merge them into 1 sorted list. This process recursively repeats, taking each of the halves, and halving them again, so on and so forth.
Once you have only 1 or 2 elements in a list, it's easy to sort in a single step. This method turns out to be $O(nlog(n))$ to sort an entire list. This is much more efficient than $O(n^2)$.
