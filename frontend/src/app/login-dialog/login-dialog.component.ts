import {Component, OnInit, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {

  constructor(public thisDialogRef: MatDialogRef<LoginDialogComponent>) {}

  ngOnInit() {
  }

  entrar(email, senha) {
    console.log(email, senha);

    if (email == 'admin' && senha == 'admin') {
      this.thisDialogRef.close();
    }
  }

  cancelar() {
    this.thisDialogRef.close();
  }

}
