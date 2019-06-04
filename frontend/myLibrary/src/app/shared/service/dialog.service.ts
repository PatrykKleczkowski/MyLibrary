import {Injectable} from '@angular/core';
import {MatDialog} from '@angular/material';
import {LoginDialogComponent} from '@app/functionalities/home/components/login-dialog/login-dialog.component';
import {RegisterDialogComponent} from '@app/functionalities/home/components/register-dialog/register-dialog.component';
import {EditDialogComponent} from "@features/home/components/edit-dialog/edit-dialog.component";
import {Book} from "@shared/model/Book";
import {NewBookDialogComponent} from "@features/home/components/new-book-dialog/new-book-dialog.component";
import {NewAuthorDialogComponent} from "@features/home/components/new-author-dialog/new-author-dialog.component";


@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(public dialog: MatDialog) {
  }

  openLoginDialog() {
    this.dialog.open(LoginDialogComponent, {
      width: '250px',
      data: {}
    });
  }

  openRegisterDialog() {
    this.dialog.open(RegisterDialogComponent, {
      width: '250px',
      data: {}
    });
  }

  closeAllDialogs() {
    this.dialog.closeAll();
  }

  openEditDialog(book: Book) {
    this.dialog.open(EditDialogComponent, {
      width: '250px',
      data: {
        id: book.id,
        title: book.title,
        author: book.author,
        available: book.available,
        releaseDate: book.releaseDate,
        hireList: book.hireList,
      },
    })
  }

  openNewBookDialog() {
    this.dialog.open(NewBookDialogComponent, {
      width: '250px',
      data: {}
    });
  }

  openNewAuthorDialog() {
    this.dialog.open(NewAuthorDialogComponent, {
      width: '250px',
      data: {}
    });
  }
}
