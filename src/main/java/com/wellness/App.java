package com.wellness;


import com.wellness.Backend.User;
// import com.wellness.GUIS.Login;
// import com.wellness.GUIS.Main_Menu;
import com.wellness.GUIS.Test_Data;

import javax.swing.SwingUtilities;

public class App 
{
    public static void main( String[] args )
    {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run(){
                User user = new User("Sharvin");
                Test_Data testData = new Test_Data(1, user);
                // testData.setVisible(true);
            }

        });

    }
}

