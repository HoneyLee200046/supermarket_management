import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { IndexComponent } from './components/index/index.component';
import { ProductosComponent } from './components/productos/productos.component';
import { UsuarioComponent } from './components/usuario/usuarios/usuario.component';
import { NuevoUsuarioComponent } from './components/usuario/nuevo-usuario/nuevo-usuario.component';
import { LoginComponent } from './components/auth/login/login.component';
import { EditaProductoComponent } from './components/edita-producto/edita-producto.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'index', component: IndexComponent},
  { path: 'productos', component: ProductosComponent},
  { path: 'usuarios', component: UsuarioComponent},
  { path: 'nuevo-usuario', component: NuevoUsuarioComponent}, 
  { path: 'editaProducto', component: EditaProductoComponent},
  { path: '**', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    scrollPositionRestoration: 'enabled',
    anchorScrolling: 'enabled',
    useHash: true
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
