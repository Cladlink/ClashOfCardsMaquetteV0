/**
 * Created by cladlink on 11/01/16.
 */
public class Appli
{
    public static void main (String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Model model = new Model();
                ControlGroup controler = new ControlGroup(model);
            }
        });
    }
}