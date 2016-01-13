import javax.swing.*;
import java.awt.image.ImagingOpException;

/**
 * Created by cladlink on 11/01/16.
 */
public class Model
{

    boolean joueurA = true;

    public void placeItem(JButton[][] plateau,ImageIcon[] cartes, int i, int j)
    {
        if (joueurA)
        {
            plateau[i][j]=new JButton(cartes[1]);
        }
        else
        {
            plateau[i][j]=new JButton(cartes[2]);
        }
        joueurA=!joueurA;
    }
    public boolean checkVictory(JButton[][] plateau, ImageIcon[] cartes, int i, int j)
    {
        boolean victoire = false;
        if (plateau[i][j].getIcon() == plateau[i][(j+1)%plateau[i].length].getIcon() && plateau[i][j].getIcon() == plateau[i][(j+2)%plateau[i].length].getIcon()
        || (plateau[i][j].getIcon() == plateau[(i+1)%plateau.length][j].getIcon() && plateau[i][j].getIcon() == plateau[(i+2)%plateau[i].length][j].getIcon())
        || (plateau[0][0].getIcon()==plateau[1][1].getIcon() && plateau[0][0].getIcon()==plateau[2][2].getIcon() && plateau[1][1].getIcon() != cartes[0])
        || (plateau[1][1].getIcon()==plateau[2][0].getIcon() && plateau[1][1].getIcon()==plateau[0][2].getIcon() && plateau[1][1].getIcon() != cartes[0]) )
        {
            System.out.println(Math.abs((j-1)%plateau[i].length));
            victoire = true;
        }

        return victoire;
    }
}
