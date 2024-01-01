package com.wellness;
import com.wellness.GUIS.Login;
import javax.swing.SwingUtilities;

public class App 
{
    public static void main( String[] args )
    {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run(){
                Login login = new Login();
            }

        });

    }
}

