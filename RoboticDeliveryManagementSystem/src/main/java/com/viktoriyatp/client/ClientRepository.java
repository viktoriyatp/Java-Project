package java.com.viktoriyatp.client;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;

@Repository
public class ClientRepository extends ListCrudRepository<Client,Integer>{

}
