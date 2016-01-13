/**
 * Created by cladlink on 11/01/16.
 */

public abstract class Control
{

    Model model;
    Vue vue;

    public Control(Model model, Vue vue)
    {
        this.model = model;
        this.vue = vue;
    }
}
