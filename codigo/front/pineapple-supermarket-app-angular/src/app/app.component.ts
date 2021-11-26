import { Component, OnInit } from '@angular/core';
declare function customInitFunction();
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
    customInitFunction();
  }
  title = 'pineapple-supermarket-app-angular';
}
