package noyau;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class Grille implements Serializable {
	public Map<String,Case> tableur= new HashMap<String,Case>();
	public String langue="anglais";
	
	double getValeur(String nomCase)
	{
		Case c=tableur.get(nomCase);
		return c.getValeur();
	}

	public void add(String code, Case c)
	{
	  tableur.put(code,c);
	}
	
	public void fixerValeur(String code,double n) throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue
	{
		Case c=tableur.get(code);
		c.fixerValeur(n);
		HashSet<Case> resultat;
		resultat=new HashSet<Case>();
		c.propagation(resultat);
		this.actualiser(resultat);
	}
	
	public void setFormule(String code ,Formule f) throws formuleCycliqueException, ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue
	{
		Case c=tableur.get(code);
		c.setFormule(f);
		HashSet<Case> resultat;
		resultat=new HashSet<Case>();
		c.propagation(resultat);
		this.actualiser(resultat);
	}
	
	public Case get(String nomCase)
	{
		return tableur.get(nomCase);
	}
	
	public String getContent(String nomCase)
	{
		Case c = tableur.get(nomCase);
		return c.getContent(this.langue);
	}
	
	public String getContentDev(String nomCase)
	{
		Case c = tableur.get(nomCase);
		return c.getContentDev(this.langue);
	}
	
	void actualiser(HashSet<Case> resultat) throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue
	{
		TreeSet<Case> res_trie;
		res_trie= new TreeSet<Case>();
		for (Case x : resultat)
		{
			res_trie.add(x);
		}
		for (Case x : res_trie)
		{
			x.actualiser();
			x.init_pot();
		}
		

	}
	
	public void save(String backupName) throws IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(backupName));
		out.writeObject(tableur);
		out.close();
	}
	
	public void load(String backupName) throws IOException,ClassNotFoundException
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(backupName));
		tableur = (Map<String,Case>)in.readObject();
		in.close();
	}
	
	public void changerLangue()
	{
		if (this.langue=="francais")
		{
			this.langue="anglais";
		}
		else 
		{
			this.langue="francais";
		}
	}
	
	
}










