package ua.com.hedgehogsoft.khwarizmi.bean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "logoutBean")
@RequestScoped
public class LogoutBean
{
   private static Logger log = Logger.getLogger(LogoutBean.class.getName());

   public String logout()
   {
      String destination = "/users/index?faces-redirect=true";
      FacesContext context = FacesContext.getCurrentInstance();
      HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
      try
      {
         String user = request.getRemoteUser();
         log.log(Level.INFO, "User [" + user + "] will be logout");
         HttpSession session = request.getSession();
         session.invalidate();
         request.logout();
         log.log(Level.INFO, "User [" + user + "] was logout");
      }
      catch (ServletException e)
      {
         log.log(Level.SEVERE, "Failed to logout user!", e);
         destination = "/loginerror?faces-redirect=true";
      }

      return destination;
   }
}
