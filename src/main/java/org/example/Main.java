package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.repository")
@EntityScan(basePackages = "org.example.entity")
@Slf4j
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    @Autowired
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Product product = new Product();
        product.setCode("product_code");
        product.setName("product_name");

        productRepository.save(product);

        log.info("Product {}", productRepository.findById(1L));
    }
}