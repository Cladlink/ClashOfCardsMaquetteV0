    /**
     * Created by cladlink on 11/01/16.
     */
    public class ControlGroup
    {

        private Model model;
        private Vue vue;
        private ControlMouseOver controlMouseOver;


        public ControlGroup(Model model)
        {
            this.model = model;
            vue = new Vue(model);
            controlMouseOver = new ControlMouseOver(model, vue);
        }
    }
