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

  constructor(public thisDialogRef: MatDialogRef<LoginDialogComponent>,
    private loginService: ServicoLoginService, private router: Router) {}

  ngOnInit() {
  }

  entrar(email, senha) {
    console.log(email, senha);
    this.loginService.loginUser(email, senha).subscribe(codigo => {
      localStorage.setItem('codigoUsuLogado', codigo);
      this.cancelar();
      window.location.reload();
      
    },
      error => {
        this.cancelar();
        alert("Nao foi possivel efetuar login")
      }, () => console.log("tentou logar"));
  }

  cancelar() {
    this.thisDialogRef.close();
  }

}
