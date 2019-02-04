package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByFirstName(String firstName);
}