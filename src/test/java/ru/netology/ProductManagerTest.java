package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(20, "Скотный двор", 350, "Джордж Оруэлл");
    Book book2 = new Book(21, "1984", 500, "Джордж Оруэлл");
    Book book3 = new Book(23, "Да здравствует фикус!", 200, "Джордж Оруэлл");
    Smartphone phone1 = new Smartphone(121, "Iphone 10", 60_000, "Apple");
    Smartphone phone2 = new Smartphone(122, "Iphone 11", 80_000, "Apple");
    Smartphone phone3 = new Smartphone(123, "Iphone 12", 120_000, "Apple");

    @Test
    void addProducts() {
        manager.add(book1);
        manager.add(book2);
        repository.save(phone1);
        repository.save(phone2);
        manager.add(phone3);
        Product[] expected = {book1, book2, phone1, phone2, phone3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        Product expected = book3;
        Product actual = manager.findById(23);
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        manager.removeById(20);
        manager.removeById(121);
        Product[] expected = {book2, book3, phone2, phone3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        Product[] expected = {book1, book2, book3, phone1, phone2, phone3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByNameBook() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Да здравствует фикус!");
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById2() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.removeById(123);
        Product[] expected = {book1, book2, book3, phone1, phone2};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByName() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Iphone 11");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findBookOutOfList() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        Product[] expected = {};
        Product[] actual = manager.searchBy("book8");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByUnCorrectId() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        Product actual = manager.findById(18);
        assertNull(actual);
    }

    @Test
    void findAllSmartphones() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = manager.searchBy("phone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByIdPhone() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        Product expected = phone3;
        Product actual = repository.findById(123);
        assertEquals(expected, actual);
    }
}