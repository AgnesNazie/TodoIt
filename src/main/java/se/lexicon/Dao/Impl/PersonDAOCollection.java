package se.lexicon.Dao.Impl;

import se.lexicon.Dao.PersonDAO;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {
    private final List<Person> persons = new ArrayList<>();

    @Override
    public Person persist(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        for (Person p : persons) {
            if (p.getId() == person.getId()) {
                throw new IllegalArgumentException("Person with this ID already exists");
            }
            if (p.getEmail().equalsIgnoreCase(person.getEmail())) {
                throw new IllegalArgumentException("Person with this email already exists");
            }
        }

        persons.add(person);
        return person;
    }

    @Override
    public Person findById(Integer id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(Integer id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
