import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseURL = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  getUser(){
    return this.http.get<any>(this.baseURL + `/users/me`);
  }

  getUserBooks(){
    return this.http.get<any>(this.baseURL + `/users/me/books`);
  }

}
