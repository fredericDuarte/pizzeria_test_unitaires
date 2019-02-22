package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * Classe pour modifier un pizza
 * @author F.Duarte
 *
 */
public class ModifierPizzaService extends MenuService {


	String code;
	/**
	 * Execute le Methodes de la classe abstract MenuService
	 * 
	 * @param read , dao
	 * @throws StockageException 
	 */
	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) throws UpdatePizzaException {

		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		code = read.next();
		// recherche le pizza demandé
		if(!dao.pizzaExists(code))
		{
			throw new UpdatePizzaException("Code inexistant");
		}
		else
		{
			Pizza pizzaFind = dao.findPizzaByCode(code);

			System.out.println("Veuillez saisir le nouveau code :");
			pizzaFind.setCode(read.next());
			if (pizzaFind.getCode().length() > 3) {

				throw new UpdatePizzaException("Maximum 3 lettres");
			}
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			pizzaFind.setLibbelle(read.next());
			if (pizzaFind.getCode().isEmpty()) {

				throw new UpdatePizzaException("le code ne doit pas étre vide");
			}
			System.out.println("Veuillez saisir le nouveau prix :");
			pizzaFind.setPrix(read.nextDouble());
			if (pizzaFind.getPrix() > 20) {

				throw new UpdatePizzaException("le prix doit être entre 1 et 20");
			}
			
			System.out.println("Veuillez saisir le catégorie (VIANDE, SANS_VIANDE , POISSON ) :");
			pizzaFind.setCat(CategoriePizza.valueOf(read.nextLine()));
			
			if(dao.catExist(pizzaFind.getCat()))
			{

				throw new UpdatePizzaException("catégorie inconnu");
			}
			
			dao.updatePizza(code, pizzaFind);
		

		}

	}

}
