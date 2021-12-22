package com.sda.patricban.bookstore;

import com.sda.patricban.bookstore.service.BookService;
import com.sda.patricban.bookstore.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class BookstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}







/*

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	@Autowired
	private MailService mailService;

	public static void main(String[] args) {SpringApplication.run(BookstoreApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		bookService.save("abcdef", "book1", "book1 description", new Date());
		bookService.save("ghijkl", "book2", "book2 description", new Date());
		bookService.save("kmnopq", "book3", "book3 description", new Date());
		bookService.save("rstuv", "book4", "book4 description", new Date());
		bookService.save("wxyz", "book5", "book5 description", new Date());

		bookService.findAll().forEach(book1 -> System.out.println(book1));

		System.out.println();
		System.out.println("_______________________________");
		System.out.println(bookService.findBookByIsbn("abcdef"));

		System.out.println();
		System.out.println("_______________________________");
		bookService.findAllByTitleIsLike("%oo%").stream().forEach(System.out::println);

		System.out.println();
		System.out.println("_______________________________");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String dateInString = "01-Dec-2021";
		Date date = formatter.parse(dateInString);
		bookService.findAllByReleaseDateBefore(date).stream().forEach(System.out::println);

			mailService.sendEmail("alin.patric.ban@gmail.com", "leontedarie1@gmail.com", "Test1", "Salut,Darie!");
	}
}
*/