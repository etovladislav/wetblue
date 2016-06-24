package ru.arhat.wetblue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.arhat.wetblue.model.*;
import ru.arhat.wetblue.repository.*;
import ru.arhat.wetblue.util.Sender;
import ru.arhat.wetblue.util.UserInfo;

import java.util.List;

/**
 * Created by etovladislav on 21.06.16.
 */
@Controller
public class IndexController {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    SliderRepository sliderRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ParamRepository paramRepository;

    @Autowired
    PlusRepository plusRepository;

    @Autowired
    ProductionRepository productionRepository;

    @Autowired
    ReviewCategoryRepository reviewCategoryRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    CountryRepository countryRepository;


    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage(@RequestBody UserInfo userInfo) {
        Sender sender = new Sender();
        sender.send("Новая заявка wetblue.biz", "Имя " + userInfo.getName() + " \nНомер: " + userInfo.getPhone(), "pro.arhat@gmail.com");
    }

    @RequestMapping(value = "/sendMessageItem", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void feedbackItem(@RequestBody UserInfoItem userInfoItem) {
        Sender sender = new Sender();
        sender.send("Новая заявка wetblue.biz", "Имя " + userInfoItem.getName() + " \nНомер: " + userInfoItem.getPhone() + " \n " +
                " Товар: " + userInfoItem.getItem() + " \n Количество: " + userInfoItem.getNumber(), "pro.arhat@gmail.com");
    }

    @RequestMapping(value = {"/admin", "/"})
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = {"/login"})
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/checkAuth", method = RequestMethod.GET)
    @ResponseBody
    public Boolean saveCompany() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) {
            return false;
        }
        return true;
    }


    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    @ResponseBody
    public Company getCompany() {
        return companyRepository.findAll().get(0);
    }

    @RequestMapping(value = "/getSliders", method = RequestMethod.GET)
    @ResponseBody
    public List<Slider> getAllSlider() {
        return sliderRepository.findAll();
    }

    @RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/getAllPlus", method = RequestMethod.GET)
    @ResponseBody
    public List<Plus> getAllPlus() {
        return plusRepository.findAll();
    }

    @RequestMapping(value = "/getAllProduction", method = RequestMethod.GET)
    @ResponseBody
    public List<Production> getAllProduction() {
        return productionRepository.findAll();
    }

    @RequestMapping(value = "/getAllReviewCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<ReviewCategory> getAllReviewCategory() {
        return reviewCategoryRepository.findAll();
    }

    @RequestMapping(value = "/getAllDocument", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getAllDocument() {
        return documentRepository.findAll();
    }

    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

}
