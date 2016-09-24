package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.AddressDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Address;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with User
 * Addresss.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-02
 */

@Repository("addressDao")
@Transactional
public class AddressDaoHibernate extends GenericDaoHibernate<Address, Long> implements AddressDao {

	public AddressDaoHibernate() {
        super(Address.class);
    }

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * address into the database.
	 * </p>
	 * 
	 * @param address
	 *            model object that stores the address data associated with
	 *            model class.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean insertAddress(Address address) throws DataException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			session.save(address);	
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			FileUtil.errorLogger("Exception in insertAddress() : " + exception.getMessage());
			throw new DataException("Error while adding Address ID : " + address.getAddressId());
		} finally {
			session.clear();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * address into the database.
	 * </p>
	 * 
	 * @param address
	 *            model object that stores the address data associated with
	 *            model class.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean modifyAddress(Address address) throws DataException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSession();
			session.update(address);
			return true;
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in insertAddress() : " + exception.getMessage());
			throw new DataException("Error while adding Address ID : " + address.getAddressId());
		} finally {
			session.clear();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and Deletes the address from the records.
	 * </p>
	 * 
	 * @param addressId
	 *            contains the ID of the address.
	 * @return true Gives the success status of the deletion process.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean removeAddress(Address address) throws DataException {
		Session session = null;
		try {
			session = getSession();
			session.delete(address);
			return true;
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in removeAddress() : " + exception.getMessage());
			throw new DataException("Error while deleting Address ID : " + address.getAddressId());
		} finally {
			session.clear();
		}
	}

	/**
	 * <p>
	 * This method searches the address from the records using address ID and
	 * returns the data as a model object to display.
	 * </p>
	 * 
	 * @param departementId
	 *            contains the ID of the address.
	 * @return object gives the appropriate address detail for the corresponding
	 *         address ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Address findAddress(int addressId) throws DataException {
		Session session = null;
		
		try {
			session = getSession();
			return (Address) session.get(Address.class, addressId);
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in findAddress() : " + exception.getMessage());
			throw new DataException("Error while searching Address ID : " + addressId);
		} finally {
			session.clear();
		}
	}

	/**
	 * <p>
	 * This method retrieves the address data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @return list Gives the list of address details stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Address> retrieveAddresss() throws DataException {
		Session session = null;
		try {
			session = getSession();
			return session.createCriteria(Address.class).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveAddresss() : " + exception.getMessage());
			throw new DataException("Error while displaying all Addresss");
		} finally {
			session.clear();
		}
	}

	/**
	 * <p>
	 * This method retrieves the address data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @param userId
	 *            contains identity of the user
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 * @return Address.List return the list of address which is stored under the
	 *         given user
	 */
	public List<Address> retrieveAddressByUser(long userId) throws DataException {
		Session session = null;
		try {
			session = getSession();
			return session.createQuery("From Address WHERE user_id =" + userId).list();
		} catch (HibernateException exception) {
			FileUtil.errorLogger("Exception in retrieveAddressByUser() : " + exception.getMessage());
			throw new DataException("Error while displaying all Address");
		} finally {
			session.clear();
		}
	}
}