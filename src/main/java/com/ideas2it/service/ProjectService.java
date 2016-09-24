package com.ideas2it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.dao.ProjectDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;

/**
 * <p>
 * Service class which does validations with the user input of project
 * details. Passes values to the Dao class to carry out manipulations. Throws
 * error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveen Raj
 *
 * @created 2016-09-09
 */

@Service("projectService")
public class ProjectService {
	
	@Autowired
	ProjectDao projecttDao;

	/**
	 * <p>
	 * This method checks the presence of project ID in the database. Passes
	 * the value to its dao class to insert if not present.
	 * </p>
	 * 
	 * @param project
	 *            model object that stores the project data associated with
	 *            model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean addProject(Project project) throws DataException {
		return projecttDao.insertProject(project);
	}

	/**
	 * <p>
	 * This method checks the presence of project ID in the database. Passes
	 * the value to its dao class to update if present.
	 * </p>
	 * 
	 * @param project
	 *            model object that stores the project data associated with
	 *            model.
	 * @return boolean gives the status of the update from the database.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean updateProject(Project project) throws DataException {
		return projecttDao.modifyProject(project);
	}

	/**
	 * <p>
	 * This method checks the presence of project ID in the database. Passes
	 * the value to its dao class to delete if present.
	 * </p>
	 * 
	 * @param projectId
	 *            contains the ID of the project.
	 * @return boolean gives the status of the deletion from the database.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean deleteProject(int projectId) throws DataException {
		if (searchProject(projectId) != null) {
			return projecttDao.removeProject(searchProject(projectId));
		}
		return false;
	}

	/**
	 * <p>
	 * This method passes the client ID to its dao class to search in the
	 * database. Returns the model object of the project to its controller
	 * to display.
	 * </p>
	 *
	 * @param projectId
	 *            contains the ID of the project.
	 * 
	 * @return project gives the appropriate project object for the
	 *         corresponding projectID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Project searchProject(int projectId) throws DataException {
		return projecttDao.findProjectById(projectId);
	}

	/**
	 * <p>
	 * This method retrieves the Project data from the records and returns
	 * the list of data to display.
	 * </p>
	 * 
	 * @return list Gives the list of project details retrieved from the
	 *         database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Project> getProjects() throws DataException {
		return projecttDao.retrieveProjects();
	}

	/**
	 * <p>
	 * This method retrieves the Project data for given client from the
	 * records and returns the list of data to display.
	 * </p>
	 * 
	 * @param clientId
	 *            contains the ID of the client.
	 * @return list Gives the list of project details for given clientId
	 *         retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Project> getDesgignationByClient(int clientId) throws DataException {
		return projecttDao.retrieveProjectByClient(clientId);
	}
}
