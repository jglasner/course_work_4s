package edu.cw.cbr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.cw.cbr.controller.security.UserSession;
import edu.cw.cbr.domain.Sysuser;
import edu.cw.cbr.model.UserUtil;

/**
 * Provides methods that response on requests such as <tt>/</tt> and 
 * <tt>/signIn</tt> 
 * @author Dmitriy Gaydashenko
 *
 */
@Controller
public class StartpageController {
	
	/**
	 * sign in page address
	 */
	public static final String SIGN_IN = "/signIn";
	/**
	 * Processes <tt>/</tt> request. If current user session is valid redirects
	 * to @code {HOME_PAGE} else redirects to sign in page.
	 * @param httpSession - HTTP session. 
	 * (@see javax.servlet.http.HttpSession)
	 * @return view, which corresponds to request.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession httpSession) {
		if (UserSession.isHttpSessionValid(httpSession))
			return "redirect:" + PrecedentController.HOME_PAGE;
		return "redirect:/signIn";
	}
	
	/**
	 * Processes <tt>/signIn</tt> request. Returns view of <tt>/signIn</tt> 
	 * page;
	 * @return reference on view of <tt>/signIn</tt> page.
	 */
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		return "/signIn";
	}
	
	/**
	 * If user is valid creates new instance of {@code  UserSession} and adds 
	 * it, as attribute, to HTTP session and returns request to js on
	 * redirection to homepage. If user is invalid: is deleted, is not verified
	 * or does not exist, returns user's state.
	 * @param session - HTTP session
	 * @param email - user's email
	 * @param password - user's password
	 * @return user's state or redirection request.
	 */
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public @ResponseBody String signIn(HttpSession session, 
			@RequestParam String email, @RequestParam String password) {
		Sysuser user = UserUtil.getSysuser(email, password);
		UserUtil.UserState userState = UserUtil.getUserState(user);
		if (userState == UserUtil.UserState.IS_VALID) {
			session.setAttribute("userSession", 
					new UserSession(user));
			return "redirect:Home";// redirect via javascript.
		}
		return userState.name();
	}
}