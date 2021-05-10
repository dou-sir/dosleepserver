package com.jit.dyy.dosleepserver.util;



import com.jit.dyy.dosleepserver.bean.User;

import javax.servlet.http.HttpSession;

public class MyUtil {

    /**
     * 从session中获取用户ID
     *
     * @param session
     * @return
     */
    public static Integer getUserId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user==null){
            return 0;
        }
        return user.getUserId();
    }
}
