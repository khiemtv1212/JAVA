// package solekia.dvdrental.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import solekia.dvdrental.repository.CustomerCategory;
// import solekia.dvdrental.repository.CustomerFilm;
// import solekia.dvdrental.repository.StaffMapper;
// import solekia.dvdrental.repository.StaffModel;


// @Controller
// @RequestMapping("film")
// public class StaffController {
//     @Autowired
//     StaffMapper staffMapper;

//     @GetMapping("login")
//     public String list(Model model) {
//         // model.addAttribute("mess", "");
//         return "film/login";
//     }

//     @Autowired
//     CustomerFilm customerFilm;
//     @Autowired
//     CustomerCategory customerCategory;

//     @PostMapping("signin")
//     public String signin(@RequestParam("username") String username, @RequestParam("password") String password,
//             Model model) {
        
//         StaffModel pageS = new StaffModel();
//         pageS = staffMapper.findUserameOrEmail(username);
//         if (pageS == null) {
//             model.addAttribute("mess", "User Name is not correct");
//             return "film/login";
//         } else {
//             if (!pageS.password.equals(password)) {
//                 model.addAttribute("mess", "Password is not correct ");
//                 return "film/login";
//             } else {
//                 CustomerFilm page = new CustomerFilm();
//                 page.list = filmMapper.findAll();
//                 model.addAttribute("page", page);
//                 CategoryPageModel pageC = new CategoryPageModel();
//                 pageC.listC = categoryMapper.findAll();
//                 model.addAttribute("pageC", pageC);
//                 model.addAttribute("pageS", pageS);
//                 return "film/list"; // テンプレートファイルを指定
//             }
//         }
//     }

//      @GetMapping("register")
//     public String register(Model model) {
//         // model.addAttribute("mess", "");
//         return "film/register";
//     }
// }
