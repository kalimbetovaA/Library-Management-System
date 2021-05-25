import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  books: any;

  onSubmit(id: string): void {
    console.log(id);
    this.bookService.borrowBook(id);
  }
  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(books => {
      console.log(books);
      this.books = books; });;
  }

  onReturnSubmit(id: string): void {
    this.bookService.returnBook(id);
  }
}
