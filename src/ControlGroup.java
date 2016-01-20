    /**
     * Created by cladlink on 11/01/16.
     */
    public class ControlGroup
    {

        private Model model;
        private Vue vue;
        private ControlMouseButton controlMouseButton;


        public ControlGroup(Model model)
        {
            this.model = model;
            vue = new Vue(model);
            controlMouseButton = new ControlMouseButton(model, vue);
        }
    }
