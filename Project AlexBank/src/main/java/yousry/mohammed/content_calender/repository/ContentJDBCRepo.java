package yousry.mohammed.content_calender.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import yousry.mohammed.content_calender.model.Content;
import yousry.mohammed.content_calender.model.MaritalStatus;
import yousry.mohammed.content_calender.model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContentJDBCRepo {

        private final JdbcTemplate jdbcTemplate;

        public ContentJDBCRepo(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = rs.getString("department") != null ? Department.valueOf(rs.getString("department")) : null;
        return new Content(rs.getInt("id"),
                rs.getString("fullname"),
                rs.getString("address"),
                MaritalStatus.valueOf(rs.getString("maritalstatus")),
                department,
                rs.getObject("date_created", LocalDateTime.class),
                rs.getString("githuburl"));
    }

    public List<Content> getAllContent() {
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJDBCRepo::mapRow);
        return contents;
    }

    public void createContent(String fullname, String address, MaritalStatus maritalStatus, Department department, String githuburl) {
        String sql = "INSERT INTO Content (fullname, address, maritalStatus, department, date_created, githuburl) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, fullname, address, maritalStatus.name(), department.name(), githuburl);
    }

    public void updateContent(int id, String fullname, String address, MaritalStatus maritalStatus, Department department, String githuburl) {
        System.out.println("Updating content: " + fullname + ", " + address + ", " + maritalStatus + ", " + department + ", " + githuburl + ", " + id);
        String sql = "UPDATE Content SET fullname = ?, address = ?, maritalStatus = ?, department = ?, githuburl = ? WHERE id = ?";
        jdbcTemplate.update(sql, fullname, address, maritalStatus.name(), department.name(), githuburl, id);
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Content getContent(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJDBCRepo::mapRow);
        return content;
    }
}
