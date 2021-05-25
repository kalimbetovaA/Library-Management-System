

import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {SignInComponent} from './sign-in/sign-in.component';
import {ProfileComponent} from './profile/profile.component';
import {AuthGuardService} from './guard/auth-guard.service';
import {UserBooksComponent} from "./profile/user-books/user-books.component";
import { BookDetailsComponent } from './book-details/book-details.component';
import { BooksComponent } from './books/books.component';
import {AuthorComponent} from "./author/author.component";
import { CategoryComponent } from './category/category.component';

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'sign-in', component: SignInComponent},
  {path: 'books', component: BooksComponent,
    canActivate: [AuthGuardService]},
  {path: 'authors', component: AuthorComponent,
    canActivate: [AuthGuardService]},
  {path: 'book-details/:id', component: BookDetailsComponent,
    canActivate: [AuthGuardService]},
  {path: 'category/:id', component: CategoryComponent,
    canActivate: [AuthGuardService]},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'profile', component: ProfileComponent,
    canActivate: [AuthGuardService],
    canActivateChild: [AuthGuardService],
    children: [
      {path: 'userBooks', component: UserBooksComponent}
    ]}
];
