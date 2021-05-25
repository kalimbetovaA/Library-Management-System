import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../services/auth.service';
import {FormControl, FormGroup, NgForm} from '@angular/forms';
import {User} from '../user';
import {first} from 'rxjs/operators';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  @ViewChild('form') userForm!: NgForm;
  user!: User;

  constructor(private authService: AuthService, private router: Router, private activatedRouter: ActivatedRoute) { }


  onFormSubmit(): void {
    this.authService.isUserAuthenticated(this.user.username, this.user.password).pipe(first())
      .subscribe(
        (data: HttpResponse<any>) => {
          console.log(data.headers.get('authorization'));
        });

    if (this.authService.isUserLoggedIn()){
      this.router.navigate(['profile']);
    }
    else{
      console.log('error');
    }
    console.log(this.userForm.value);
  }

  ngOnInit(): void {
    this.user = new User( '', ''),

    setTimeout(() => {
      this.userForm.setValue(this.user);
    });

    this.activatedRouter.paramMap.subscribe(params => {
      console.log('activatedRouter.params: ', params);
    });
    this.activatedRouter.queryParamMap.subscribe(queryParams => {
      console.log('******query params: ', queryParams);
    });
  }

}
