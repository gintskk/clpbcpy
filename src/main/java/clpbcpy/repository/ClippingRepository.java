package clpbcpy.repository;

import clpbcpy.entity.Clipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClippingRepository extends JpaRepository<Clipping, Long> {

    Optional<Clipping> findFirstByOrderByIdDesc();

    void deleteById(long id);

    Optional<Clipping> getById(long id);
}
