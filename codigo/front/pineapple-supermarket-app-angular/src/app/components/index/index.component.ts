import jwt_decode from 'jwt-decode';
import { Component, OnInit } from '@angular/core';
//Models
import { Categoria } from '../../model/catalogos/categoria';
//services
import { StorageService } from '../../services/storage.service';


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  listaCategorias:Categoria[] = [];
  categoriaTmp:Categoria = new Categoria();
  public isAdminCard:boolean = false;
  public tokenCard:string = "";
  public perfilesCard:string[] = [];

  constructor(private _storageService: StorageService) { }

  ngOnInit(): void {
    this.tokenCard = this._storageService.getCurrentToken();
    let decoded: any = jwt_decode(this.tokenCard);
    this.perfilesCard = decoded.authorities;
    this.isAdminCard = this.perfilesCard.includes('admin');
  }

}
