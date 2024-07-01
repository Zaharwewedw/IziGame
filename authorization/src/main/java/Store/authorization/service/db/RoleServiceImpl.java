package Store.authorization.service.db;

import Store.authorization.dto.dtoController.RoleDTO;
import Store.authorization.model.Role;
import Store.authorization.repository.RepositoryRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RepositoryRole repositoryRole;

    @Override
    public void saveRoleInDB(RoleDTO role) {
        repositoryRole.save(new Role(role));
    }
}
