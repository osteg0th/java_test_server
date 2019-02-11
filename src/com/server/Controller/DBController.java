package com.server.Controller;

public abstract class DBController {

    public static String SelectFromDB(String[] args) {  //table first
        String result = "select ";
        for (int i = 1; i < args.length; i++) {
            result = result.concat(args[i]) + " ";
        }
        return result.concat("from " + args[0]);
    }

    public static String SelectFromDB(String name1, String table) {
        return "select " + name1 + " from " + table;
    }

    public static String SelectFromDB(String name1, String name2, String table) {
        return "select " + name1 + "," + name2 + " from " + table;
    }

//    public static String SelectFromDB(String name1, String name2, String name3, String table) {
//        return "select " + name1 + "," + name2 + "," + name3 + " from " + table;
//    }

    public static String InsertIntoDB(String name1, String name2, String dbname, String table) {
        return "INSERT INTO " + dbname + "." + table + " (" + name1 + ") VALUES (" + name2 + ");";
    }
}
