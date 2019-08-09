package test.gx.dao;

import test.gx.model.User;

public interface UserDao {
    public boolean saveUser(User user);
    public User findUser(String loginName,String passWord);
}
