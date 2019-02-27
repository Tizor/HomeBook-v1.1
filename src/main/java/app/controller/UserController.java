package app.controller;


import app.dao.DAO;
import app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping ("/")
public class UserController {

    @Autowired
    private DAO dao;

    @GetMapping ("/ListPage")
    public String ListPage(Model model){
        model.addAttribute("ListOfUsers", dao.AllUsers());
        return "ListPage";
        }


        @GetMapping("/CreateUser")
    public ModelAndView AddUser(ModelAndView model) {
        User NewUser = new User();
      model.addObject("user",NewUser);
      model.setViewName("MakeUser");
        return model;
        }


    @PostMapping("/SaveUser")
    public ModelAndView SaveUser(@ModelAttribute User user){
        dao.AddUser(user);
        return new ModelAndView("redirect:/ListPage");
    }

    @GetMapping("/DeleteUser")
    public String DeleteUser(int id){
        dao.DeleteUser(id);
        return "redirect:/ListPage";
    }


  @GetMapping("/UpdateUser")
  public ModelAndView EditUser(@ModelAttribute ModelAndView model, int id) {
      User user = dao.GetId(id);
      model.setViewName("UpdateUser");
      model.addObject("user", user);
      return model;
  }

      @PostMapping("/SaveUpdateUser")
      public ModelAndView SaveUpdateUser(@ModelAttribute User user){
          dao.UpdateUser(user);
          return new ModelAndView("redirect:/ListPage");
      }

    }





