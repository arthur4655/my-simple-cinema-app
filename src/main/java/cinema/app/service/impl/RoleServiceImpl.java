package cinema.app.service.impl;

import cinema.app.dao.RoleDao;
import cinema.app.model.Role;
import cinema.app.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(Role.Type roleType) {
        return roleDao.getByName(roleType)
                .orElseThrow(() -> new RuntimeException("Can't find role with name "
                        + roleType.name()));
    }
}
