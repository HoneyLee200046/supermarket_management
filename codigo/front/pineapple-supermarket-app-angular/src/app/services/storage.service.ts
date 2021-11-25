import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
//model & interfaces
import { Usuariorespuesta } from '../model/helpers/usuariorespuesta';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  private localStorageService:any;
  private currentUserSession: any = null;
  private currentItemSession: any = null;

  constructor(private _router:Router) {
    this.localStorageService = localStorage;
    this.currentUserSession = this.loadSessionData();
  }

  loadSessionData(): Usuariorespuesta{
    var sessionStr = this.localStorageService.getItem('currentUser');
    return (sessionStr) ? <Usuariorespuesta> JSON.parse(sessionStr) : new Usuariorespuesta();
  }

  isAuthenticated(): boolean {
    return (this.getCurrentToken() != "") ? true : false;
  };

  getCurrentToken(): string {
    var session = this.getCurrentUserSession();
    return (session && session.token) ? session.token : "";
  };

  getCurrentUserSession(): Usuariorespuesta {
    return this.currentUserSession;
  }

  getCurrentAnyItemSession(item:string):any{
    return this.currentItemSession = this.loadAnySessionData(item);
  }

  setCurrentSession(session: Usuariorespuesta): void {
    this.currentUserSession = session;
    this.localStorageService.setItem('currentUser', JSON.stringify(session));
  }

  setAnyItemSession(item:string, session: any): void {
    this.currentItemSession = session;
    this.localStorageService.setItem(item, JSON.stringify(session));
  }

  removeCurrentSession(): void {
    this.localStorageService.clear();
    this.currentItemSession = null;
    this.currentUserSession = null;
  }

  removeAnyItemSession(item:string): void {
    this.localStorageService.removeItem(item);
  }

  loadAnySessionData(item:string){
    var sessionStr = this.localStorageService.getItem(item);
    return (sessionStr) ? <any> JSON.parse(sessionStr) : null;
  }

  logout(): void{
    this.removeCurrentSession();
    this._router.navigate(['home']);
    window.scrollTo(0, 0);
  }

}
