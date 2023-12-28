package com.rean.blogrest.utilities;

import com.rean.blogrest.model.*;
import com.rean.blogrest.repository.*;
import com.rean.blogrest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.metrics.StartupStep;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setName("Reda");
        user.setEmail("reda@gmail.com");
        user.setPassword(passwordEncoder.encode("pass123"));
        user.setRole(UserRole.USER);
        userRepository.save(user);

        Category category1 = new Category(0,"Food",null,null);
        Category category2= new Category(0,"Travel",null,null);
        Category category3 = new Category(0,"Health",null,null);
        Category category4 = new Category(0,"Fashion and Beauty",null,null);
        Category category5 = new Category(0,"Photography",null,null);
        Category category6 = new Category(0,"Music",null,null);


        Tag tag1 = new Tag(0L,"#FoodieFinds",null);
        Tag tag2 = new Tag(0L,"#FitnessFiesta",null);
        Tag tag3 = new Tag(0L,"#TravelInspiration",null);



        List<Category> article1Categories = new ArrayList<>();
        article1Categories.add(category1);
        article1Categories.add(category3);

        List<Category> article2Categories = new ArrayList<>();
        article2Categories.add(category6);
        article2Categories.add(category5);

        List<Category> article3Categories = new ArrayList<>();
        article3Categories.add(category4);
        article3Categories.add(category3);

        List<Tag> article1Tags = new ArrayList<>();
        article1Tags.add(tag1);
        List<Tag> article2Tags = new ArrayList<>();
        article2Tags.add(tag3);
        List<Tag> article3Tags = new ArrayList<>();
        article3Tags.add(tag2);

        tagRepository.saveAll(List.of(tag1,tag2,tag3));
        categoryRepository.saveAll(List.of(category1,category2,category3,category4,category5,category6));

        Article article1 = new Article();
        article1.setTitle("Article1");
        article1.setContent("Lorem ipsum dolor sit amet. Quo adipisci iure ex quis illo et voluptate dolor non molestias quaerat. Aut voluptatem nihil eum possimus facere est animi quis qui ipsum labore. Est voluptas magnam sit similique adipisci et optio exercitationem qui consequatur perferendis aut libero reiciendis in quia quisquam. Aut illum consequatur et delectus voluptas ut voluptatem quisquam et facilis ipsum 33 impedit error et voluptatem laboriosam.");
        article1.setPublication_date(LocalDateTime.now());
        article1.setCategories(article1Categories);
        article1.setTags(article1Tags);
        article1.setUser(user);
        articleRepository.save(article1);

        Article article2 = new Article();
        article2.setTitle("Article2");

        article2.setContent("Lorem ipsum dolor sit amet. Quo adipisci iure ex quis illo et voluptate dolor non molestias quaerat. Aut voluptatem nihil eum possimus facere est animi quis qui ipsum labore. Est voluptas magnam sit similique adipisci et optio exercitationem qui consequatur perferendis aut libero reiciendis in quia quisquam. Aut illum consequatur et delectus voluptas ut voluptatem quisquam et facilis ipsum 33 impedit error et voluptatem laboriosam.");
        article2.setPublication_date(LocalDateTime.now());
        article2.setCategories(article2Categories);
        article2.setTags(article2Tags);
        article2.setUser(user);
        articleRepository.save(article2);

        Article article3 = new Article();
        article3.setTitle("Article3");
        article3.setContent("Lorem ipsum dolor sit amet. Quo adipisci iure ex quis illo et voluptate dolor non molestias quaerat. Aut voluptatem nihil eum possimus facere est animi quis qui ipsum labore. Est voluptas magnam sit similique adipisci et optio exercitationem qui consequatur perferendis aut libero reiciendis in quia quisquam. Aut illum consequatur et delectus voluptas ut voluptatem quisquam et facilis ipsum 33 impedit error et voluptatem laboriosam.");
        article3.setPublication_date(LocalDateTime.now());
        article3.setCategories(article3Categories);
        article3.setTags(article3Tags);
        article3.setUser(user);
        articleRepository.save(article3);

        Comment comment1 = new Comment(0L,"Quo adipisci iure ex quis illo et voluptate dolor non molestias quaerat.",LocalDateTime.now(),article1);
        Comment comment2 = new Comment(0L,"Quo adipisci iure ex quis illo et voluptate dolor non molestias quaerat.",LocalDateTime.now(),article2);
        Comment comment3 = new Comment(0L,"Quo adipisci iure ex quis illo et voluptate dolor non molestias quaerat.",LocalDateTime.now(),article3);

        commentRepository.saveAll(List.of(comment1,comment2,comment3));

    }
}
