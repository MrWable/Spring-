package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import Entities.Book;

@Component
public class BookService {

	/*
	 * // this service can be come from your database but we are not using database
	 * in this project // so we are creating now fakeservice.
	 */	
	
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(147,"Code on Self","Zen Cryscopy"));
		list.add(new Book(150,"Wings of Fire","Dr A P J Kalam"));
		list.add(new Book(158,"Be Discipline","R R  Hector"));
	}
	
	//get all books
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	//get single book
	public Book getBookById(int id)
	{
		Book book =null;
		
		book =list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//create new book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	
	//delete the book
	public void deleteBook(int bid)
	{
		list.stream().filter(book->{
			if(book.getId()!=bid)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}).collect(Collectors.toList());
	}
	
	//Update the book 
	public void updateBook(Book book,int bookId)
	{
		list=list.stream().map(b->{
			if(b.getId()==bookId)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				
			}
			return b;
		}).collect(Collectors.toList());
	}
}


