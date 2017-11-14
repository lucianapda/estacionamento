import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {LoginDialogComponent} from '../login-dialog/login-dialog.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  dialogResult = '';

  constructor(public dialog: MatDialog) {}

  ngOnInit() {
  }

  chamaLogin() {
    let dialogRef = this.dialog.open(LoginDialogComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog fechar: ${result}');
      this.dialogResult = result;
    });
  }

}
