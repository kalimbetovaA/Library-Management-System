import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-user-books',
  templateUrl: './user-books.component.html',
  styleUrls: ['./user-books.component.scss']
})
export class UserBooksComponent implements OnInit {

  userBooks: any;

  constructor(private userService: UserService, private bookService: BookService) { }

  ngOnInit(): void {
    this.userService.getUserBooks().subscribe(userBooks => {
      this.userBooks = userBooks; });;
  }

  onReturnSubmit(id: string): void {
    this.bookService.returnBook(id);
  }

}
