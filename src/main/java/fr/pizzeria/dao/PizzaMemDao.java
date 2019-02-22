package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author F.Duarte
 *
 */
public class PizzaMemDao implements IPizzaDao {

	List<Pizza> listPizza = new ArrayList<Pizza>();
	Iterator<Pizza> iterator;
	Pizza[] arrayTemp;

	/**
	 * constructeuur
	 */
	public PizzaMemDao() {
		/* Ajouts des pizzas */

		try {
			saveNewPizza(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
			saveNewPizza(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
			saveNewPizza(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE));
			saveNewPizza(new Pizza(6, "ORI", "L’orientale", 13.50, CategoriePizza.VIANDE));
			saveNewPizza(new Pizza(7, "IND", "L’indienne", 14.00, CategoriePizza.VIANDE));

		} catch (SavePizzaException e) {

			System.out.println(e.getMessage());
		}

	}

	/**
	 * retourne la liste des pizzas
	 * 
	 * @return List<Pizza>
	 */
	public List<Pizza> findAllPizzas() {

		return listPizza;
	}

	/**
	 * Ajout un nouveau pizza dans la liste
	 * 
	 * @param Pizza
	 */
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		listPizza.add(pizza);

	}

	/**
	 * Mettre à jour le pizza demandé
	 * 
	 * @param codePizza,pizza
	 */
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

		for (int i = 0; i < listPizza.size(); i++) {
			Pizza pizzo = listPizza.get(i);
			if (pizzo.getCode().equals(codePizza))
				listPizza.get(i).setCode(codePizza);
			listPizza.get(i).setLibbelle(pizzo.getLibbelle());
			listPizza.get(i).setPrix(pizzo.getPrix());

		}

	}

	/**
	 * supprime un pizza demandé
	 * 
	 * @param codePizza
	 */
	public void deletePizza(String codePizza) throws DeletePizzaException {

		for (int i = 0; i < listPizza.size(); i++) {
			Pizza pizzo = listPizza.get(i);
			if (pizzo.getCode().equals(codePizza))
				listPizza.remove(i);
		}

	}

	/**
	 * retourne un objet pizza demandé par un code
	 * 
	 * @param codePizza
	 * @return pizzaFind
	 */
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFind = null;

		iterator = listPizza.iterator();
		while (iterator.hasNext()) {
			Pizza currentPizza = iterator.next();
			if (currentPizza.getCode().equals(codePizza)) {
				pizzaFind = currentPizza;
			}

		}
		return pizzaFind;
	}

	/**
	 * Vérifie si le pizza demandé existe
	 * 
	 * @param codePizza
	 * @return find
	 */
	public boolean pizzaExists(String codePizza) {
		boolean find = false;

		iterator = listPizza.iterator();
		while (iterator.hasNext()) {
			Pizza currentPizza = iterator.next();
			if (currentPizza.getCode().equals(codePizza))
				find = true;
		}
		return find;
	}

	/**
	 * Vérifie si le catégorie existe
	 * 
	 * @param cat
	 * @return boolean
	 */
	public boolean catExist(CategoriePizza cat) {
		
		for (CategoriePizza catFind : CategoriePizza.values()) {
			if (catFind.equals(cat))
				return true;
		}

		return false;
	}

}
