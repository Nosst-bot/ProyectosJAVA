import { Injectable, inject } from '@angular/core';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';
import {
  ActivatedRouteSnapshot,
  CanActivateFn,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RouteGuardService {
  constructor(
    private hcAuthService: HardcodedAuthenticationService,
    private router: Router
  ) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (this.hcAuthService.isUserLoggedIn()) return true;
    this.router.navigate(['login'])
    return false;
  }

  userLoggedGuard: CanActivateFn = (
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean => {
    return inject(RouteGuardService).canActivate(route, state);
  };
}
