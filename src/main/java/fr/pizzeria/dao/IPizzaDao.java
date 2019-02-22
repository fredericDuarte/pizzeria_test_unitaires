package fr.pizzeria.dao;

import java.util.List;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * 
 * @author F.Duarte
 *
 */
public interface IPizzaDao {

	public List<Pizza> findAllPizzas();
	public void saveNewPizza(Pizza pizza) throws SavePizzaException;
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	public void deletePizza(String codePizza) throws DeletePizzaException;
	public Pizza findPizzaByCode(String codePizza);
	public boolean pizzaExists(String codePizza);
	boolean catExist(CategoriePizza categoriePizza);
}
