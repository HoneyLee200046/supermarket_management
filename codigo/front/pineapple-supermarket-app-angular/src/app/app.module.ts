import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
//guards
import { ServerErrorInterceptor } from './guards/server-error.interceptor';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { IndexComponent } from './components/index/index.component';
import { ProductosComponent } from './components/productos/productos.component';
import { UsuarioComponent } from './components/usuario/usuarios/usuario.component';
import { NuevoUsuarioComponent } from './components/usuario/nuevo-usuario/nuevo-usuario.component';
import { LoginComponent } from './components/auth/login/login.component';
import { EditaProductoComponent } from './components/edita-producto/edita-producto.component';
import { RecuperaPswComponent } from './components/recupera-psw/recupera-psw.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    UsuariosComponent,
    FooterComponent,
    IndexComponent,
    ProductosComponent,
    UsuarioComponent,
    NuevoUsuarioComponent,
    LoginComponent,
    EditaProductoComponent,
    RecuperaPswComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: ServerErrorInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
