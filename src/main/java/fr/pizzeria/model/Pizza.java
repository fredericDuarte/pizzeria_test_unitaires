package fr.pizzeria.model;

import fr.pizzeria.utils.ToString2;
import fr.pizzeria.utils.StringUtils;


/**
 * 
 * @author F.Duarte
 *
 */
public class Pizza {

	/* définitions des variables */

	private int id;
	@ToString2(separateur="->", upperCase=true)
	private String code;
	@ToString2(separateur="->", upperCase=false)
	private String libbelle;
	@ToString2(separateur="(", upperCase=false)
	private double prix;
	@ToString2(separateur="->", upperCase=true)
	private CategoriePizza cat;
	


	/**
	 * constructeur avec paramétre
	 * 
	 * @param code
	 * @param libbelle
	 * @param prix
	 */
	public Pizza(String code, String libbelle, double prix,CategoriePizza cat) {
		super();
		this.code = code;
		this.libbelle = libbelle;
		this.prix = prix;
		this.cat = cat;
	}

	/**
	 * 
	 * @param id
	 * @param code
	 * @param libbelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libbelle, double prix, CategoriePizza cat) {
		super();
		this.id = id;
		this.code = code;
		this.libbelle = libbelle;
		this.prix = prix;
		this.cat = cat;
	}

	
	
	@Override
	public String toString() {
		
		StringUtils ch = new StringUtils();
		ch.concate(this.code);
		ch.concate(this.libbelle);
		ch.concate(this.cat.toString());
		ch.concate(String.valueOf(this.prix) );
		
		return ch.toString();
		//return 	code + "-> " + libbelle + "(" + prix + ")" + "Catégorie :" + cat;
		
		
	}

	/**
	 * Affiche la description d'un pizza
	 */
	public void affiche() {
		System.out.println(code + "-> " + libbelle + "(" + prix + ")" + "Catégorie :" + cat);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibbelle() {
		return libbelle;
	}

	public void setLibbelle(String libbelle) {
		this.libbelle = libbelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}
	
	

}
