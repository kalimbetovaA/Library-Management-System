import { Component, OnInit } from '@angular/core';
import {AuthService} from '../services/auth.service';
import {User} from '../user';
import {UserService} from "../services/user.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  user: any;

  constructor(private authService: AuthService,private router: Router, private userService: UserService ) { }

  ngOnInit(): void {
    this.userService.getUser().subscribe(user => {
      this.user = user; });

  }

  getUsername(): string {
    if (this.user === undefined){
      return '';
    }
    return this.user.username;
  }

  onSubmit(){
    this.authService.logOut();
    this.router.navigate(['sign-in']);
  }


}
