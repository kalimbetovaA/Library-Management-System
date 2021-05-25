import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  baseURL = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  getCategories(){
    return this.http.get<any>(this.baseURL + `/categories`);
  }

  getCategoryBooks(id: string | null){
    return this.http.get<any>(this.baseURL + `/categories/${id}/books`);
  }
}
