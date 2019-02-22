import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMemServiceTest {

	PizzaMemDao pizzaDao = new PizzaMemDao();

	/**
	 * Création d&#39;une &quot;Rule&quot; qui va permettre de substituer le
	 * System.in utilisé par le Scanner par un mock: systemInMock
	 */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testAjouter() throws StockageException {

		systemInMock.provideLines("ADD", "Libelle", "20", "VIANDE");
		AjouterPizzaService exec = new AjouterPizzaService();
		exec.methodeUC(new Scanner(System.in), pizzaDao);

	}

	@Test
	public void testSupprimer() throws StockageException {

		systemInMock.provideLines("IND");
		SupprimerPizzaService exec = new SupprimerPizzaService();
		exec.methodeUC(new Scanner(System.in), pizzaDao);

	}

	@Test
	public void testPizzaExist() {
		systemInMock.provideLines("AAA","AAA","libelle","20");
		IPizzaDao mockedDao = mock(IPizzaDao.class);

		when(mockedDao.findAllPizzas()).thenReturn(new ArrayList<Pizza>());

		ModifierPizzaService service = new ModifierPizzaService();
		String msg = null;
		try {
			service.methodeUC(new Scanner(System.in), mockedDao);

		} catch (UpdatePizzaException e) {
			msg = e.getMessage();
		}
		assertEquals("La base de données ne contient pas de pizzas.", msg);

	}

}
