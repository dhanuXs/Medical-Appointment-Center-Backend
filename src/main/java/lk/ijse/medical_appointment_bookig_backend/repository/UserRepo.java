package lk.ijse.medical_appointment_bookig_backend.repository;
import lk.ijse.medical_appointment_bookig_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findByEmail(String userName);

    boolean existsByEmail(String userName);

    int removeUserByEmail(String email);
}
