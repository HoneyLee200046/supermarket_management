import Swal from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
//services
import { SeguridadService } from '../../services/seguridad.service';

@Component({
  selector: 'app-recupera-psw',
  templateUrl: './recupera-psw.component.html',
  styleUrls: ['./recupera-psw.component.css']
})
export class RecuperaPswComponent implements OnInit {

  public formPwdSubmitted = false;
  public recPwdForm = this.fb.group({
    mailUser: ['', Validators.required],
  });

  constructor(private fb: FormBuilder,
              private _seguridadService:SeguridadService) { }

  ngOnInit(): void {
  }

  recuperar(){
    this.formPwdSubmitted = true;
    if(this.recPwdForm.valid){
      const { mailUser } = this.recPwdForm.value;
      let correo = mailUser;
      this._seguridadService.getPassword(correo)
      .subscribe((data:any)=>{
        console.log("data");
        console.log(data);
        if (data.mensaje === 'success') {
          Swal.fire({
            title: 'Atención!',
            icon: 'success',
            html:'<p>Su nueva contraseña es: '+ data.pwd +'</p>',
            confirmButtonText: 'Entendido'
          })
        }else if(data.mensaje === 'error') {
          Swal.fire({
            title: 'Error!',
            text: data.detalle,
            icon: 'error',
            showCancelButton: false,
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'Intentar nuevamente'
          }).then((result) => {
            if (result.isConfirmed) {
              this.recPwdForm.reset();
              this.formPwdSubmitted = false;
            }
          });
        }else{
          Swal.fire({
            title: 'Error!',
            text: 'Ocurrió un error desconocido, favor de comunicar al administrador.',
            icon: 'error',
            confirmButtonText: 'Entendido'
          })
        }
      });
    }
  }

  campoNoValido(campo: string): boolean {
    return (this.recPwdForm.get(campo) ?.invalid && this.formPwdSubmitted ? true : false);

  }

}
