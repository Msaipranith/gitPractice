package redoc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redoc.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
