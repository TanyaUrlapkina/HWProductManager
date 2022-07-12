package ru.netology;

import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(20, "Скотный двор", 350, "Джордж Оруэлл");
    Book book2 = new Book(21, "1984", 500, "Джордж Оруэлл");
    Book book3 = new Book(23, "Да здравствует фикус!", 200, "Джордж Оруэлл");
    Smartphone phone1 = new Smartphone(121, "Iphone 10", 60_000, "Apple");
    Smartphone phone2 = new Smartphone(122, "Iphone 11", 80_000, "Apple");
    Smartphone phone3 = new Smartphone(123, "Iphone 12", 120_000, "Apple");
}

