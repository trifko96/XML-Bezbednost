import { Injectable } from '@angular/core';
import { CanActivate, CanLoad, Router } from '@angular/router';
import { authService } from '../service/authService';

@Injectable({
  providedIn: 'root'
})
export class RandomGuard implements CanActivate, CanLoad {

  constructor(private authService: authService, private router: Router) { }

  canActivate() {
    return this.canLoad();
  }

  canLoad() {
    if (!this.authService.isLogged()) {
      this.router.navigate(['/login']);
    }
    return this.authService.isLogged();
  }
}