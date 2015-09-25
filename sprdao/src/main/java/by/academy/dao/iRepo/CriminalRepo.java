package by.academy.dao.iRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import by.academy.pojos.Criminal;

public interface CriminalRepo extends JpaRepository<Criminal, Integer>{

}
