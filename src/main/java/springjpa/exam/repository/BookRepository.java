package springjpa.exam.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springjpa.exam.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	//	가격이 높은 순으로 도서 리스트를 리턴하는 메서드
	public List<Book> findByOrderByPriceDesc();

	//	전달된 가격 정보와 동일하거나 비싼 도서 리스트를 리턴하는 메서드
	public List<Book> findByPriceGreaterThanEqual(int price);

	//	전달된 분류 정보와 동일한 도서 리스트를 리턴하는 메서드
	public List<Book> findByKind(String kind);

	//	도서 제목이 전달된 아규먼트 값으로 시작하는 도서 리스트를 리턴하는 메서드
	public List<Book> findByTitleStartingWith(String word);

	//	전달된 2개의 아규먼트중 하나를 도서 제목에 포함하는 도서 리스트를 리턴하는 메서드
	public List<Book> findByTitleStartingWithOrTitleStartingWith(String word1, String word2);

	//	가격이 가장 싼 도서를 리턴하는 메서드
	public Optional<Book> findTopByOrderByPrice();

	//	전달된 분류 정보에 속하는 도서의 개수를 리턴하는 메서드
	public long countByKind(String kind);

	//	분류별 도서 가격의 평균을 리턴하는 메서드
//	@Query("SELECT b.kind, AVG(b.price) AS 'avg_price' FROM Book AS b GROUP BY b.kind")
//	public List<Book> readAVGPriceGroupByKind();
}
