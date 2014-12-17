package noyau;

import java.util.*;


public abstract class Fonction extends Formule {
	public List<Case> arguments= new LinkedList<Case>();
	

	void ajoutDependance(Case c)
	{
		Iterator<Case> iter = this.arguments.iterator();
		while (iter.hasNext())
		{
			iter.next().ajoutDependance(c);
		}
	}

	public String toString()
	{
		String res="";
		Iterator<Case> iter = this.arguments.iterator();
		while (iter.hasNext())
		{
			res=res+iter.next().getNom()+",";
		}
		return res;
	}
	
	public String toStringBis(String langue)
	{
		String res="";
		Iterator<Case> iter = this.arguments.iterator();
		while (iter.hasNext())
		{
			res=res+iter.next().getContentDev2(langue)+",";
		}
		return res;
	}
	
	public Fonction(List<Case> arg)
	{
		arguments=new LinkedList<Case> (arg);
	}
	


	boolean isCycle(Case c)
	{
		boolean res=false;
		Iterator<Case> iter = this.arguments.iterator();
		while (iter.hasNext() && !res)
		{
			res=iter.next().isCycle(c);
		}

		return res;
	}
}
