package Store.authorization.model;

import Store.authorization.dto.dtoController.RoleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(schema = "per")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleUser;

    public Role(RoleDTO roleDTO) {
        this.roleUser = roleDTO.roleUser();
    }

    @Override
    public String getAuthority() {
        return roleUser;
    }
}
