package by.academy.dao.iRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.pojos.Criminal;

public interface CriminalRepo extends JpaRepository<Criminal, Integer>{
	
	@Query("SELECT c FROM Criminal c WHERE c.criminalName = :name")
	Criminal getCriminalByName(@Param("name") String cName);
	
	@Query("SELECT c FROM Criminal c WHERE c.criminalSurname = :name")
	Criminal getCriminalBySurName(@Param("name") String cSurname);

}
