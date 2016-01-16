/**
 * Created by cladlink on 13/01/16.
 */

import java.awt.event.*;
import java.util.EventListener;

public class ControlMouseOver extends Control implements MouseMotionListener
{
    public ControlMouseOver(Model model, Vue vue)
    {
        super(model, vue);
        vue.setMouseControler(this);
    }

    // Correspond au clic maintenu
    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    // correspond au MouseOver
    @Override
    public void mouseMoved(MouseEvent e)
    {/*
        int i;
        for(i=0;i<vue.teamBleue.length;i++)
        {

            if (e.getSource()==vue.joueur[i])
            System.out.println(vue.teamBleue[i]);
            else if(e.getSource()==vue.adversaire[i]);
            System.out.println(vue.teamRouge[i]);

        }*/
    }


}
