import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//Guards
import { AuthorizatedGuard } from './guards/authorizated.guard';
//Componentes
import { HomeComponent } from './components/home/home.component';
import { IndexComponent } from './components/index/index.component';
import { ProductosComponent } from './components/productos/productos.component';
import { UsuarioComponent } from './components/usuario/usuarios/usuario.component';
import { NuevoUsuarioComponent } from './components/usuario/nuevo-usuario/nuevo-usuario.component';
import { LoginComponent } from './components/auth/login/login.component';
import { EditaProductoComponent } from './components/edita-producto/edita-producto.component';
import { RecuperaPswComponent } from './components/recupera-psw/recupera-psw.component';
import { PerfilComponent } from './components/shared/perfil/perfil.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'index', component: IndexComponent, canActivate: [AuthorizatedGuard]},
  { path: 'productos', component: ProductosComponent, canActivate: [AuthorizatedGuard]},
  { path: 'usuarios', component: UsuarioComponent, canActivate: [AuthorizatedGuard]},
  { path: 'nuevo-usuario', component: NuevoUsuarioComponent, canActivate: [AuthorizatedGuard]},
  { path: 'editaProducto', component: EditaProductoComponent, canActivate: [AuthorizatedGuard]},
  { path: 'perfil', component: PerfilComponent, canActivate: [AuthorizatedGuard]},
  { path: 'recupera-psw', component:RecuperaPswComponent},
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
