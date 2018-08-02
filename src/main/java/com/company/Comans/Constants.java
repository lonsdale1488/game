package com.company.Comans;

public final class Constants {
    private Constants() {
    }
    /*
     * Analytics API constants
     */
    public static final String ANALYTICS_BASE_API_URL = "https://chatbase.com/api/";
    public static final String ANALYTICS_API_TOKEN = "3639cc83-e7d5-4206-84cb-2d948803a2aa";
    public static final String TELEGRAM = "Telegram";

    public static final String BOT_ACCESS_TOKEN = "619644663:AAGqIkcPUKadi-YkdjeV0okwMsGBgZcMKJo";
    public static final String BOT_NAME = "tachgamebot";
    public static final String BOT_VERSION = "1.0";
    /*
     * Database constants
     */
    private static final String DB_REMOTEHOST = "ds111192.mlab.com";
    private static final int DB_REMOTEHOST_PORT = 11192;
    private static final String DB_NAME_REMOTE = "heroku_f4cg1nx2";

    private static final String DB_HOST = DB_REMOTEHOST;
    private static final int DB_PORT = DB_REMOTEHOST_PORT;
    private static final String DB_NAME = DB_NAME_REMOTE;
    private static final String DB_USER = "sergey";
    private static final String DB_PASSWORD = "Sergey1";

    public static final String DB_URL = "mongodb://" + DB_USER + ":" + DB_PASSWORD + "@" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    public  static final String TAG = "Telegram bot";
}
