package palvelinohjelmointi.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Useer, Long> {
	Useer findByUsername(String username);

}
