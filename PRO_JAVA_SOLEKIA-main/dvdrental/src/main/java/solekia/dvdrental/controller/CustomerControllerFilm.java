package solekia.dvdrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import solekia.dvdrental.model.CustomerPageCategory;
import solekia.dvdrental.model.CustomerPageFilm;
import solekia.dvdrental.repository.CustomerMapperCategory;
import solekia.dvdrental.repository.CustomerMapperFilm;

@Controller
@RequestMapping("film")
public class CustomerControllerFilm {
    @Autowired
    CustomerMapperFilm customerMapperFilm;
    @Autowired
    CustomerMapperCategory customerMapperCategory;

    @GetMapping("home")
    public String list(Model model) {
        CustomerPageFilm film = new CustomerPageFilm();
        CustomerPageCategory category = new CustomerPageCategory();
        film.list = customerMapperFilm.findAll();
        category.list = customerMapperCategory.findAll();
        model.addAttribute("page", film);
        model.addAttribute("pageC", category);
        return "film/home";
    }

    // @GetMapping("homeS")
    // public String listS(Model model) {
    // CustomerPageFilm film = new CustomerPageFilm();
    // // CustomerPageCategory category = new CustomerPageCategory();
    // film.list = customerMapperFilm.findAll();
    // // category.list = customerMapperCategory.findAll();
    // model.addAttribute("pageS", film);
    // // model.addAttribute("pageC", category);
    // return "film/search";
    // }

    @PostMapping("search")
    public String search(@RequestParam("name") String name, Model model) {
        CustomerPageFilm film = new CustomerPageFilm();
        CustomerPageCategory category = new CustomerPageCategory();
        film.list = customerMapperFilm.findName("%" + name + "%");
        category.list = customerMapperCategory.findAll();
        model.addAttribute("page", film);
        model.addAttribute("seachval", name);
        model.addAttribute("pageC", category);
        return "film/home";
    }

    @GetMapping("/")
    public String getLimitedFilms(@RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "8") int pageSize,
            Model model) {
        CustomerPageFilm ct = new CustomerPageFilm();
        CustomerPageCategory category = new CustomerPageCategory();
        ct.list = customerMapperFilm.getFilmsWithPagination(pageNumber, pageSize);
        category.list = customerMapperCategory.findAll();
        int totalFilms = customerMapperFilm.getTotalFilms();
        int totalPages = (int) Math.ceil((double) totalFilms / pageSize);
        System.out.println("aaaaa" + pageNumber +
                "aaaaaa" + totalPages + "aaaaa" + pageSize);
        model.addAttribute("page", ct);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageC", category);
        return "film/home";
    }

    @Transactional
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        CustomerPageFilm film = new CustomerPageFilm();
        customerMapperFilm.delete(id);
        film.list = customerMapperFilm.findAll();
        model.addAttribute("page", film);
        return "film/home";
    }

    // update
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        CustomerPageFilm film = new CustomerPageFilm();
        var customer = customerMapperFilm.findById(id);
        film.film_id = customer.film_id;
        film.title = customer.title;
        film.description = customer.description;
        film.replacement_cost = customer.replacement_cost;
        model.addAttribute("pageEdit", film);
        return "film/editFilm";
    }

    @PostMapping("update")
    public String edit(@ModelAttribute CustomerPageFilm page, Model model)
            throws ParseException {
        customerMapperFilm.updateFilm(page.film_id, page.title, page.description,
                page.replacement_cost);
        page.list = customerMapperFilm.findAll();
        model.addAttribute("pageEdit", page);
        return "film/home";
    }
}
