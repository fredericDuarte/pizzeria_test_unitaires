package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
/**
 * Classe de service pour lister les pizzas
 * @author F.Duarte
 *
 */
public class ListerPizzaService extends MenuService {
	
	/**
	 * Methodes du menu des services
	 * 
	 * @param read , dao
	 * @throws StockageException 
	 */
	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) throws StockageException {
	
		System.out.println("Les pizzas");
		
		for (int i = 0; i < dao.findAllPizzas().size(); i++) {
			Pizza pizzaCurrent = dao.findAllPizzas().get(i);
			//pizzaCurrent.affiche();
			pizzaCurrent.toString();
			
		}
		read.nextLine(); // pause jusqu'à l'action par l'utilisateur
		//throw new StockageException("");
	}

}
