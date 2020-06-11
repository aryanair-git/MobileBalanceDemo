/**
 * 
 */
package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 202669
 *
 */

public interface MobileRepository extends CrudRepository<MobileEntity, Long>
{

	/**
	 *Method to get mobile details from the table.
	 *
	 */
	@Query("Select data from MobileEntity data where mobileNo=?1")
	Optional<MobileEntity> getMobileDetails(long mobileNo);
}
