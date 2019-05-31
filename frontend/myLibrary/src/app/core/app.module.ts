

import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app-component/app.component';
import {MatButtonModule} from '@angular/material';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {RouterModule, Routes} from '@angular/router';
import 'hammerjs';
import { AuthService, AccessTokenInterceptor } from './service';
import { ToastrModule } from 'ngx-toastr';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatButtonModule,
    SharedModule,
    HttpClientModule,
    RouterModule,
    ToastrModule.forRoot(),
  ],
  providers: [
    AuthService,
   { provide: HTTP_INTERCEPTORS,
    useClass: AccessTokenInterceptor,
    multi: true,
   }
  ],
  bootstrap: [AppComponent],
schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
