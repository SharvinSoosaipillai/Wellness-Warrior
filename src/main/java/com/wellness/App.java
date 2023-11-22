package com.wellness;


import com.wellness.GUIS.Login;
import com.wellness.GUIS.Main_Menu;

import javax.swing.SwingUtilities;
/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run(){
                //Login main = new Login();
                Main_Menu main = new Main_Menu();
            }

        });

    }
}
