/**
 * Created by cladlink on 13/01/16.
 */

import java.awt.event.*;
import java.util.EventListener;

import javax.swing.JLabel;

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
    {
    	JLabel event = (JLabel) e.getSource();
    	event.setOpaque(true);
    	event.repaint();
    }


}
