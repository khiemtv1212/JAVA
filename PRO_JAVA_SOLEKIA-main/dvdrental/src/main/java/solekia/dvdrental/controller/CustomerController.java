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

import solekia.dvdrental.model.CustomerPageModel;
import solekia.dvdrental.repository.CustomerMapper;

/**
 * CustomerController
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    /**
     * Customerテーブルのアクセス用クラスを追加
     */
    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("list")
    public String list(Model model) {
        // ページクラスをNewしてタイトルをリセット
        CustomerPageModel page = new CustomerPageModel();
        // page.title = "顧客一覧画面(JAVA)";
        page.list = customerMapper.findAll();

        // リストを初期化
        // page.list = new ArrayList<>();

        // // ユーザーの情報を設定
        // CustomerModel user1 = new CustomerModel();
        // user1.customer_id = 1;
        // user1.first_name = "Java";
        // user1.last_name = "太郎";
        // user1.email = "taro@java.com";
        // page.list.add(user1);

        // CustomerModel user2 = new CustomerModel();
        // user2.customer_id = 2;
        // user2.first_name = "Java";
        // user2.last_name = "次郎";
        // user2.email = "jiro@java.com";
        // page.list.add(user2);

        model.addAttribute("page", page);
        return "customer/list";
    }

    @PostMapping("search")
    public String search(@RequestParam("name") String name, Model model) {
        CustomerPageModel page = new CustomerPageModel();
        page.list = customerMapper.findName("%" + name + "%");
        model.addAttribute("page", page);
        model.addAttribute("seachval", name);
        return "customer/list";
    }

    @Transactional
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        CustomerPageModel page = new CustomerPageModel();
        customerMapper.delete(id);
        page.list = customerMapper.findAll();
        model.addAttribute("page", page);
        return "customer/list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        CustomerPageModel page = new CustomerPageModel();
        var customer = customerMapper.findById(id);
        page.customer_id = customer.customer_id;
        page.first_name = customer.first_name;
        page.last_name = customer.last_name;
        page.email = customer.email;
        model.addAttribute("page", page);
        return "customer/edit";
    }

    @PostMapping("update")
    public String edit(@ModelAttribute CustomerPageModel page, Model model)
            throws ParseException {
        // page.title = "顧客一覧画面(JAVA)";
        customerMapper.update(page.customer_id, page.first_name, page.last_name,
                page.email);
        page.list = customerMapper.findAll();
        model.addAttribute("page", page);
        return "customer/list";
    }
    // @GetMapping("regist")
    // public String regist(Model model){
    // page.title = "顧客登録画面";
    // model.addAttribute("page",page);

    // return "customer/regist"; //テンプレートファイルを指定

    // }

    // @PostMapping("regist")
    // public String regist(@RequestParam("first_name") String first_name ,
    // @RequestParam("last_name") String last_name ,
    // @RequestParam("email") String email ,
    // Model model)
    // {
    // page.title = "顧客登録画面";

    // customerMapper.registUser(first_name , last_name , email);

    // // 全件検索
    // page.list = customerMapper.findAll();

    // // HTMLに検索結果を返す
    // model.addAttribute("page",page);

    // return "customer/list"; //テンプレートファイルを指定

    // }
}