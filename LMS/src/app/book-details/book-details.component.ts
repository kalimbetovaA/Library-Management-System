import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {

  book: any;

  constructor(private bookService: BookService, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {

    this.activatedRouter.paramMap.subscribe(params => {
      console.log('activatedRouter.params: ', params);
      this.bookService.getBook(params.get('id')).subscribe(book => {
        this.book = book; });
    });
  }

  onSubmit(id: string): void {
    this.bookService.borrowBook(id);
  }

  

}
