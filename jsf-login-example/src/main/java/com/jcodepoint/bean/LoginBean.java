package com.jcodepoint.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.jcodepoint.model.User;
import com.jcodepoint.service.LoginService;

@Named("loginBean")
@RequestScoped
public class LoginBean {

	@Inject
	private LoginService service;
	
	private String nombreUsuario;
	private String contrasena;

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String login() {
		System.out.println("LoginBean.login()");
		User user = this.service.getUser(this.nombreUsuario);

		if (user != null && user.getPassword().equals(this.contrasena)) {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("user", user);
			return "success";
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales no válidas", "Credenciales no válidas");			
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
	}

	public String logoff() {
		System.out.println("LoginBean.logoff()");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.removeAttribute("user");
		return "success";
	}

}
