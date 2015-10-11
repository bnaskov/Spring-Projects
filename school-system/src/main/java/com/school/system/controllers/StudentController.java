package main.java.com.school.system.controllers;

import main.java.com.school.system.models.Student;
import main.java.com.school.system.models.StudentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the StudentDao class.
 *
 * @author boni.mislyashki
 */
@Controller
public class StudentController {

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * /create --> Create a new student and save it in the database.
	 * 
	 * @param email
	 *            Student's email
	 * @param name
	 *            Student's name
	 * @return A string describing if the student is succesfully created or not.
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String firstName) {
		Student student = null;
		try {
			student = new Student(email, firstName);
			studentDao.save(student);
		} catch (Exception ex) {
			return "Error creating the student: " + ex.toString();
		}
		return "Student succesfully created! (id = " + student.getId() + ")";
	}

	/**
	 * /delete --> Delete the student having the passed id.
	 * 
	 * @param id
	 *            The id of the student to delete
	 * @return A string describing if the student is successfully deleted or not.
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Student student = new Student(id);
			studentDao.delete(student);
		} catch (Exception ex) {
			return "Error deleting the student:" + ex.toString();
		}
		return "Student succesfully deleted!";
	}

	/**
	 * /get-by-email --> Return the id for the student having the passed email.
	 * 
	 * @param email
	 *            The email to search in the database.
	 * @return The student id or a message error if the student is not found.
	 */
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String studentId;
		try {
			Student student = studentDao.findByEmail(email);
			studentId = String.valueOf(student.getId());
		} catch (Exception ex) {
			return "Student not found";
		}
		return "The student id is: " + studentId;
	}

	/**
	 * /update --> Update the email and the name for the student in the database
	 * having the passed id.
	 * 
	 * @param id
	 *            The id for the student to update.
	 * @param email
	 *            The new email.
	 * @param name
	 *            The new name.
	 * @return A string describing if the student is successfully updated or not.
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateStudent(long id, String email, String firstName) {
		try {
			Student student = studentDao.findOne(id);
			student.setEmail(email);
			student.setFirstName(firstName);
			studentDao.save(student);
		} catch (Exception ex) {
			return "Error updating the student: " + ex.toString();
		}
		return "Student succesfully updated!";
	}

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	@Autowired
	private StudentDao studentDao;

}
