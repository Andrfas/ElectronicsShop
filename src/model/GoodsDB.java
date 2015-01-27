package model;

import java.sql.*;

/**
 * Created by Andrey on 25.01.2015.
 */
public class GoodsDB {
    public static Good[] getGoods(int startId, int quantity) {
        Statement statement = DBConnection.getStatement();
        ResultSet set = null;
        try {
            set = statement.executeQuery("SELECT * FROM goods");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int rowCount = 0;
        try {
            if (set.last()) {
                rowCount = set.getRow();
                set.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Good[] goodsArr = null;
        goodsArr = new Good[rowCount];

        int counter = 0;
        try {
            while (set.next()) {
                goodsArr[counter] = new Good(set.getInt("id"), set.getString("name"), set.getInt("price"));
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsArr;
    }
}
