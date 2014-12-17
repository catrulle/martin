package noyau;

import java.io.Serializable;

public abstract class Formule implements Serializable {

	abstract boolean isCycle(Case c);
	abstract void ajoutDependance(Case c);
	abstract double eval() throws ArgumentsFonctionVide,CaseNonAttribue;
	abstract public String toStringBis(String langue);
	abstract public String monToString(String langue);


}
