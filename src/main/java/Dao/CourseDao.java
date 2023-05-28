package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import db.DbConnect;
import model.Course;
import java.util.ArrayList;

public class CourseDao {

	Connection connection;
	
	
	public CourseDao() throws ClassNotFoundException, SQLException{
		connection = DbConnect.getConnection();
	}
	
	public void addCourse(Course course) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("insert into course(courseName, fees, catagory, duration) values(?,?,?,?)");
			
			pst.setString(1, course.getCourseName());
			pst.setInt(2, course.getFees());
			pst.setString(3, course.getCatagory());
			pst.setInt(4, course.getDuration());
			
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Course> getAllCourses(){
		
		List<Course> courses = new ArrayList<Course>();
		try {
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from course");
			
			while(rs.next()) {
				Course course = new Course();
				course.setCourseID(rs.getInt("courseID"));
				course.setCourseName(rs.getString("courseName"));
				course.setFees(rs.getInt("fees"));
				course.setCatagory(rs.getString("catagory"));
				course.setDuration(rs.getInt("duration"));
				
				courses.add(course);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return courses;
		
	}
	
	
	
	
}
