import java.sql.*;
import java.util.*;

public class Task4 {

    private DataSource dataSource;

    public List<String> fetchMonthlyReport(String accountId, int month, int year)
            throws SQLException {

        List<String> entries = new ArrayList<>();

        // FIX: try-with-resources
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM report_entries WHERE account_id = ? AND MONTH(entry_date) = ? AND YEAR(entry_date) = ?"
             )) {

            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            try (ResultSet rs = ps.executeQuery()) { // FIX
                while (rs.next()) {
                    entries.add(rs.getString(1));
                }
            }
        }

        return entries;
    }
}
