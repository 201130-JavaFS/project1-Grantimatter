package com.revature.ers.servlet.util;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    static Logger log = Logger.getLogger(SessionUtil.class);

    public static boolean setupLoginSession(HttpSession session, User user){
        session.setAttribute("user_id", user.getId());
        session.setAttribute("user_role_id", user.getRole_id());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("user_first_name", user.getFirst_name());
        session.setAttribute("user_last_name", user.getLast_name());
        session.setAttribute("user_email", user.getEmail());
        if(getUserFromSession(session) != null){
            return true;
        }
        return false;
    }

    public static User getUserFromSession(HttpSession session) throws ErsException {
        try {
            int id = Integer.parseInt(session.getAttribute("user_id").toString());
            int role_id = Integer.parseInt(session.getAttribute("user_role_id").toString());
            String username = session.getAttribute("username").toString();
            String first_name = session.getAttribute("user_first_name").toString();
            String last_name = session.getAttribute("user_last_name").toString();
            String user_email = session.getAttribute("user_email").toString();
            User user = new User(id, role_id, username, first_name, last_name, user_email);
            log.info("Session User: " + user);

            if(user != null) {
                return user;
            }else{
                session.invalidate();
            }

        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
        }
        throw new ErsException("No user logged in");
    }
}
