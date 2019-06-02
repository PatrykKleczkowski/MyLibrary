import {NgModule} from '@angular/core';
import {MainPageComponent} from './components/main-page/main-page.component';
import {LoginDialogComponent} from './components/login-dialog/login-dialog.component';
import {RegisterDialogComponent} from './components/register-dialog/register-dialog.component';
import {NavbarComponent} from './components/navbar/navbar.component';

import {HomeRoutingModule} from './home-routing.module';
import {SharedModule} from '@app/shared/shared.module';
import {DialogService} from '@app/shared/service/dialog.service';
import {BookListComponent} from './components/book-list/book-list.component';
import {EditDialogComponent} from './components/edit-dialog/edit-dialog.component';
import {BorrowedBooksComponent} from './components/borrowed-books/borrowed-books.component';
import {NewBookDialogComponent} from './components/new-book-dialog/new-book-dialog.component';
import {NewAuthorDialogComponent} from './components/new-author-dialog/new-author-dialog.component';


@NgModule({
  declarations:
    [
      MainPageComponent,
      LoginDialogComponent,
      RegisterDialogComponent,
      NavbarComponent,
      BookListComponent,
      EditDialogComponent,
      BorrowedBooksComponent,
      NewBookDialogComponent,
      NewAuthorDialogComponent
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
    EditDialogComponent,
    NewBookDialogComponent,
    NewAuthorDialogComponent

  ]
})
export class HomeModule {
}
