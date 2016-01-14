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

        // Correspond au clic maintenu
        @Override
        public void mouseDragged(MouseEvent e)
        {

        }

        // correspond au MouseOver
        @Override
        public void mouseMoved(MouseEvent e)
        {
            int i;
            for(i=0;i<vue.teamBleue.length;i++)
            {
                System.out.println(vue.teamBleue[i]);
            }
        }


}
