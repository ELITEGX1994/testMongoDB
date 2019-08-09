package test.gx.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/1 21:31
 * @Version 1.0
 */
@Data
@Setter
@Getter
public class User {
    private String loginName;
    private String localName;
    private String userPassword;
    private String email;
}
