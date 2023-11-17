package example.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import example.springcourse.model.Person;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> getPeople() {

//        Session session = sessionFactory.getCurrentSession();
//
//        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();

        return null;
    }

    public Person getPerson(int id) {
//        List<Person> people = jdbcTemplate.query(
//                "SELECT * FROM person WHERE id=?",
//                new Object[]{id},
//                new PersonMapper()
//        );
//
//        for (Person person : people) {
//            if (person.getId() == id) return person;
//        }

//        Session session = sessionFactory.getCurrentSession();
//
//        Person person = session.get(Person.class, id);
//        return person;
        return null;
    }

    public void savePerson(Person person) {
//        jdbcTemplate.update(
//                "INSERT INTO Person(name) VALUES (?)",
//                person.getName()
//        );


    }

    public void updatePerson(int id, Person person) {
//        jdbcTemplate.update(
//                "UPDATE person SET name=? WHERE id=?",
//                person.getName(), id
//        );
    }

    public void deletePerson(int id) {
//        jdbcTemplate.update(
//                "DELETE FROM person WHERE id=?",
//                id
//        );
    }

    public void testMultiply() {
        List<Person> people = createPeople1000();

        long before = System.currentTimeMillis();

//        for (Person person : people) {
//            jdbcTemplate.update(
//                    "INSERT INTO person VALUES (?, ?)",
//                    person.getId(), person.getName()
//            );
//        }

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));

    }

    public void testBatch() {
        List<Person> people = createPeople1000();
        long before = System.currentTimeMillis();

//        jdbcTemplate.batchUpdate(
//                "INSERT INTO person VALUES (?, ?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                        preparedStatement.setInt(1, people.get(i).getId());
//                        preparedStatement.setString(2, people.get(i).getName());
//                    }
//
//                    @Override
//                    public int getBatchSize() {
//                        return people.size();
//                    }
//                }
//        );

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));

    }

    public List<Person> createPeople1000() {
//        List<Person> people = new ArrayList<>();
//        for (int i = 1; i < 1001; i++) {
//            Person person = new Person();
//            person.setName("person " + i);
//            person.setId(i);
//            people.add(person);
//        }
//        return people;
        return null;
    }

}
