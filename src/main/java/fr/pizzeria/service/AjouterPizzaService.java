package fr.pizzeria.service;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

import java.util.Scanner;

/**
 * Classe pour ajouter un pizza
 * 
 * @author Diginamic
 *
 */
public class AjouterPizzaService  extends MenuService {

	/**
	 * Execute le Methodes de la classe abstract MenuService
	 * 
	 * @param read , dao
	 * @throws StockageException
	 */
	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) throws SavePizzaException {
		Pizza pizza = new Pizza(null, null, 0, CategoriePizza.SANS_VIANDE);

		System.out.println("Veuillez saisir le code :");
		pizza.setCode(read.next());
		if (pizza.getCode().length() > 3) {

			throw new SavePizzaException("Maximum 3 lettres");
		}
		System.out.println("Veuillez saisir le nom (sans espace) :");
		pizza.setLibbelle(read.next());
		if (pizza.getLibbelle().isEmpty()) {

			throw new SavePizzaException("le libellé ne doit pas étre vide");
		}
		System.out.println("Veuillez saisir le prix :");
		pizza.setPrix(read.nextDouble());

		if (pizza.getPrix() > 20) {

			throw new SavePizzaException("le prix doit étre entre 1 à 20");
		}

		System.out.println("Veuillez saisir le catégorie (VIANDE, SANS_VIANDE , POISSON ) :");
		pizza.setCat(CategoriePizza.valueOf(read.next()));


		if (dao.catExist(pizza.getCat())) {

			throw new SavePizzaException("catégorie inconnu");
		}

		if (pizza.getPrix() > 20) {

			throw new SavePizzaException("le prix doit étre entre 1 à 20");
		}

		dao.saveNewPizza(pizza);

	}

}
