import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {MatDialog} from '@angular/material';
import {LoginDialogComponent} from '../login-dialog/login-dialog.component';

@Injectable()
export class LoginGuard implements CanActivate {

  constructor(public dialog: MatDialog, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (localStorage.getItem('codigoUsuLogado') == null) {
      this.router.navigateByUrl('');
      let dialogRef = this.dialog.open(LoginDialogComponent, {
        width: '50%'
      });
      return false;
    } else {
      return true;
    }
  }
}
