package com.company;

import java.sql.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void message (int a, double b)  {

            try {
                Class.forName("oracle.jdbc.OracleDriver");

                String dbURL1 = "jdbc:oracle:thin:your_username/database_password@serverIP:1521:your_server_name";
                final Connection conn1 = DriverManager.getConnection(dbURL1);
                Statement stmt = conn1.createStatement();
                int web = 0;
                int ifi = 0;
                int com1 = 0;
                int com2 = 0;
                String web_data = null;
                String ifi_data = null;
                String com1_data = null;
                String com2_data = null;
                ResultSet rs = stmt.executeQuery("Select ((sysdate-a.F_DATA)*24*60) as Adiff1, ((sysdate-TO_DATE(a.F_N, 'DD.MM.YYYY HH24:MI:SS'))*24*60) as Adiff2, \n" +
                        "TO_CHAR(TO_DATE(a.F_N,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY HH24:MI:SS') as AF_N, TO_CHAR(a.F_DATA, 'DD-MM-YYYY HH24:MI:SS') as AF_DATA,\n" +
                        "((sysdate-b.F_DATA)*24*60) as Bdiff1, ((sysdate-TO_DATE(b.F_N, 'DD.MM.YYYY HH24:MI:SS'))*24*60) as Bdiff2, \n" +
                        "TO_CHAR(TO_DATE(b.F_N,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY HH24:MI:SS') as BF_N, TO_CHAR(b.F_DATA, 'DD-MM-YYYY HH24:MI:SS') as BF_DATA,\n" +
                        "((sysdate-c.F_DATA)*24*60) as Cdiff1, ((sysdate-TO_DATE(c.F_N, 'DD.MM.YYYY HH24:MI:SS'))*24*60) as Cdiff2, \n" +
                        "TO_CHAR(TO_DATE(c.F_N,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY HH24:MI:SS') as CF_N, TO_CHAR(c.F_DATA, 'DD-MM-YYYY HH24:MI:SS') as CF_DATA,\n" +
                        "((sysdate-d.F_DATA)*24*60) as Ddiff1, ((sysdate-TO_DATE(d.F_N, 'DD.MM.YYYY HH24:MI:SS'))*24*60) as Ddiff2, \n" +
                        "TO_CHAR(TO_DATE(d.F_N,'DD-MM-YYYY HH24:MI:SS'), 'DD-MM-YYYY HH24:MI:SS') as DF_N, TO_CHAR(d.F_DATA, 'DD-MM-YYYY HH24:MI:SS') as DF_DATA,      \n" +
                        "a.F_KER_C, b.F_KER_C, c.F_KER_C, d.F_KER_C\n" +
                        "from MY_TIME_TABLE a, MY_TIME_TABLE b, MY_TIME_TABLE c, MY_TIME_TABLE d where a.mainkey = 2 and b.mainkey = 3 and c.mainkey = 4 and d.mainkey = 5");
                while (rs.next()) {
                    if ((rs.getFloat(1) > b || rs.getFloat(2) > b) && !Objects.equals(rs.getString(17), rs.getString(3))) {
                        web = 1;
                        web_data = rs.getString(3);
                        String[] chatID = {"your_chatId_#1", "your_chatId_#2", "your_chatId_#3"};
                        for (String strTemp : chatID) {
                            String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

                            String apiToken = "your_apiToken";

                            String text = "Time_Data_from_Site#1:" + "%0D%0A" + "Import: " + rs.getString(3) + "%0D%0A" + "Export: " + rs.getString(4);

                            urlString = String.format(urlString, apiToken, strTemp, text);

                            try {
                                URL url = new URL(urlString);
                                URLConnection conn = url.openConnection();
                                InputStream is = new BufferedInputStream(conn.getInputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if ((rs.getFloat(5) > b || rs.getFloat(6) > b) && !Objects.equals(rs.getString(18), rs.getString(7))) {
                        ifi = 1;
                        ifi_data = rs.getString(7);
                        String[] chatID = {"your_chatId_#1", "your_chatId_#2", "your_chatId_#3"};
                        for (String strTemp : chatID) {
                            String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

                            String apiToken = "your_apiToken";

                            String text = "Time_Data_from_Site#2:" + "%0D%0A" + "Import: " + rs.getString(7) + "%0D%0A" + "Export: " + rs.getString(8);

                            urlString = String.format(urlString, apiToken, strTemp, text);

                            try {
                                URL url = new URL(urlString);
                                URLConnection conn = url.openConnection();
                                InputStream is = new BufferedInputStream(conn.getInputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if ((rs.getFloat(9) > a || rs.getFloat(10) > a) && !Objects.equals(rs.getString(19), rs.getString(11))) {
                        com1 = 1;
                        com1_data = rs.getString(11);
                        String[] chatID = {"your_chatId_#1", "your_chatId_#2", "your_chatId_#3"};
                        for (String strTemp : chatID) {
                            String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

                            String apiToken = "your_apiToken";

                            String text = "Time_Data_from_Site#3:" + "%0D%0A" + "Import: " + rs.getString(11) + "%0D%0A" + "Export: " + rs.getString(12);

                            urlString = String.format(urlString, apiToken, strTemp, text);

                            try {
                                URL url = new URL(urlString);
                                URLConnection conn = url.openConnection();
                                InputStream is = new BufferedInputStream(conn.getInputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if ((rs.getFloat(13) > a || rs.getFloat(14) > a) && !Objects.equals(rs.getString(20), rs.getString(15))) {
                        com2 = 1;
                        com2_data = rs.getString(15);
                        String[] chatID = {"your_chatId_#1", "your_chatId_#2", "your_chatId_#3"};
                        for (String strTemp : chatID) {
                            String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

                            String apiToken = "your_apiToken";

                            String text = "Time_Data_from_Site#4:" + "%0D%0A" + "Import: " + rs.getString(15) + "%0D%0A" + "Export: " + rs.getString(16);

                            urlString = String.format(urlString, apiToken, strTemp, text);

                            try {
                                URL url = new URL(urlString);
                                URLConnection conn = url.openConnection();
                                InputStream is = new BufferedInputStream(conn.getInputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (web == 1) {
                    stmt.executeUpdate("Update MY_TIME_TABLE set F_KER_C ='" + web_data + "'where mainkey = 2");
                }
                if (ifi == 1) {
                    stmt.executeUpdate("Update MY_TIME_TABLE set F_KER_C ='" + ifi_data + "'where mainkey = 3");
                }
                if (com1 == 1) {
                    stmt.executeUpdate("Update MY_TIME_TABLE set F_KER_C ='" + com1_data + "'where mainkey = 4");
                }
                if (com2 == 1) {
                    stmt.executeUpdate("Update MY_TIME_TABLE set F_KER_C ='" + com2_data + "'where mainkey = 5");
                }
                conn1.close();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    public static void main(String[] args) {
        ScheduledExecutorService timecheck = Executors.newScheduledThreadPool(1);
        Runnable task1 = () -> {
            LocalTime time1 = LocalTime.now();
            LocalTime time2 = LocalTime.parse("18:00:00");
            LocalTime time3 = LocalTime.parse("09:00:00");
            int v = time1.compareTo(time2);
            int v1 = time1.compareTo(time3);
            Calendar calendar = Calendar.getInstance();
            int minutes = calendar.get(Calendar.MINUTE);
            LocalDate localDate = LocalDate.now();
            DayOfWeek dayofWeek = DayOfWeek.from(localDate);
            int day = dayofWeek.getValue();
            if ( v < 0 && v1 > 0  && day != 6 && day != 7) {
                message(11, 11);
            } else if (minutes > 55) {
                message(61, 61);
            }
        }; timecheck.scheduleAtFixedRate(task1,0,5,TimeUnit.MINUTES);
    }
}