import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Mediator {
    private ClearButton clearButton;
    private CopyButton copyButton;
    private KTextField ktext;
    private KidList klist;
    private PickedKidsList picked;

    public void move() {
        picked.add(ktext.getText());
        clearButton.setEnabled(true);
    }
    //------------------------------------
    public void init() {
        clear();
    }
    //------------------------------------
    public void clear() {
        ktext.setText("");
        copyButton.setEnabled(false);
        clearButton.setEnabled(false);
        picked.clear();
        klist.clearSelection();
    }
    //------------------------------------
    public void select() {
        String s = (String)klist.getSelectedValue();
        ktext.setText(s);
        copyButton.setEnabled(true);
    }
    //------------------------------------
    public void registerClear(ClearButton cb) {
        clearButton = cb;
    }
    //------------------------------------
    public void registerCopy(CopyButton mv) {
        copyButton = mv;
    }
    //------------------------------------
    public void registerText(KTextField tx) {
        ktext = tx;
    }
    //------------------------------------
    public void registerPicked(PickedKidsList pl) {
        picked = pl;
    }
    //------------------------------------
    public void registerKidList(KidList kl) {
        klist = kl;
    }
}
