/**
 * Created by cladlink on 13/01/16.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class ControlMouseOver extends Control implements MouseMotionListener
{

        public ControlMouseOver(Model model, Vue vue)
        {
            super(model, vue);
            vue.setMouseControler(this);
        }

        public void mouseDragged(MouseEvent e)
        {
            System.out.println("coucou");
        }

        public void mouseMoved(MouseEvent e)
        {
            System.out.println("pu coucou");

        }


}
