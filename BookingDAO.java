package localSkillExchangeSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class BookingDAO {
	public static void bookSkill(int skillId, int userId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO bookings(skill_id, booked_by, booking_date, status) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, skillId);
            ps.setInt(2, userId);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setString(4, "CONFIRMED");
            ps.executeUpdate();
            System.out.println("Booking successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewMyBookings(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT b.booking_id, s.skill_name, b.booking_date, b.status
                FROM bookings b
                JOIN skills s ON b.skill_id = s.skill_id
                WHERE b.booked_by = ?
                """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("booking_id") + " | " +
                        rs.getString("skill_name") + " | " +
                        rs.getDate("booking_date") + " | " +
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
