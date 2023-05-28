package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.cj.jdbc.ha.RandomBalanceStrategy;

import Dao.CourseDao;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	
	private CourseDao dao;
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        try {
			dao = new CourseDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		
		request.setAttribute("courses", dao.getAllCourses());
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Course course = new Course();
		
		course.setCourseName(request.getParameter("courseName"));
		course.setFees(Integer.parseInt(request.getParameter("fees")));
		course.setCatagory(request.getParameter("catagory"));
		course.setDuration(Integer.parseInt(request.getParameter("duration")));
		
		String courseID = request.getParameter("courseID");
		
		if(courseID==null || courseID.isEmpty()) {
			dao.addCourse(course);
		}
		else {
			
			course.setCourseID(Integer.parseInt(courseID));
			//update
		}
		
	}

}
