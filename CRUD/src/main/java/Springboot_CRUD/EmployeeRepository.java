package Springboot_CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EntityClass, Long>
{

}
