package servlets;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import static java.lang.String.format;

@WebServlet({"/connect"})
public class ConnectionDemo extends HttpServlet {

    private static final String SELECT = "SELECT Id, Name, Phone FROM [dbo].[Students]";

    private static final String SELECT_WHERE = SELECT + "WHERE Name = ";

    public String t(final String query, final boolean command, final int arg1, final String arg2) {

        final StringBuilder answer = new StringBuilder();
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://172.16.193.223:1433;databaseName=YNS_STUDENT;";
            connection = DriverManager
                    .getConnection(connectionUrl, "Student", "fitfit");

            if (!command) {
                PreparedStatement prep = connection.prepareStatement(query);
                ResultSet rs = prep.executeQuery();
                while (rs.next()) {
                    answer.append(format("Id: %d\n", rs.getInt("Id")));
                    answer.append(format("Name: %s\n", rs.getString("Name")));
                    answer.append(format("Phone: %s\n\n", rs.getString("Phone")));
                }
            } else {
                CallableStatement proc =
                        connection.prepareCall("exec update_name @ID = ?, @NAME = ?");
                proc.setInt(1, arg1);
                proc.setString(2, arg2);
                proc.execute();
                answer.append(t(format("%s", SELECT), false, 0, ""));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed! Check output console");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return answer.toString();
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        String res = "Xxmmmm";
        if (req.getParameter("find") != null) {
            final String firstName = req.getParameter("name");
            if(firstName == null || firstName.isEmpty())
                res = t(format("%s", SELECT), false, 0, "");
            else
                res = t(format("%s'%s'", SELECT_WHERE, firstName), false, 0, "");
        } else if (req.getParameter("command") != null) {
            final int arg1 = Integer.parseInt(req.getParameter("arg1"));
            final String arg2 = req.getParameter("arg2");
            res = t("", true, arg1, arg2);
        }
        final PrintWriter writer = resp.getWriter();
        writer.println(res);
    }
}
