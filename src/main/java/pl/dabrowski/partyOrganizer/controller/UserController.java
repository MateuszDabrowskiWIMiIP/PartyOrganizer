package pl.dabrowski.partyOrganizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dabrowski.partyOrganizer.model.Party;
import pl.dabrowski.partyOrganizer.model.User;
import pl.dabrowski.partyOrganizer.service.PartyService;
import pl.dabrowski.partyOrganizer.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PartyService partyService;

    @RequestMapping(value= {"/", "/login"}, method= RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method= RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");

        return model;
    }

    @RequestMapping(value= {"/signup"}, method= RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("user/signup");
        }

        return model;
    }

    @RequestMapping(value= {"/home/home"}, method= RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        List<Party> listParties = partyService.listAll();

        model.addObject("listParties", listParties);


        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value= {"/access_denied"}, method= RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }


    @RequestMapping(value = {"/newParty"}, method= RequestMethod.GET)
    public String showNewPartyPage(Model model) {
        Party party = new Party();
        model.addAttribute("party", party);

        return "new_party";
    }


    @RequestMapping(value = "/saveParty", method = RequestMethod.POST)
    public String saveParty(@ModelAttribute("party") Party party) {

        partyService.save(party);

        return "index";

    }

    @RequestMapping(value = {"/editParty/{id}"}, method= RequestMethod.GET )
    public ModelAndView showEditPartiesPage(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("edit_party");
        Party party = partyService.get(id);
        mav.addObject("party", party);

        System.out.println("Dane ");
        return mav;
    }

    @RequestMapping(value = "/deleteParty/{id}",  method= RequestMethod.GET)
    public String deleteParty(@PathVariable(name="id") Long id) {
        partyService.delete(id);
        return "index";
    }
}