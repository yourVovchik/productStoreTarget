package com.isoft.zhelakovich.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        PostgresqlConnector databaseConnector = new PostgresqlConnector();
        try {
            Connection connection = PostgresqlConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT orders.date_time, MAX(products.price_per_unit * orders_items.quantity), products.name\n" +
                    "FROM products JOIN orders JOIN orders_items ON orders.id = orders_items.order_id ON products.id = orders_items.product_id\n" +
                    "GROUP BY  orders.date_time, products.name\n" +
                    "ORDER BY orders.date_time");
            while(resultSet.next()){
                System.out.print(resultSet.getString(1) + " | ");
                System.out.print(resultSet.getString(2) + " | ");
                System.out.print(resultSet.getString(3));
                System.out.println();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
