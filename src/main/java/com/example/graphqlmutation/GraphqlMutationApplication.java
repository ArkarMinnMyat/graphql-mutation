package com.example.graphqlmutation;

import com.example.graphqlmutation.entity.Book;
import com.example.graphqlmutation.entity.Review;
import com.example.graphqlmutation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlMutationApplication {

    private final BookRepository bookRepository;
    @Bean
    @Transactional
    @Profile("test")
    public ApplicationRunner runner(){
        return r -> {
            Book book1 = new Book("Reactive Spring",344,"Josh Long");
            Book book2 = new Book("The Stranger",200,"Albert Camus");
            Review review1 =new Review("Spring Book","Good to read...");
            Review review2 =new Review("Reactive Spring","Informative...");
            Review review3 =new Review("Novel","Fantastic...");
            Review review4 =new Review("Novel","Two thumb up...");

            book1.addReview(review1);
            book1.addReview(review2);
            book2.addReview(review3);
            book2.addReview(review4);

            bookRepository.save(book1);
            bookRepository.save(book2);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlMutationApplication.class, args);
    }

}
