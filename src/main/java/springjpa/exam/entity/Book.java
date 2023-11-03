package springjpa.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Book {
	@Id
	private int id;
	private String title;
	private int price;
	private String kind;
}
