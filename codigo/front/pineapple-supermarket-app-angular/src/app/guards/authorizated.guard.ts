import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
//services
import { StorageService } from '../services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorizatedGuard implements CanActivate {

  constructor(private _router:Router,
              private _storageService:StorageService){ }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) {
      if(this._storageService.isAuthenticated()){
        return true;
      }
      return false;
  }

}
