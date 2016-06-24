package ru.arhat.wetblue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.arhat.wetblue.model.*;
import ru.arhat.wetblue.repository.*;

import java.util.ArrayList;
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

    @RequestMapping(value = "/saveSlider", method = RequestMethod.POST)
    public void saveSlider(@RequestBody Slider slider) {
        sliderRepository.save(slider);
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public void saveCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @RequestMapping(value = "/getCleanCategory", method = RequestMethod.POST)
    public Category getCleanCategory() {
        Category category = new Category();
        category.setName("New category");
        category.setItems(new ArrayList<>());
        categoryRepository.save(category);
        return category;
    }

    @RequestMapping(value = "/getCleanItem/{id}", method = RequestMethod.GET)
    public Item getCleanItem(@PathVariable("id") Long id) {
        Category category = categoryRepository.findOne(id);
        Item item = new Item();
        item.setName("Название товара");
        item.setPrice("Цена");
        item.setImg("/img/w1.jpg");
        item.setParams(new ArrayList<>());
        item = itemRepository.save(item);
        category.getItems().add(item);
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
        param.setName("Парамет");
        param.setValue("Значение");
        Item item = itemRepository.findOne(id);
        param = paramRepository.save(param);
        item.getParams().add(param);
        itemRepository.save(item);
        return param;
    }

    @RequestMapping(value = "/saveParam", method = RequestMethod.POST)
    public void saveParam(@RequestBody Param param) {
        paramRepository.save(param);
    }

    @RequestMapping(value = "/getCleanPlus", method = RequestMethod.GET)
    public Plus getCleanPlus() {
        Plus plus = new Plus();
        plus.setDescription("Описание");
        plus.setImg("/img/opyt/1.jpg");
        plusRepository.save(plus);
        return plus;
    }

    @RequestMapping(value = "/savePlus", method = RequestMethod.POST)
    public void savePlus(@RequestBody Plus plus) {
        plusRepository.save(plus);
    }

    @RequestMapping(value = "/getCleanProduction", method = RequestMethod.GET)
    public Production getCleanProduction() {
        Production production = new Production();
        production.setName("Описание поизводства");
        production.setImg("/img/p2.jpg");
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


    @RequestMapping(value = "/getCleanReviewCategory", method = RequestMethod.POST)
    public ReviewCategory getCleanReviewCategory() {
        ReviewCategory reviewCategory = new ReviewCategory();
        reviewCategory.setName("Категория отзывов");
        reviewCategory.setReview(new ArrayList<>());
        reviewCategoryRepository.save(reviewCategory);
        return reviewCategory;
    }


    @RequestMapping(value = "/cleanReview/{id}", method = RequestMethod.GET)
    public Review getCleanReview(@PathVariable("id") Long id) {
        Review review = new Review();
        review.setDescription("Описание");
        review.setThumbImg("/img/thank/2.jpg");
        review.setFullImg("/img/thank2/3.jpg");
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


    @RequestMapping(value = "/getCleanDocument", method = RequestMethod.GET)
    public Document getCleanDocument() {
        Document document = new Document();
        document.setName("Имя документа");
        documentRepository.save(document);
        return document;
    }

    @RequestMapping(value = "/saveDocument", method = RequestMethod.POST)
    public void saveDocument(@RequestBody Document document) {
        documentRepository.save(document);
    }


    @RequestMapping(value = "/getCleanCountry", method = RequestMethod.GET)
    public Country getCleanCountry() {
        Country country = new Country();
        country.setDescription("Опимание доставки");
        country.setCity("Город дотавки");
        country.setName("Страна");
        country.setImg("/img/flags/3.png");
        countryRepository.save(country);
        return country;
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public void saveCountry(@RequestBody Country country) {
        countryRepository.save(country);
    }


    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public void deleteCatagory(@RequestBody Category category) {
        categoryRepository.delete(category);
    }

    @RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
    public void deleteItem(@RequestBody Item item) {
        itemRepository.removRelationshipByItemId(item.getId());
        itemRepository.delete(item);
    }

    @RequestMapping(value = "/deleteParam", method = RequestMethod.POST)
    public void deleteParam(@RequestBody Param param) {
        paramRepository.removRelationshipByParamId(param.getId());
        paramRepository.delete(param);
    }

    @RequestMapping(value = "/deletePlus", method = RequestMethod.POST)
    public void deletePlus(@RequestBody Plus plus) {
        plusRepository.delete(plus);
    }


    @RequestMapping(value = "/deleteReviewCategory", method = RequestMethod.POST)
    public void deleteCategory(@RequestBody ReviewCategory reviewCategory) {
        reviewCategoryRepository.delete(reviewCategory);
    }

    @RequestMapping(value = "/deleteReview", method = RequestMethod.POST)
    public void deleteReview(@RequestBody Review review) {
        reviewRepository.removRelationshipByReviewId(review.getId());
        reviewRepository.delete(review);
    }

    @RequestMapping(value = "/deleteProduction", method = RequestMethod.POST)
    public void deleteProduction(@RequestBody Production production) {
        productionRepository.delete(production);
    }


    @RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
    public void deleteCountry(@RequestBody Country country) {
        countryRepository.delete(country);
    }


    @RequestMapping(value = "/deleteDocument", method = RequestMethod.POST)
    public void deleteDocument(@RequestBody Document document) {
        documentRepository.delete(document);
    }
}
