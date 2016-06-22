package ru.arhat.wetblue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.arhat.wetblue.model.*;
import ru.arhat.wetblue.repository.*;

import java.util.List;

/**
 * Created by etovladislav on 21.06.16.
 */
@RestController
@RequestMapping("/api")
public class AdminController {

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

    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public void saveCompany(@RequestBody Company company) {
        companyRepository.save(company);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public Company getCompany() {
        return companyRepository.findAll().get(0);
    }

    @RequestMapping(value = "/saveSlider", method = RequestMethod.POST)
    public void saveSlider(@RequestBody Slider slider) {
        sliderRepository.save(slider);
    }

    @RequestMapping(value = "/getSliders", method = RequestMethod.GET)
    public List<Slider> getAllSlider() {
        return sliderRepository.findAll();
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public void saveCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }


    @RequestMapping(value = "/getCleanCategory", method = RequestMethod.POST)
    public Category getCleanCategory() {
        Category category = new Category();
        category.setName("New category");
        categoryRepository.save(category);
        return category;
    }

    @RequestMapping(value = "/getCleanItem/{id}", method = RequestMethod.GET)
    public Item getCleanItem(@PathVariable("id") Long id) {
        Category category = categoryRepository.findOne(id);
        Item item = new Item();
        item.setName("new");
        category.addItem(item);
        itemRepository.save(item);
        categoryRepository.save(category);
        return item;
    }

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public void saveItem(@RequestBody Item item) {
        itemRepository.save(item);
    }

    @RequestMapping(value = "/cleanParam/{id}", method = RequestMethod.GET)
    public Param getCleanParam(@PathVariable("id") Long id) {
        Param param = new Param();
        param.setName("New param");
        Item item = itemRepository.findOne(id);
        item.addParam(param);
        paramRepository.save(param);
        itemRepository.save(item);
        return param;
    }

    @RequestMapping(value = "/saveParam", method = RequestMethod.POST)
    public void saveParam(@RequestBody Param param) {
        paramRepository.save(param);
    }

    @RequestMapping(value = "/getAllPlus", method = RequestMethod.GET)
    public List<Plus> getAllPlus() {
        return plusRepository.findAll();
    }

    @RequestMapping(value = "/getCleanPlus", method = RequestMethod.GET)
    public Plus getCleanPlus() {
        Plus plus = new Plus();
        plus.setDescription("asd");
        plusRepository.save(plus);
        return plus;
    }

    @RequestMapping(value = "/savePlus", method = RequestMethod.POST)
    public void savePlus(@RequestBody Plus plus) {
        plusRepository.save(plus);
    }

    @RequestMapping(value = "/getAllProduction", method = RequestMethod.GET)
    public List<Production> getAllProduction() {
        return productionRepository.findAll();
    }

    @RequestMapping(value = "/getCleanProduction", method = RequestMethod.GET)
    public Production getCleanProduction() {
        Production production = new Production();
        production.setName("sad");
        productionRepository.save(production);
        return production;
    }

    @RequestMapping(value = "/saveProduction", method = RequestMethod.POST)
    public void saveProduction(@RequestBody Production production) {
        productionRepository.save(production);
    }


    @RequestMapping(value = "/saveReviewCategory", method = RequestMethod.POST)
    public void saveReviewCategory(@RequestBody ReviewCategory reviewCategory) {
        reviewCategoryRepository.save(reviewCategory);
    }

    @RequestMapping(value = "/getAllReviewCategory", method = RequestMethod.GET)
    public List<ReviewCategory> getAllReviewCategory() {
        return reviewCategoryRepository.findAll();
    }


    @RequestMapping(value = "/getCleanReviewCategory", method = RequestMethod.POST)
    public ReviewCategory getCleanReviewCategory() {
        ReviewCategory reviewCategory = new ReviewCategory();
        reviewCategory.setName("asdasd");
        reviewCategoryRepository.save(reviewCategory);
        return reviewCategory;
    }


    @RequestMapping(value = "/cleanReview/{id}", method = RequestMethod.GET)
    public Review getCleanReview(@PathVariable("id") Long id) {
        Review review = new Review();
        review.setDescription("asdasd");
        ReviewCategory reviewCategory = reviewCategoryRepository.findOne(id);
        reviewRepository.save(review);
        reviewCategory.getReview().add(review);
        reviewCategoryRepository.save(reviewCategory);
        return review;
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public void saveParam(@RequestBody Review review) {
        reviewRepository.save(review);
    }


    @RequestMapping(value = "/getAllDocument", method = RequestMethod.GET)
    public List<Document> getAllDocument() {
        return documentRepository.findAll();
    }

    @RequestMapping(value = "/getCleanDocument", method = RequestMethod.GET)
    public Document getCleanDocument() {
        Document document = new Document();
        document.setName("");
        documentRepository.save(document);
        return document;
    }

    @RequestMapping(value = "/saveDocument", method = RequestMethod.POST)
    public void saveDocument(@RequestBody Document document) {
        documentRepository.save(document);
    }


    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @RequestMapping(value = "/getCleanCountry", method = RequestMethod.GET)
    public Country getCleanCountry() {
        Country country = new Country();
        country.setDescription("asdasdasdasdasd");
        country.setCity("asdasdasdasdasd");
        countryRepository.save(country);
        return country;
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public void saveCountry(@RequestBody Country country) {
        countryRepository.save(country);
    }
}
