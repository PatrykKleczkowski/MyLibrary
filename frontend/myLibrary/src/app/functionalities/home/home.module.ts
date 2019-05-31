import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './components/main-page/main-page.component';
import { LoginDialogComponent } from './components/login-dialog/login-dialog.component';
import { RegisterDialogComponent } from './components/register-dialog/register-dialog.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { HomeRoutingModule } from './home-routing.module';
import { SharedModule } from '@app/shared/shared.module';
import { DialogService } from '@app/shared/service/dialog.service';


@NgModule({
  declarations: 
  [
    MainPageComponent,
    LoginDialogComponent,
    RegisterDialogComponent,
    NavbarComponent
  ],

  imports: [
    SharedModule,
    HomeRoutingModule
  ],
  providers: [
    DialogService
  ],
  entryComponents: [
    LoginDialogComponent,
    RegisterDialogComponent,

  ]
})
export class HomeModule { }
