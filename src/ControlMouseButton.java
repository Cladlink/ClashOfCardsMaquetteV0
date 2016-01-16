import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by cladlink on 16/01/16.
 */

public class ControlMouseButton extends Control implements MouseListener
{
    Boolean joueur = true;
    ImageIcon carteMemoire = new ImageIcon();
    JLabel[] cartesJoueur = vue.joueur;
    JLabel[] cartesAdversaire = vue.joueur;
    int iMemoire = 10; //revoir l'algo c'est degueu

    public ControlMouseButton(Model model, Vue vue)
    {
        super(model, vue);
        vue.setMouseButton(this);
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        int i, j, k;
        for(i=0;i<vue.teamBleue.length;i++)
        {
            if (e.getSource() == cartesJoueur[i] && joueur)
            {
                carteMemoire = vue.teamBleue[i];
                iMemoire=i;
            }
            else if(e.getSource() == cartesAdversaire[i] && !joueur)
            {
                carteMemoire = vue.teamRouge[i];
                iMemoire=i;
            }
        }
        for(i=0;i<vue.plateau.length;i++)
        {
            for(j=0;j<vue.plateau[i].length;j++)
            {
                if (e.getSource() == vue.plateau[i][j] && iMemoire != 10)
                {
                    vue.plateau[i][j] = new JLabel(carteMemoire);

                    if(joueur)
                    {

                        for (k = 0; k < vue.teamBleue.length; k++)
                        {
                            if (k == iMemoire)
                                cartesJoueur[k] = null;
                        }
                    }
                    if(!joueur)
                    {
                        for (k = 0; k < vue.teamRouge.length; k++)
                        {
                            if (k == iMemoire)
                                cartesAdversaire[iMemoire] = null;
                        }
                    }
                    finTour();
                }
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    private void finTour()
    {
        cartesAdversaire = vue.adversaire;
        cartesJoueur = vue.joueur;
        iMemoire = 10;// pas terrible
        joueur = !joueur; // changement de tour
        vue.repaint();
        vue.creerWidget();
        vue.setVisible(true);
        vue.setMouseButton(this);
    }
}
