import {ServicoLoginService} from './servico-login.service';
import {Component, OnInit, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  Bntconfirma = false;

  constructor(public thisDialogRef: MatDialogRef<LoginDialogComponent>, private loginService: ServicoLoginService, private router: Router) {}

  ngOnInit() {
  }

  entrar(email, senha) {
    console.log(email, senha);
    this.loginService.loginUser(email, senha).subscribe(codigo => localStorage.setItem('codigoUsuLogado', codigo), error => console.log(error), () => console.log("tentou logar"));
    this.router.navigateByUrl('');
    window.location.reload()
    this.cancelar();
  }

  cancelar() {
    this.thisDialogRef.close();
  }

}
