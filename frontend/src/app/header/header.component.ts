import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {MatDialog} from '@angular/material';
import {LoginDialogComponent} from '../login-dialog/login-dialog.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HeaderComponent implements OnInit {
  private isLogado: boolean = localStorage.getItem('codigoUsuLogado') != null;
  
  constructor(public dialog: MatDialog, private router: Router) {
  }
    
  ngOnInit() {
  }

  pesquisaEstacionamento(codigo: number) {
    this.router.navigateByUrl('/parking/'+codigo);
  }

  chamaLogin() {
    let dialogRef = this.dialog.open(LoginDialogComponent, {
      width: '50%'
    });
  }

  logoff() {
    localStorage.removeItem('codigoUsuLogado');
    window.location.reload();
  }
}
