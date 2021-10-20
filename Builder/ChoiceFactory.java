import java.util.*;
public class ChoiceFactory {
    MultiChoice ui;
    public MultiChoice getChoiceUI(Vector choices) {
        if (choices.size() <=3)
            //return a panel of checkboxes
            ui = new CheckBoxChoice(choices);
        else
            //return a multi-select listbox panel
            ui = new ListboxChoice(choices);
        return ui;
    }            
}

