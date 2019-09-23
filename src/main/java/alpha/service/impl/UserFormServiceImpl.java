package alpha.service.impl;

import alpha.model.UserForm;
import alpha.service.UserFormService;

public class UserFormServiceImpl implements UserFormService {

    @Override
    public boolean isPass(UserForm userForm) {
        if (userForm.getPassword().equals(userForm.getRePassword())) {
            return true;
        }
        return false;
    }
}
