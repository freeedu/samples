package org.personal.mason;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.personal.mason.domain.SystemUser;
import org.personal.mason.utils.DataHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "user/list", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemUser> getAllUsers() {
		return DataHolder.getInstance().getUsers();
	}

	@RequestMapping(value = "user/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@RequestParam("id") int id) {
		DataHolder.getInstance().deleteUser(id);
	}

	@RequestMapping(value = "user/find", method = RequestMethod.GET)
	@ResponseBody
	public SystemUser findUser(@RequestParam("id") int id) {
		return DataHolder.getInstance().findUser(id);
	}

	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	@ResponseBody
	public SystemUser addUser(@RequestBody SystemUser user) {
		return DataHolder.getInstance().addUser(user);
	}

}
