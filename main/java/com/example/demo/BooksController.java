package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
 @Autowired
BooksRepository br;
 @GetMapping(path="/books",produces={MediaType.APPLICATION_JSON_VALUE})
 public List<Books> getBooks(){
	return br.findAll();
 }
 
 @GetMapping(path="/books/{bookid}",produces={MediaType.APPLICATION_XML_VALUE})
 public Optional<Books> getBooksById(@PathVariable int bookid){
	return br.findById(bookid);
 }
 @PostMapping(path="/books",consumes={MediaType.APPLICATION_XML_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Books> saveBook(@RequestBody Books books)
	{
		br.save(books);
		return br.findAll();
	}
 @PutMapping(path="/books/{bookid}",produces={MediaType.APPLICATION_XML_VALUE})
 
 public Optional<Books> updateBooks(@PathVariable int bookid,@RequestBody Books books) {
	 br.save(books);
	 return br.findById(bookid);
 
 }
 @DeleteMapping("/books")
 public String deleteBooks() {
	 br.deleteAll();
	 return "All books are deleted";
 }

@DeleteMapping(path="/books/{bookid}",produces={MediaType.APPLICATION_JSON_VALUE})
public String deleteBooksById(@PathVariable int bookid) {
	
	br.deleteById(bookid);
	return "Book is deleted";
	
}
 
 
}
