import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.io.*;

public class FileList extends RestList {
    String files[];

    public FileList() {
        super();
        setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new LineBorder(Color.black)));
        String tmp = "";
        File dir = new File(System.getProperty("user.dir"));
        files = dir.list();
        for (int i = 0; i < files.length; i++) {
            for (int j = i; j < files.length; j++) {
                if (files[i].toLowerCase().compareTo(files[j].toLowerCase()) > 0) {
                    tmp = files[i];
                    files[i] = files[j];
                    files[j] = tmp;
                }
            }
        }
        for (int i = 0; i<files.length; i++)
            add(files[i]);
    }
//---------------------------------------
    public void sendToChain(String mesg) {

        boolean found = false;
        int i = 0; 
        while ((! found) && (i < files.length)) {
            XFile xfile = new XFile(files[i]);
            found = xfile.matchRoot(mesg);
            if (! found) i++;
        }
        if (found) {
            setSelectedIndex(i);
        } else {
            if (nextChain != null)
                nextChain.sendToChain(mesg);
        }
    }
}
