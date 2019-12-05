## Comparable

- Interface with Generic: `Comparable<T>`
  - `int compareTo(T o)`
    - Negative: The calling object is smaller
    - Positive: The calling object is larger
    - Zero: The two objects are equal
- Implies that the class has a natural ordering
- If a class implements the Comparable interface, then Collections will use the `compareTo` method for its methods like `sort`

```
class Person implements Comparable<Person> {
  String name;
  int age;

  @Override
  public int compareTo(Person other) {
    return this.age - other.age;
  }
}

public class Main {
  public static void main(String[] args) {
    List<Person> list = new ArrayList<>();
    list.add(new Person("john", 28));
    list.add(new Person("amy", 25));
    list.add(new Person("austin", 33));

    System.out.println(list);

    Collections.sort(list);

    System.out.println(list);

  }
}
```

## Comparator

- Interface with Generic: `Comparator<T>`
  - `int compare(T o1, T o2)`
    - `Collections` can be provided an object that implements `Comparator` to handle sorting
    - Custom ordering

```
class PersonNameComparator implements Comparator<Person> {
  @Override
  public int compare(Person one, Person two) {
    return one.name.compareTo(two.name);
  }
}

public class Main {
  public static void main(String[] args) {
    List<Person> list = new ArrayList<>();
    list.add(new Person("john", 28));
    list.add(new Person("amy", 25));
    list.add(new Person("austin", 33));

    System.out.println(list);

    Collections.sort(list, new PersonNameComparator());

    System.out.println(list);

  }
}
```
