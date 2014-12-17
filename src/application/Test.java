package application;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import noyau.*;

public class Test {
	 static Scanner in = new Scanner(System.in);
	 static Grille g=new Grille();

	/**
	 * @param args
	 * @throws CaseNonAttribue 
	 * @throws DivisionByZero 
	 * @throws ArgumentsFonctionVide 
	 * @throws formuleCycliqueException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws formuleCycliqueException, ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		g.add("A1", new Case("A",1));
		g.add("A2", new Case("A",2));
		g.add("A3", new Case("A",3));
		g.add("A4", new Case("A",4));
		g.add("A6", new Case("A",6));
		g.add("B2", new Case("B",2));
		g.add("B4", new Case("B",4));
		g.add("B6", new Case("B",6));
		g.add("C2", new Case("C",2));
		g.add("C4", new Case("C",4));
		g.add("C6", new Case("C",6));
		g.add("D6", new Case("D",6));
		g.add("E4", new Case("E",4));

		g.fixerValeur("A1", 100.0);
		g.fixerValeur("A2", 50.0);
		g.fixerValeur("A3", 0.5);
		g.fixerValeur("A4", 0.0);
		g.fixerValeur("B2", 12.0);
		g.fixerValeur("C2", 30.0);
		
		Case c6 = g.get("C6");
		Case c2 = g.get("C2");
		Case a1 = g.get("A1");
		Case a2 = g.get("A2");
		Case a3 = g.get("A3");
		Case a4 = g.get("A4");
		Case b2 = g.get("B2");
		Case b4 = g.get("B4");
		Case b6 = g.get("B6");
		Case e4 = g.get("E4");


		g.setFormule("A6", new Soustraction (c6,c2));
		g.setFormule("B4", new Addition (a1,a2));
		g.setFormule("C4", new Division (a1,a3));
		g.setFormule("E4", new Division (a2,a4));

		List<Case> arg= new LinkedList<Case>();	
		arg.add(b2);
		arg.add(a2);
		arg.add(a3);
		g.setFormule("B6", new Somme (arg));
		
		List<Case> arg2= new LinkedList<Case>();
		arg2.add(a4);
		arg2.add(b4);
		arg2.add(b6);
		g.setFormule("C6", new Moyenne (arg2));
		
		List<Case> arg3= new LinkedList<Case>();	
		arg3.add(b4);
		arg3.add(e4);
		g.setFormule("D6", new Somme (arg3));
		
		
		//g.load("sauvergarde.bin");
		afficherCase();
		
		
		int choix=0;
		  do {
		  menu();
		  System.out.print("votre choix? ");
		  choix = in.nextInt();
		  switch (choix) {		  
		  case 1 : // modifier Valeur
			menuModification1();
			break;
		  case 2 : // modifier Valeur
				menuModification2();
				break;
		  case 3 : // modifier Valeur
				menuModification3();
				break;
		  case 4 : // modifier Valeur
				menuModification4();
				break;
		  case 5 : // modifier Valeur
				menuModification5();
				break;
		  case 6 : // modifier Valeur
				menuModification6();
				break;
		  case 7 : // modifier Valeur
				menuModification7();
				break;
		  case 8 : // modifier Valeur
				menuModification8();
				break;
		  case 9 : // modifier Valeur
				menuModification9();
				break;
		  case 10 : // modifier Valeur
				menuModification10();
				break;
		  case 11 : // modifier Valeur
				menuModification11();
				break;
		  case 12 : // modifier Valeur
				menuModification12();
				break;
		  case 13 : // modifier Valeur
				menuModification13();
				break;
		  case 14 : // modifier Valeur
				g.changerLangue();
				afficherCase();
				break;

		  case 0: // quitter
		  }
		  } while (choix!=0);


		System.out.println("au revoir");
		g.save("sauvergarde.bin");
	
	}




static void menuModification1() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
		System.out.println("entrer la valeur que vous voulez fixer dans A1\n");
	    String res;
	    res=in.next();
	    double value=Double.valueOf(res);
	    g.fixerValeur("A1",value);
	    afficherCase();
	}

static void menuModification2() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
	System.out.println("entrer la valeur que vous voulez fixer dans A2\n");
    String res;
    res=in.next();
    double value=Double.valueOf(res);
    g.fixerValeur("A2",value);
    afficherCase();
}

static void menuModification3() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue{
	System.out.println("entrer la valeur que vous voulez fixer dans A3\n");
    String res;
    res=in.next();
    double value=Double.valueOf(res);
    g.fixerValeur("A3",value);
    afficherCase();
}

static void menuModification4() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
	System.out.println("entrer la valeur que vous voulez fixer dans A4\n");
    String res;
    res=in.next();
    double value=Double.valueOf(res);
    g.fixerValeur("A4",value);
    afficherCase();
}

static void menuModification5() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
	System.out.println("entrer la valeur que vous voulez fixer dans A6\n");
    String res;
    res=in.next();
    double value=Double.valueOf(res);
    g.fixerValeur("A6",value);
    afficherCase();
}

static void menuModification6() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
	System.out.println("entrer la valeur que vous voulez fixer dans B2\n");
	String res;
	res=in.next();
	double value=Double.valueOf(res);
	g.fixerValeur("B2",value);
	afficherCase();
}

static void menuModification7() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue{
System.out.println("entrer la valeur que vous voulez fixer dans B4\n");
String res;
res=in.next();
double value=Double.valueOf(res);
g.fixerValeur("B4",value);
afficherCase();
}

static void menuModification8() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
System.out.println("entrer la valeur que vous voulez fixer dans B6\n");
String res;
res=in.next();
double value=Double.valueOf(res);
g.fixerValeur("B6",value);
afficherCase();
}

static void menuModification9() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
	System.out.println("entrer la valeur que vous voulez fixer dans C2\n");
    String res;
    res=in.next();
    double value=Double.valueOf(res);
    g.fixerValeur("C2",value);
    afficherCase();
}

static void menuModification10() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
System.out.println("entrer la valeur que vous voulez fixer dans C4\n");
String res;
res=in.next();
double value=Double.valueOf(res);
g.fixerValeur("C4",value);
afficherCase();
}

static void menuModification11() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue{
System.out.println("entrer la valeur que vous voulez fixer dans C6\n");
String res;
res=in.next();
double value=Double.valueOf(res);
g.fixerValeur("C6",value);
afficherCase();
}

static void menuModification12() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
System.out.println("entrer la valeur que vous voulez fixer dans D6\n");
String res;
res=in.next();
double value=Double.valueOf(res);
g.fixerValeur("D6",value);
afficherCase();
}

static void menuModification13() throws ArgumentsFonctionVide, DivisionByZero, CaseNonAttribue {
	System.out.println("entrer la valeur que vous voulez fixer dans E4\n");
	String res;
	res=in.next();
	double value=Double.valueOf(res);
	g.fixerValeur("E4",value);
	afficherCase();
	}

static void afficherCase()
{
	Case c6 = g.get("C6");
	Case c4 = g.get("C4");
	Case c2 = g.get("C2");
	Case a1 = g.get("A1");
	Case a2 = g.get("A2");
	Case a3 = g.get("A3");
	Case a4 = g.get("A4");
	Case a6 = g.get("A6");
	Case b2 = g.get("B2");
	Case b4 = g.get("B4");
	Case b6 = g.get("B6");
	Case d6 = g.get("D6");
	Case e4 = g.get("E4");
	System.out.println("Val ["+a1.getNom()+"] = "+a1.getValeur()+"    "+g.getContent("A1")+"    "+g.getContentDev("A1"));
	System.out.println("Val ["+a2.getNom()+"] = "+a2.getValeur()+"    "+g.getContent("A2")+"    "+g.getContentDev("A2"));
	System.out.println("Val ["+a3.getNom()+"] = "+a3.getValeur()+"    "+g.getContent("A3")+"    "+g.getContentDev("A3"));
	System.out.println("Val ["+a4.getNom()+"] = "+a4.getValeur()+"    "+g.getContent("A4")+"    "+g.getContentDev("A4"));
	System.out.println("Val ["+a6.getNom()+"] = "+a6.getValeur()+"    "+g.getContent("A6")+"    "+g.getContentDev("A6"));
	System.out.println("Val ["+b2.getNom()+"] = "+b2.getValeur()+"    "+g.getContent("B2")+"    "+g.getContentDev("B2"));
	System.out.println("Val ["+b4.getNom()+"] = "+b4.getValeur()+"    "+g.getContent("B4")+"    "+g.getContentDev("B4"));
	System.out.println("Val ["+b6.getNom()+"] = "+b6.getValeur()+"    "+g.getContent("B6")+"    "+g.getContentDev("B6"));
	System.out.println("Val ["+c2.getNom()+"] = "+c2.getValeur()+"    "+g.getContent("C2")+"    "+g.getContentDev("C2"));
	System.out.println("Val ["+c4.getNom()+"] = "+c4.getValeur()+"    "+g.getContent("C4")+"    "+g.getContentDev("C4"));
	System.out.println("Val ["+c6.getNom()+"] = "+c6.getValeur()+"    "+g.getContent("C6")+"    "+g.getContentDev("C6"));
	System.out.println("Val ["+d6.getNom()+"] = "+d6.getValeur()+"    "+g.getContent("D6")+"    "+g.getContentDev("D6"));
	System.out.println("Val ["+e4.getNom()+"] = "+e4.getValeur()+"    "+g.getContent("E4")+"    "+g.getContentDev("E4"));


}




static void menu() {
    System.out.println("\n1:A1\n2:A2\n3:A3\n4:A4\n5:A6\n6:B2\n7:B4\n8:B6\n9:C2\n10:C4\n11:C6\n12:D6\n13:E4\n14:Changer la langue\n0: quitter\n");
  }
}
