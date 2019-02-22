package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

/**
 * Pour supprimer un pizza
 * 
 * @author F.Duarte
 *
 */
public class SupprimerPizzaService extends MenuService {

	String code; // choix de l'utilisateur

	/**
	 * V�rifie l'existance le code du pizzza avant suppression
	 * 
	 * @param read
	 * @param dao
	 * @throws StockageException
	 */
	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) throws DeletePizzaException {

		System.out.println("Veuillez choisir le code de la pizza � supprimer.");
		code = read.next();
		// recherche le pizza demand�
		if (!dao.pizzaExists(code)) {
			throw new DeletePizzaException("Code inexistant");
		}

		else {
			dao.deletePizza(code);

		}

	}

}
