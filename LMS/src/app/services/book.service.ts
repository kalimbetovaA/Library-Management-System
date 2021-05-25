import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseURL = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  getBooks(){
    return this.http.get<any>(this.baseURL + `/books`);
  }

  getBook(id: string | null){
    return this.http.get<any>(this.baseURL + `/books/${id}`);
  }

  borrowBook(id: string){
    return this.http.get<any>(this.baseURL + `/users/me/myborrow?bookId=${id}`).subscribe({
      next: data => {
        console.log(data);
      },
      error: error => {
        console.error('There was an error!', error);
      }
    });
  }

  returnBook(id: string){
    return this.http.get<any>(this.baseURL + `/users/me/return?bookId=${id}`).subscribe({
      next: data => {
        console.log(data);
      },
      error: error => {
        console.error('There was an error!', error);
      }
    });
  }
}
