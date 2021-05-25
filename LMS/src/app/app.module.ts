import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {routes} from './app.route';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import {LoggingService} from './services/logging.service';
import {FormsModule} from '@angular/forms';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ProfileComponent } from './profile/profile.component';
import {AuthGuardService} from './guard/auth-guard.service';
import {AuthService} from './services/auth.service';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHeaders} from '@angular/common/http';
import {BasicAuthInterceptorService} from './services/basic-auth-interceptor.service';
import { UserBooksComponent } from './profile/user-books/user-books.component';
import { BooksComponent } from './books/books.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { AuthorComponent } from './author/author.component';
import { CategoryComponent } from './category/category.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SignUpComponent,
    SignInComponent,
    ProfileComponent,
    UserBooksComponent,
    BooksComponent,
    BookDetailsComponent,
    AuthorComponent,
    CategoryComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes, {useHash: true}),
    FormsModule,
    HttpClientModule
  ],
  providers: [LoggingService, AuthGuardService, AuthService,
    {provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
