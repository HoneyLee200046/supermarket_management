//librerias
import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpRequest, HttpHandler,
  HttpInterceptor, HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
//services
import { StorageService } from '../services/storage.service';

@Injectable()
export class ServerErrorInterceptor implements HttpInterceptor {

  constructor(private _storageService: StorageService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if(!request.url.includes("auth")){
      if (this._storageService.getCurrentToken()  && !this.tokenExpired(this._storageService.getCurrentToken())) {
        request = this.addToken(request, this._storageService.getCurrentToken());
      }else{
        console.log("El token expiró");
        this._storageService.logout();
      }
    }
    return next.handle(request);
  }

  private addToken(request: HttpRequest<any>, token: string) {
    return request.clone({
      setHeaders: {
        'Authorization': `Bearer ${token}`
      }
    });
  }

  private tokenExpired(token: string) {
    const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;
    return (Math.floor((new Date).getTime() / 1000)) >= expiry;
  }

}
