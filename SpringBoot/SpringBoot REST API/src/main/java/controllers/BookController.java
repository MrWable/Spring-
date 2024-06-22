package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Entities.Book;

//@Controller
//in case of RestApi we have to use RestController instead of Controller
@RestController
public class BookController {

	//@RequestMapping(value= "/books", method = RequestMethod.GET)
	/* @ResponseBody- it is print direct content after return */
	//GetMapping is used instead of RequestMapping no need to call get method
	
	@Autowired
	Private BookService bookservice;
	
	
	//get all book handler
//	@GetMapping("/books")
//	public List<Book> getBooks()
//	{
//		/*
//		 * Book book = new Book(); book.setId(12457); book.setTitle("Logic Is Magic");
//		 * book.setAuthor("Robert Vein");
//		 */
//		return this.BookService.getAllBooks();
//	}
	
	
	//code for ResponseEntity
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list=BookService.getAllBooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	//single book handler
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return BookService.getBookById(id);
	}
	
	
	//To create new Resource
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		this.BookService.addBook(book);
		return book;
	}
	
	
	// To delete resources
	
	@DeleteMapping("books/{bookId}")
	public Book deleteBook(@PathVariable("bookId") int bookId)
	{
		this.BookService.deleteBook(bookId);
		
	}
	
	//update book handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		this.BookService.updateBook(book,bookId);
		return book;
	}
	
}


