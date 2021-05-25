import { Injectable } from '@angular/core';
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivateChild} from '@angular/router';
import {AuthService} from '../services/auth.service';

@Injectable()
export class AuthGuardService implements CanActivate, CanActivateChild {

  constructor(private router: Router,
              private authService: AuthService) {}

  canActivate(route: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): boolean {

    console.log('we are in canActivate method!');

    if (this.authService.isUserLoggedIn()) {
      return true;
    }
    this.router.navigate([ this.authService.getLoginUrl() ]);
    return false;
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    console.log('we are in canActivateChild method!');
    return this.canActivate(childRoute, state);
  }
}
