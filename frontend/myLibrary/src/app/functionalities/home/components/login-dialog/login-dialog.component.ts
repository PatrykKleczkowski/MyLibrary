import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MatDialogRef} from '@angular/material';
import {ToastrService} from 'ngx-toastr';

import {HttpErrorResponse} from '@angular/common/http';
import {AuthService} from '@app/core/service';
import {UserCredentials} from '@app/shared/model';


@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.scss']
})
export class LoginDialogComponent implements OnInit {

  public loginForm: FormGroup;
  loginFailed: boolean;

  constructor(private authService: AuthService, public dialogRef: MatDialogRef<LoginDialogComponent>,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.loginFailed = false;
    this.loginForm = new FormGroup({
      login: new FormControl(null),
      password: new FormControl(null),
    });
  }

  login() {
    this.authService
      .login(this.getUserCredentials())
      .subscribe(this.onSuccess, this.onFail);

  }

  private getUserCredentials(): UserCredentials {
    const formValue = this.loginForm.value;

    return {
      username: formValue.login,
      password: formValue.password
    };
  }

  private onSuccess = () => {
    this.dialogRef.close();
    window.location.reload();

  }

  private onFail = (error: HttpErrorResponse) => {
    if (error.status === 403) {
      this.toastr.error('Your authentication information is incorrect. Please try again.', 'Error');
    }
  }
}


