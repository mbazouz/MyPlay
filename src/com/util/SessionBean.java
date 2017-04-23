package com.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBean {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    /*public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }*/

    public static int getUtilisateurId() {
        HttpSession session = getSession();
        if (session != null) {
            return (int) session.getAttribute("userid");
        } else {
            return (0);
        }
    }
    
    
    public static int getGenreId() {
        HttpSession session = getSession();
        if (session != null) {
            return (int) session.getAttribute("genreid");
        } else {
            return (0);
        }
    }
}