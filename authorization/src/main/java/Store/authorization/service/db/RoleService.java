package Store.authorization.service.db;

import Store.authorization.dto.dtoController.RoleDTO;
import Store.authorization.model.Person;
import Store.authorization.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    void saveRoleInDB(RoleDTO role);

    Optional<Role> getRole(String role);

}
