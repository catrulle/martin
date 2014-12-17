package noyau;

import java.io.Serializable;
import java.util.HashSet;


public class Case implements Comparable<Case>, Serializable {

	String colonne;
	int ligne;
	double valeur;
	Formule f;
	HashSet<Case> Dependance= new HashSet<Case>();
	public int potentiel;
		
	public boolean isCycle(Case c)
	{
		boolean res=false;
		if (this.f==null)
		{
			if (this==c)
			{
				res=true;
			}
		}
		else
		{
			res=f.isCycle(c);
		}
		return res;
	}
	
	void ajoutDependance(Case c)
	{
		this.Dependance.add(c);
	}
	
	public double getValeur()
	{
		return this.valeur;
	}

	
	
	public String getNom()
	{
		String res = String.valueOf(this.ligne);
		res = this.colonne+res;
		return res;
	}
	
	public void setFormule (Formule form) throws formuleCycliqueException
	{
		if (form.isCycle(this)==false)
		{	
			form.ajoutDependance(this);
			this.f=form;
			this.actualiser();		
		}
		else
		{
			throw new formuleCycliqueException();
		}
	}
	
	public void actualiser()
	{
		if (this.f!=null)
		{
			try
			{
				this.valeur=this.f.eval();
			}
			catch (ArgumentsFonctionVide ex)
		    {
				this.fixerValeur(Double.NaN);
			}
			catch (CaseNonAttribue ex)
		    {
				this.fixerValeur(Double.NaN);
			}
		}
	}
	
	public void fixerValeur(double n)
	{
		if (this.f!=null)
		{
			this.f=null;
		}
		this.valeur=n;
		
	}
	
	
	public Case(String col, int lig)
	{
	  this.ligne=lig;
	  this.colonne=col;
	  this.potentiel=0;
	} 
	
	void propagation(HashSet<Case> resultat)
	{
		for (Case x : this.Dependance)
		{
			if (resultat.contains(x)==false)
			{
				resultat.add(x);
			}
			if (this.potentiel+1 >= x.potentiel)
			{
				x.potentiel=this.potentiel+1;
			}
			x.propagation(resultat);
		}
	}
	
	public int compareTo(Case c)
	{
		if (this.potentiel!=c.potentiel)
			return this.potentiel - c.potentiel;
		else
			return this.getNom().compareTo(c.getNom());
	}

	public void init_pot() 
	{
		this.potentiel=0;
	}

	public String getContent(String langue)
	{
		String res;
		if (this.valeur==Double.NaN)
		{
			res="???";
		}
		else
		{	
			if (f==null)
			{
				res=String.valueOf(this.valeur);
			}
			else
			{
				res=f.monToString(langue)+" = "+String.valueOf(this.valeur);
			}
		}
		return res;
	}
	

		
	public String getContentDev(String langue) {
		String res="";
		if (f==null)
		{
			return String.valueOf(this.valeur);
		}
		else
		{
			res=res+getContentDev2(langue);
		}
		return res+" = "+String.valueOf(this.valeur);
	}
	
	public String getContentDev2(String langue) {
		String res;
		if (f==null)
		{
			res=this.getNom();
		}
		else  
		{
			res=this.f.toStringBis(langue);
		}
		return res;
	}
	
	

	
	
}









