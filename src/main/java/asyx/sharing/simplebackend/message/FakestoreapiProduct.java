package asyx.sharing.simplebackend.message;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreapiProduct {
	int id;
	String title;
	BigDecimal price;
	String description;
	String category;
	String image;
	Rating rating;
}