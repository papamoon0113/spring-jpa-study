package com.example.springedu2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springjpa.exam.repository.BookRepository;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;

	@BeforeEach
	void pr() {
		System.out.println("=".repeat(80));
	}

	@Test
	@Order(1)
	void testFindAll(){
		bookRepository.findAll()
			.forEach(System.out::println);
	}

	@Test
	@Order(2)
	void testFindByOrderByPriceDesc(){
		bookRepository.findByOrderByPriceDesc()
			.forEach(System.out::println);
	}

	@Test
	@Order(3)
	void testFindByPriceGreaterThanEqual(){
		bookRepository.findByPriceGreaterThanEqual(20000)
			.forEach(System.out::println);
	}

	@Test
	@Order(4)
	void testFindById(){
		bookRepository.findById(10)
			.ifPresentOrElse(
				System.out::println,
				()->{System.out.println("******존재하지 않음!!******");}
			);
	}

	@Test
	@Order(5)
	void testFindByTitleStartingWithOrTitleStartingWith(){
		bookRepository.findByTitleStartingWithOrTitleStartingWith("자바", "스프링")
			.forEach(System.out::println);
	}

	@Test
	@Order(7)
	void testFindTopByOrderByPrice(){
		bookRepository.findTopByOrderByPrice()
			.ifPresent(System.out::println);
	}

	@Test
	@Order(8)
	void testCount(){
		System.out.println("전체 도서의 수 : " + bookRepository.count() + "권");
	}

	@Test
	@Order(9)
	void testCountByKind(){
		System.out.println("b05 부류의 도서는 : " + bookRepository.countByKind("b05") + "권");
	}

	@Test
	@Order(10)
	void testFindByTitleStartingWith(){
		bookRepository.findByTitleStartingWith("바닐라")
			.forEach(System.out::println);
	}
}
