package com.wellness.Constants;

import java.awt.Color;
import io.github.cdimascio.dotenv.Dotenv;


public class Constants {

    // colours
    public static final Color BLACK = Color.decode("#353935");
    public static final Color TEXT_COLOR = Color.decode("#32DE84");
    public static final Color BACKGROUN_COLOR_1 = Color.decode("#818589");
    
    // mongodb info
    private static final Dotenv dotenv = Dotenv.load();
    public static final String connectionString = dotenv.get("MONGODBKEY");


}
