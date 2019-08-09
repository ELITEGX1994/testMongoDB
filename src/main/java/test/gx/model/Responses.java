package test.gx.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName Responses
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 19:24
 * @Version 1.0
 */
@Getter
@Setter
public class Responses {
    private String response_user_id;
    private String response_user_phone;
    private String response_user_nickname;
    private String response_content;
    private Date create_time;
    private String[] get_reply;
}
