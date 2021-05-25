import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  baseURL = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  getAuthors(){
    return this.http.get<any>(this.baseURL + `/authors`);
  }
}
