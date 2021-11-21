import { Component, OnInit } from '@angular/core';
import { StorageService } from '../../../services/storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  constructor(private _storageService: StorageService) { }

  ngOnInit(): void {
  }
  onLogout():void{
    this._storageService.logout();
  }

}
