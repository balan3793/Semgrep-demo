package com.boobalan;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class VulnCombo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 🚨 SQL Injection
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE name = '" + user + "'";
        stmt.executeQuery(query);

        // 🚨 Command Injection
        System.out.print("Enter shell command: ");
        String cmd = sc.nextLine();
        Runtime.getRuntime().exec(cmd);

        // 🚨 Code Injection
        System.out.print("Enter JavaScript code: ");
        String jsCode = sc.nextLine();
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        engine.eval(jsCode);
    }
}
