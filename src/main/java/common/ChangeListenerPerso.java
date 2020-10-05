package common;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class ChangeListenerPerso {

	public static class ResetBorder implements ChangeListener<Boolean> {
	    private final TextField textFieldSelect;
	
	    public ResetBorder(TextField textFieldSelect) {
	        this.textFieldSelect = textFieldSelect;
	    }
	
	    @Override
	    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
	        if(newValue) {
	        	textFieldSelect.setStyle("");
	        }
	    }
	}
}