package ihm;

/*
 * TablooProto.java requires no other files.
 * 
 */
import java.awt.Color;


import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import noyau.ArgumentsFonctionVide;
import noyau.Case;
import noyau.CaseNonAttribue;
import noyau.DivisionByZero;
import noyau.Grille;

public class TablooProto extends JPanel {
    JTable table;
    // Fourni: ne rien changer.
    public TablooProto(String nomFichier) throws IOException, ClassNotFoundException {
        super(new GridLayout(1, 0));

        // modele de donnees
        // cf. plus loin la inner classe MyTableModel a modifier...
        MyTableModel tableModel = new MyTableModel(nomFichier);

        // la JTable et ses parametres
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 500));
        table.setGridColor(Color.GREEN);
        table.setShowGrid(true);

        // on ajoute un scroll
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // parametrage de la 1ere ligne = noms des colonnes
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        // parametrage de la 1ere colonne consacree a la numerotation des lignes
        TableColumn tm = table.getColumnModel().getColumn(0);
        tm.setPreferredWidth(tm.getPreferredWidth() * 2 / 3);
        tm.setCellRenderer(new PremiereColonneSpecificRenderer(Color.LIGHT_GRAY));

    }

    // Inner class pour changer l'aspect de la premiere colonne consacree a la numerotation des lignes
    // Fourni: ne rien changer.
    class PremiereColonneSpecificRenderer extends DefaultTableCellRenderer {

        Color couleur;

        public PremiereColonneSpecificRenderer(Color couleur) {
            super();
            this.couleur = couleur;
            this.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setBackground(couleur);
            return cell;
        }
    }

    // Inner class pour etablir la connexion entre la JTable graphique et un modele de donnees.
    // Pour nous le modele de donnees sera une grille du noyau de representation et de calcul
    // construite et sauvegardee par serialisation comme precedemmment.
    // Dans ce prototype exemple, le modele de donnees est une simple matrice de String "en dur".
    // Il faudra le remplacer par une connexion a une telle grille.
    class MyTableModel extends AbstractTableModel {

        // TODO
        // remplacer ce tableau en dur du prototype par la grille serialisee:
        // noyau.Grille calc;
    	Grille calc = new Grille();

        MyTableModel(String nomFichier) throws IOException, ClassNotFoundException {
            // TODO: remplacer cette initialisation par le chargement de la grille serialisee
           
            calc.load(nomFichier);
        }

        @Override
        // Standard: doit retourner le nbre de colonnes de la JTable
        public int getColumnCount() {
            // TODO: remplacer par le nbre de colonnes de la grille
            // + 1 pour la colonne 0 consacre aux numeros de ligne)
            return 11;
        }

        @Override
        // Standard: doit retourner le nbre de lignes de la JTable
        public int getRowCount() {
            // TODO: remplacer par le nbre de lignes de la grille
            return 10;
        }

        // Standard: doit renvoyer le nom de la colonne a afficher en tete
        // Fourni: ne rien changer.
        @Override
        public String getColumnName(int col) {
            if (col == 0) {
                return ""; // colonne consacre aux numeros de ligne
            } else {
                return "" + (char) ((int) ('A') + col - 1);
            }
        }

        // Utilitaire interne fourni (ne rien changer)
        // Retourne le nom d'une case a partir de ses coordonnees dans la JTable.
        String getNomCase(int row, int col) {
            return this.getColumnName(col) + String.valueOf(row + 1); // row commence a 0
        }

        @Override
        // Standard: doit renvoyer le contenu a afficher de la case correspondante
        public Object getValueAt(int row, int col) {
            if (col == 0) {
                // Fourni: ne rien changer.
                // en colonne 0 : numeros de lignes
                return "" + String.valueOf(row + 1);
            } else {
                // TODO: remplacer par le contenu + la valeur
                // de la case de nom getNomCase(row, col)
                // dans la grille (comme dans la figure 1 du sujet).
            	Case c = calc.get(getNomCase(row,col));
            	if (c != null)
                     return calc.getContent(getNomCase(row,col));
            	else return "";
 				}
            }
        

        // Standard.
        // Fourni: ne rien changer.
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        // Standard: determine si une case est editable ou non.
        // Fourni: ne rien changer.
        // Seules les cases de la 1er colonne ne le sont pas
        // (consacrees a la numerotation des lignes)
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col < 1) {
                return false; // col 0 consacree a la numerotation des lignes (non editable)
            } else {
                return true;
            }
        }


        // Standard: l'utilisateur a entr une valeur dans une case,
        // mettre a jour le modle de donnees connecte.
        // L'utilisateur a modifie une case.
        // Si c'est une valeur numerique (sinon ne rien faire)
        // - modifier la case correspondante dans la grille si cette case existe
        // - ajouter la case correspondante dans la grille
        @Override
        public void setValueAt(Object value, int row, int col) {

            // TODO remplacer par le code correspondant
            if (value instanceof String) {
            	Case c = calc.get(getNomCase(row,col));
            	if (c!=null)
            	{
	                try {
						calc.fixerValeur(getNomCase(row,col),new Double((String)value));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ArgumentsFonctionVide e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DivisionByZero e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CaseNonAttribue e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	else
            	{
            		Case nouv=new Case(this.getColumnName(col),row+1);
            		calc.add(nouv.getNom(),nouv);
	                try {
						calc.fixerValeur(getNomCase(row,col),new Double((String)value));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ArgumentsFonctionVide e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DivisionByZero e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CaseNonAttribue e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
            // Ne pas modifier :
            // mise a jour automatique de l'affichage suite a la modification
            fireTableCellUpdated(row, col);
            table.repaint();
        }
    }
    // Fin de la inner class MyTableModel

    // Excution de l'interface graphique a partir d'un terminal.
    // TODO: parametrer le tout par un fichier de grille serialisee.
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO: parametrer le tableur par un fichier de grille serialisee
        // a charger comme modele de donnees.
        TablooProto tableur = new TablooProto(args[0]);

        // Creation de l'application et lancement
        // Fourni: ne rien changer.
        JFrame frame = new JFrame("TABLOO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableur.setOpaque(true);
        frame.setContentPane(tableur);
        frame.pack();
        frame.setVisible(true);

    }
}
