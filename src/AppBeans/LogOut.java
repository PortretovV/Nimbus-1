package AppBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "logout")
@SessionScoped
public class LogOut {
    public void dropSession() throws IOException {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        try {
            request.logout();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        } catch (ServletException | IOException ex) {

        }

        //FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        //return "index";
    }
}
