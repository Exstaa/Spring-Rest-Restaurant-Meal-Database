package az.developia.sent6group.springrestmeal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.sent6group.springrestmeal.model.Meal;
import az.developia.sent6group.springrestmeal.repository.MealRepository;

@RestController
public class MealController {
	@Autowired
	private MealRepository repo;

	@CrossOrigin
	@GetMapping("/meals")
	public List<Meal> getAllMeal() {
		return repo.findAll();
	}

	@CrossOrigin
	@PostMapping("/meals/add")
	public Meal addMeal(@RequestBody Meal meal) {
		repo.save(meal);
		return meal;
	}

	@CrossOrigin
	@DeleteMapping("/meals/delete/{id}")
	public void deleteComputer(@PathVariable Integer id) {
		repo.deleteById(id);
	}

	@CrossOrigin
	@PatchMapping("/meals/edit")
	public Meal editMealWithPatchRequest(@RequestBody Meal meal) {
		Meal dbMeal = repo.findById(meal.getId()).get();
		Meal resultMeal = meal.patchMeal(dbMeal);
		repo.save(resultMeal);
		return resultMeal;
	}
}
