package test.gx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import test.gx.model.User;


/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/1 21:35
 * @Version 1.0
 */

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean saveUser(User user) {
        try{
            mongoTemplate.save(user);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public User findUser(String loginName, String passWord) {
        Query query=new Query();
        Criteria criteria=Criteria.where("loginName").is(loginName).and("userPassword").is(passWord);
        query.addCriteria(criteria);
        User user = (User) mongoTemplate.findOne(query , User.class);
        return user;
    }
}

