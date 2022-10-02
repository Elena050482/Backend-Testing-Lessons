package org.example.builder;


import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.Products;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.api.ApiAddShoppingResponse;
import org.example.api.SpoonaccularService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        //SpoonaccularService spoonaccularService = new SpoonaccularService();
        //ApiAddShoppingResponse addItems = spoonaccularService.addShoppingList(
               // "1 bag oranges", "orange", true);
        //System.out.println(addItems);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            Products product = productsMapper.selectByPrimaryKey(1368L);
            System.out.println(product);
        }

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            Products product = productsMapper.deleteByPrimaryKey(1368L);
            System.out.println(product);
        }
=======
import org.example.api.ApiAddShoppingResponse;
import org.example.api.SpoonaccularService;

public class Main {
    public static void main(String[] args) {


        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiAddShoppingResponse addItems = spoonaccularService.addShoppingList(
                "1 bag oranges", "orange", true);
        System.out.println(addItems);


    }

}

