package efs.task.functional;

import java.util.*;
import java.util.stream.Collectors;

class PeopleProcessor {

    // TODO: kontynuuj implementację metody tak, aby dla kolekcji (people) obiektów klasy Person zwracała listę
    //       imion ludzi, których wiek jest większy niż podany w argumencie age
    List<String> namesOfPeopleWhoseAgeIsGreaterThan(int age, Collection<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() > age) // filtruj osoby, których wiek jest większy niż podany age
                .map(Person::getName) // mapuj obiekty Person na ich imiona
                .collect(Collectors.toList()); // zbierz imiona do listy
    }

    // TODO: kontynuuj implementację metody tak, aby dla kolekcji (people) obiektów klasy Person zwracała listę
    //       imion ludzi żyjących w danym mieście (cityOfLiving). Lista ma być posortowana po wieku osób.
    List<String> namesOfPeopleSortedByAgeLivingIn(String cityOfLiving, Collection<Person> people) {
        return people.stream()
                .filter(person -> person.getCityOfLiving().equals(cityOfLiving)) // filtruj osoby żyjące w danym mieście
                .sorted(Comparator.comparingInt(Person::getAge)) // sortuj osoby według wieku
                .map(Person::getName) // mapuj obiekty Person na ich imiona
                .collect(Collectors.toList()); // zbierz imiona do listy
    }


    // TODO: kontynuuj implementację metody tak, aby dla kolekcji (people) obiektów klasy Person zwracała mapę
    //       z informacją o średnim wieku osób w poszczególnych miastach
    Map<String, Double> averageAgeByCityOfLiving(Collection<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getCityOfLiving, Collectors.averagingInt(Person::getAge)));
    }
}
