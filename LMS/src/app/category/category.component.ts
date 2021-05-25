import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  books: any;

  constructor(private categoryService: CategoryService, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {

    this.activatedRouter.paramMap.subscribe(params => {
      console.log('activatedRouter.params: ', params);
      this.categoryService.getCategoryBooks(params.get('id')).subscribe(books => {
        this.books = books; });
    });
  }


}
