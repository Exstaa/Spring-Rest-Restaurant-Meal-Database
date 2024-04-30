package az.developia.sent6group.springrestmeal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rest_meal")
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer price;
	private String ingredients;
	private String imageLink;

	public Meal patchMeal(Meal dbMeal) {
		if (name == null) {
			setName(dbMeal.getName());
		}
		if (price == null) {
			setPrice(dbMeal.getPrice());
		}
		if (ingredients == null) {
			setIngredients(dbMeal.getIngredients());
		}
		if (imageLink == null) {
			setImageLink(dbMeal.getImageLink());
		}
		return this;
	}
}
