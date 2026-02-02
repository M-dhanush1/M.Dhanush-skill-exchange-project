package localSkillExchangeSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SkillDAO {
	public static void addSkill(int userId, String name, String desc, double price) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO skills(user_id,skill_name,description,price_per_hour) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, name);
            ps.setString(3, desc);
            ps.setDouble(4, price);
            ps.executeUpdate();
            System.out.println("Skill added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewAllSkills() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT s.skill_id, s.skill_name, s.description, s.price_per_hour, u.name
                FROM skills s JOIN users u ON s.user_id = u.user_id
                """;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("skill_id") + " | " +
                        rs.getString("skill_name") + " | " +
                        rs.getString("description") + " | ₹" +
                        rs.getDouble("price_per_hour") + " | By: " +
                        rs.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
