package kr.otawang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.otawang.model.Book;
import kr.otawang.model.User;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByUser(User user);
}
