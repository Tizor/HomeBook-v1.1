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
    public String listPage(Model model){
        model.addAttribute("ListOfUsers", dao.AllUsers());
        return "ListPage";
        }


        @GetMapping("/CreateUser")
    public ModelAndView addUser(ModelAndView model) {
        User NewUser = new User();
      model.addObject("user",NewUser);
      model.setViewName("MakeUser");
        return model;
        }


    @PostMapping("/SaveUser")
    public ModelAndView saveUser(@ModelAttribute User user){
        dao.AddUser(user);
        return new ModelAndView("redirect:/ListPage");
    }

    @GetMapping("/DeleteUser")
    public String deleteUser(int id){
        dao.DeleteUser(id);
        return "redirect:/ListPage";
    }


  @GetMapping("/UpdateUser")
  public ModelAndView editUser(@ModelAttribute ModelAndView model, int id) {
      User user = dao.GetId(id);
      model.setViewName("UpdateUser");
      model.addObject("user", user);
      return model;
  }

      @PostMapping("/SaveUpdateUser")
      public ModelAndView saveUpdateUser(@ModelAttribute User user){
          dao.UpdateUser(user);
          return new ModelAndView("redirect:/ListPage");
      }

    }





