package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

/**
 * classe abstract pour executer les différentes dao
 * 
 * @author F.Duarte
 */
public abstract class MenuService {
	
	public abstract void methodeUC(Scanner read, IPizzaDao dao) throws StockageException;

}
