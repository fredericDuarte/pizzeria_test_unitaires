package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.*;

/**
 * 
 * @author F.Duarte
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws StockageException {

		/* défintiions des variables */
		int choix = 1; // pour la saisie de l'utilisateur

		/* définitions pour la saisie au clavier */
		Scanner choixUser = new Scanner(System.in);

		PizzaMemDao pizzaDao = new PizzaMemDao();

		MenuServiceFactory User = new MenuServiceFactory();

		while (choix != 99) {

			/* Affichage d'un menu */
			System.out.println("***** Pizzeria Administration *****\n");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizzas");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("votre choix : \n");
			/* Choix de service */

			choix = choixUser.nextInt(); // saisie clavier par l'utilisateur
			if ((choix > 0) && (choix < 5)) {
				MenuService exec = User.choixService(choix);
				try {
					exec.methodeUC(choixUser, pizzaDao);

				} catch (Exception e) {
					System.out.println(e.getMessage());
					choix = 99; // exit
				}
			}

		}

	}
}
