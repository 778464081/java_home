package org.example;

import static org.junit.Assert.assertTrue;

import kuang.pojo.Books;
import kuang.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @Test
    public void selectbyName(){
        Books books = bookService.queryBookById(1);
        System.out.println(books);
    }
}
