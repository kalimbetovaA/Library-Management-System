import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {User} from '../user';
import { AuthService } from '../services/auth.service';
import { HttpResponse } from '@angular/common/http';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  @ViewChild('form') userForm!: NgForm;
  user!: User;
  confirmPassword: string | undefined;

  constructor(private authService: AuthService, private router: Router, private activatedRouter: ActivatedRoute) { }


  onFormSubmit(): void {
    this.authService.register(this.user.username, this.user.password).pipe(first())
      .subscribe(
        (data: HttpResponse<any>) => {
          console.log(data.status);
          if (data.status==200){
            this.router.navigate(['sign-in']);
          }
        });
    console.log(this.userForm.value);
  }

  ngOnInit(): void {
    this.confirmPassword = '';
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
