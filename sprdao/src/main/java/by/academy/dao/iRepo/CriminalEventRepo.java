package by.academy.dao.iRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;

public interface CriminalEventRepo extends JpaRepository<CriminalEvent, Integer> {
	
	@Query("SELECT e FROM CriminalEvent e WHERE e.eventDate=:eventDate")
	List<CriminalEvent> getEventsByDate(@Param("eventDate") Date date);
	
	@Query("SELECT e FROM CriminalEvent e WHERE e.criminal=:criminal")
	List<CriminalEvent> getEventsByCriminal(@Param("criminal") Criminal criminal);

	@Query("SELECT e FROM CriminalEvent e WHERE e.eventType=:eventType")
	List<CriminalEvent> getEventsByType(@Param("eventType") EventType eventType);

	@Query("SELECT e FROM CriminalEvent e WHERE e.user=:user")
	List<CriminalEvent> getEventsByUser(@Param("user") User user);

}
