import { Component, OnInit } from '@angular/core';
import { StorageService } from '../../../services/storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public logueado:boolean = false;

  constructor(private _storageService: StorageService) { }

  ngOnInit(): void {
    this.revisarAuth();
  }

  revisarAuth(){
    this.logueado = this._storageService.isAuthenticated();
    console.log("logueado:" + this.logueado);

  }

  onLogout():void{
    this._storageService.logout();
    this.revisarAuth();
  }

}
