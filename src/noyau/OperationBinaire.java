package noyau;


public abstract class OperationBinaire extends Formule{

	Case gauche;
	Case droite;
	
	abstract public String toStringBis(String langue); 

	
	boolean isCycle(Case c)
	{
		boolean res=false;
		res=gauche.isCycle(c);
		if (res==false)
		{
			res=droite.isCycle(c);
		}
		return res;
	}
	
	public OperationBinaire(Case g, Case d) 
	{
		gauche=g;
		droite=d;
	}

	
	
	void ajoutDependance(Case c)
	{
		gauche.ajoutDependance(c);
		droite.ajoutDependance(c);
	}
}
