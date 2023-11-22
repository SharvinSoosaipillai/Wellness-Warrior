package com.wellness.Constants;

import java.awt.Color;
import io.github.cdimascio.dotenv.Dotenv;


public class Constants {

    // colours
    public static final Color BLACK = Color.decode("#0F0F0F");
    public static final Color LIGHTBLACK = Color.decode("#1A1A1A");
    public static final Color TEXT_COLOR = Color.decode("#008170");
    public static final Color BACKGROUN_COLOR_1 = Color.decode("#232D3F");
    public static final Color TEXT_COLOR2 = Color.decode("#005B41");
    
    
    // mongodb info
    private static final Dotenv dotenv = Dotenv.load();
    public static final String connectionString = dotenv.get("MONGODBKEY");


}
