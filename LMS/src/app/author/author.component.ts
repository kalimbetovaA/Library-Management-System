import { Component, OnInit } from '@angular/core';
import {BookService} from "../services/book.service";
import {AuthorService} from "../services/author.service";

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.scss']
})
export class AuthorComponent implements OnInit {

  authors: any;

  constructor(private authorService: AuthorService) { }

  ngOnInit(): void {
    this.authorService.getAuthors().subscribe(authors => {
      this.authors = authors; });;
  }

}
